package com.daijiroh.games.action.task;

import java.awt.Color;
import java.awt.Graphics;

import com.daijiroh.games.action.share.status.GameStatus;

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

		if (GameStatus.controller.isKeyUp()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("↑", x+5+30, y+15);

		if (GameStatus.controller.isKeyRight()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("→", x+5+60, y+15+30);

		if (GameStatus.controller.isKeyDown()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("↓", x+5+30, y+15+60);

		if (GameStatus.controller.isKeyLeft()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("←", x+5, y+15+30);

		if (GameStatus.controller.isKeyA()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("A", x+60, y+15);

		if (GameStatus.controller.isKeyB()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("B", x+80, y+15);

		if (GameStatus.controller.isKeyEnter()) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawString("Enter", x+100, y+15);

		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(GameStatus.actualFPS), x+5, y+15+80);
	}

}
