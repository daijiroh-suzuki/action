package com.daijiroh.games.action.task;

import java.awt.Color;
import java.awt.Graphics;

public class DebugPanel extends Task {

	/** x, y座標 */
	private int x, y;
	/** 幅 */
	private int width;
	/** 高さ */
	private int height;

	/**
	 * コンストラクタ
	 *
	 * @param x 初期表示位置x座標
	 * @param y 初期表示位置y座標
	 */
	public DebugPanel() {

		this.priority = 2.0f;                 // 優先度
		this.category = Task.CATEGORY_OTHER;  // カテゴリー
		this.deleteFlag = false;              // 削除フラグ

		this.x = 5;                           // x座標
		this.y = 5;                           // y座標
		this.width = 300;                     // 幅
		this.height = 150;                    // 高さ
	}

	/**
	 * デバックパネルの状態を更新する
	 */
	@Override
	public void update() {
	}

	/**
	 * デバックパネルを描画する
	 */
	@Override
	public void draw(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}

}
