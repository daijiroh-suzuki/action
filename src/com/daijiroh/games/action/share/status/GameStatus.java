package com.daijiroh.games.action.share.status;

import com.daijiroh.games.action.controller.BasicController;

public class GameStatus {

	/** コントローラー */
	public static BasicController controller;

	/** 1秒ごとの処理フレーム数 */
	public static double actualFPS;

	static {
		controller = new BasicController();
	}
}
