package com.daijiroh.games.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.daijiroh.games.action.screen.BaseScreen;
import com.daijiroh.games.action.screen.TitleScreen;
import com.daijiroh.games.action.share.status.GameStatus;

public class MainPanel extends JPanel implements Runnable {

	/** パネルの幅 */
	private static final int WIDTH = 640;
	/** パネルの高さ */
	private static final int HEIGHT = 480;

	/** 1フレームで使える時間(ナノ秒) */
	private static final long PERIOD = 20 * 1000000L;

	/** ダブルバッファリング用 Graphics */
	private Graphics dbg;
	/** ダブルバッファリング用 Image */
	private Image dbImage = null;

	/** ゲームループ */
	private Thread gameLoop;

	/** 画面オブジェクト */
	private BaseScreen screen;

//	/** フレームカウント */
//	private long frameCount = 0L;

	/**
	 * コンストラクタ
	 */
	public MainPanel() {
		// パネルサイズの設定
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		// フォーカスを設定
		setFocusable(true);

		// キーリスナーの追加
		addKeyListener(GameStatus.controller);

		// ゲームループ開始
		gameLoop = new Thread(this);
		gameLoop.start();
	}

	/**
	 * ゲームループ
	 */
	@Override
	public void run() {

		long beforeTime, afterTime, timeDiff, sleepTime;
		long overSleepTime = 0L;
		int noDelays = 0;

		// タイトル画面を生成
		screen = new TitleScreen();

		// 状態更新・レンダリング前の時間を取得
		beforeTime = System.nanoTime();

		while (true) {
			gameUpdate();   // ゲーム状態を更新
			gameRender();   // バッファにレンダリング
			printScreen();  // バッファを画面に描画

			// 状態更新・レンダリング後の時間を取得
			afterTime = System.nanoTime();
			// 状態更新・レンダリング時間を計算
			timeDiff = afterTime - beforeTime;

			// 前回のフレーム休止時間誤差を引く
			sleepTime = (PERIOD - timeDiff) - overSleepTime;

			if (sleepTime > 0) {
				// 休止時間がとれる場合
				try {
					Thread.sleep(sleepTime / 1000000L);  // nano->ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// sleep()の誤差
				overSleepTime = (System.nanoTime() - afterTime) - sleepTime;

			} else {
				// 状態更新・レンダリングで時間を使い切ってしまい
				// 休止時間がとれない場合
				overSleepTime = 0L;
				// 休止なしが16回以上続いたら
				if (++noDelays >= 16) {
					Thread.yield();  // 他スレッドにCPUを譲る
					noDelays = 0;
				}
			}
			// 状態更新・レンダリング前の時間を取得
			beforeTime = System.nanoTime();

			// FPSを計算
		}
	}

	/**
	 * ゲーム状態を更新
	 */
	private void gameUpdate() {

		// 画面情報を更新
		screen.update();

		// 画面遷移
		BaseScreen nextScreen = screen.getNextScreen();
		if (nextScreen != null) {
			screen = nextScreen;
		}
	}

	/**
	 * バッファにレンダリング（ダブルバッファリング）
	 */
	private void gameRender() {
		// 初回の呼出し時にダブルバッファリング用オブジェクトを作成
		if (dbImage == null) {
			// バッファイメージを作成
			dbImage = createImage(WIDTH, HEIGHT);
			if (dbImage == null) {
				System.out.println("dbImageが作成できません。");
				return;
			} else {
				// バッファイメージの描画オブジェクト
				dbg = dbImage.getGraphics();
			}
		}

		// バッファをクリアをする
		dbg.setColor(Color.WHITE);
		dbg.fillRect(0, 0, WIDTH, HEIGHT);

		// 画面を描画
		screen.draw(dbg);
	}

	/**
	 * バッファを画面に描画
	 */
	private void printScreen() {
		try {
			// グラフィックスオブジェクトを取得
			Graphics g = getGraphics();
			if ((g != null) && (dbImage != null)) {
				// バッファイメージを画面に描画
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync();
			if (g != null) {
				// グラフィックスオブジェクトを破棄
				g.dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private void calcFPS() {
//
//		frameCount++;
//
//	}
}
