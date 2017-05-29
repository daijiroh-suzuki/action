package com.daijiroh.games.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.daijiroh.games.action.controller.BasicController;
import com.daijiroh.games.action.screen.AbstractScreen;
import com.daijiroh.games.action.screen.TitleScreen;

public class MainPanel extends JPanel implements Runnable {

	/** パネルの幅 */
	public static final int WIDTH = 640;
	/** パネルの高さ */
	public static final int HEIGHT = 480;

	/** ダブルバッファリング用 Graphics */
	private Graphics dbg;
	/** ダブルバッファリング用 Image */
	private Image dbImage = null;

	/** ゲームループ */
	private Thread gameLoop;

	/** コントローラーオブジェクト */
	private BasicController controller;

	/** 画面オブジェクト */
	private AbstractScreen screen;

	/**
	 * コンストラクタ
	 */
	public MainPanel() {
		// パネルサイズの設定
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		// フォーカスを設定
		setFocusable(true);

		// コントローラーオブジェクトを生成
		controller = new BasicController();

		// キーリスナーの追加
		addKeyListener(controller);

		// ゲームループ開始
		gameLoop = new Thread(this);
		gameLoop.start();
	}

	/**
	 * ゲームループ
	 */
	@Override
	public void run() {

		// タイトル画面を生成
		screen = new TitleScreen(controller);

		while (true) {
			// ゲーム状態を更新
			gameUpdate();
			// バッファにレンダリング
			gameRender();
			// バッファを画面に描画
			printScreen();

			// 休止
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ゲーム状態を更新
	 */
	private void gameUpdate() {

		// 画面情報を更新
		screen.update();

		// 画面遷移
		AbstractScreen nextScreen = screen.getNextScreen();
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
}
