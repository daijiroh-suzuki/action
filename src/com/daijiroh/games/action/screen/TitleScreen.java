package com.daijiroh.games.action.screen;

import java.awt.Color;
import java.awt.Graphics;

import com.daijiroh.games.action.controller.BasicController;

public class TitleScreen extends AbstractScreen {

	/** タイトル：x座標 */
	private static final int TITLE_X = 250;
	/** タイトル：y座標 */
	private static final int TITLE_Y = 240;

	/** 点滅文字列：x座標 */
	private static final int MESSAGE_X = 260;
	/** 点滅文字列：y座標 */
	private static final int MESSAGE_Y = 290;

	/** 文字列点滅間隔(フレーム数) */
	private static final int VISIBLE_INTERVAL = 20;

	/** フレームカウント */
	private int frameCount = 0;

	/** 文字列点滅用フラグ */
	private boolean visibleFlg = false;

	/**
	 * コンストラクタ
	 *
	 * @param controller
	 */
	public TitleScreen(BasicController controller) {
		super(controller);
		frameCount = 0;
	}

	/**
	 * 画面の状態を更新する
	 */
	@Override
	public void update() {

		// Enterキー押下時に次画面へ遷移
		if (controller.isKeyEnter()) {
			controller.setKeyEnter(false);
			nextScreen = new MenuScreen(controller);
		} else {
			nextScreen = null;
		}

		// フレームカウントを更新
		frameCount++;

		// 文字列点滅用フラグの更新
		if ((frameCount % VISIBLE_INTERVAL) == 0) {
			visibleFlg = !visibleFlg;
			frameCount = 0;
		}
	}

	/**
	 * 画面を描画する
	 */
	@Override
	public void draw(Graphics g) {

		// タイトルを描画する
		g.setColor(Color.BLACK);
		g.drawString("アクションプロトタイプ", TITLE_X, TITLE_Y);

		// 点滅文字列を表示する
		if (visibleFlg) {
			g.drawString("Press to Enter key", MESSAGE_X, MESSAGE_Y);
		}
	}
}
