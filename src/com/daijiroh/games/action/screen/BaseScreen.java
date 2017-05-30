package com.daijiroh.games.action.screen;

import java.awt.Graphics;

public abstract class BaseScreen {

	/** 次画面 */
	protected BaseScreen nextScreen;

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
	public BaseScreen getNextScreen() {
		return nextScreen;
	}
}
