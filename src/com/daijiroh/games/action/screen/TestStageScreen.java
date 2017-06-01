package com.daijiroh.games.action.screen;

import java.awt.Graphics;

import com.daijiroh.games.action.share.util.DebugUtil;
import com.daijiroh.games.action.task.DebugPanel;
import com.daijiroh.games.action.task.Player;
import com.daijiroh.games.action.task.TaskList;

public class TestStageScreen extends BaseScreen {

	/**
	 * コンストラクタ
	 *
	 * @param controller
	 */
	public TestStageScreen() {

		// タスクリストを初期化
		TaskList.init();

		// タスクリストにプレイヤーを追加
		TaskList.add(new Player(320, 240));

		// タスクリストにデバックパネルを追加
		if (DebugUtil.isDebugMode()) {
			TaskList.add(new DebugPanel());
		}
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
