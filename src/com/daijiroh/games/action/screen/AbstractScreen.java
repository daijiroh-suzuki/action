package com.daijiroh.games.action.screen;

import java.awt.Graphics;

import com.daijiroh.games.action.controller.BasicController;

public abstract class AbstractScreen {

	/** コントローラー */
	protected BasicController controller;

	/** 次画面 */
	protected AbstractScreen nextScreen;

	/**
	 * コンストラクタ
	 *
	 * @param controller
	 */
	public AbstractScreen(BasicController controller) {
		this.controller = controller;
	}

	/**
	 * 画面の状態を更新する
	 */
	public abstract void update();

	/**
	 * 画面を描画する
	 *
	 * @param g
	 */
	public abstract void draw(Graphics g);

	/**
	 * 次画面を取得する
	 *
	 * @return
	 */
	public AbstractScreen getNextScreen() {
		return nextScreen;
	}
}
