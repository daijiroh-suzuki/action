package com.daijiroh.games.action.screen;

import java.awt.Graphics;

import com.daijiroh.games.action.task.Player;
import com.daijiroh.games.action.task.TaskList;

public class TestStageScreen extends BaseScreen {

	/**
	 * コンストラクタ
	 *
	 * @param controller
	 */
	public TestStageScreen() {

		// プレイヤーを生成
		Player player = new Player(320, 240);

		// タスクリストを初期化
		TaskList.init();
		// タスクリストに追加
		TaskList.add(player);
	}

	/**
	 * 画面の状態を更新する
	 */
	@Override
	public void update() {

		// タスクの状態を更新
		TaskList.update();
	}

	/**
	 * 画面を描画する
	 */
	@Override
	public void draw(Graphics g) {

		// タスクを描画
		TaskList.draw(g);
	}
}
