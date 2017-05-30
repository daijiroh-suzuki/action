package com.daijiroh.games.action.task;

import java.awt.Color;
import java.awt.Graphics;

import com.daijiroh.games.action.share.status.GameStatus;

public class Player extends Task {

	/** x, y座標 */
	private int x, y;
	/** x方向速度 */
	private int vx;
	/** y方向速度 */
	private int vy;
	/** 幅 */
	private int width;
	/** 高さ */
	private int height;

	/** 空中フラグ */
	private boolean aerial;

	/**
	 * コンストラクタ
	 *
	 * @param x 初期表示位置x座標
	 * @param y 初期表示位置y座標
	 */
	public Player(int x, int y) {

		this.priority = 1.0f;                 // 優先度
		this.category = Task.CATEGORY_PLAYER; // カテゴリー
		this.deleteFlag = false;              // 削除フラグ

		this.x = x;                           // x座標
		this.y = y;                           // y座標
		this.vx = 0;                          // x方向速度
		this.vy = 0;                          // y方向速度
		this.width = 31;                      // 幅
		this.height = 31;                     // 高さ
		this.aerial = false;                  // 空中フラグ
	}

	/**
	 * プレイヤーの状態を更新する
	 */
	@Override
	public void update() {

		// 右方向キー押下時
		if (GameStatus.controller.isKeyRight()) {
			vx = 3;
		// 左方向キー押下時
		} else if (GameStatus.controller.isKeyLeft()) {
			vx = -3;
		} else {
			vx = 0;
		}

		// Bボタン押下時
		if (GameStatus.controller.isKeyB()) {
			vy = 10;
		}

		// 重力加速度
		vy += 1;

		// 床判定
		if (y <= 240) {
			y = 240;
			vy = 0;
		}

		// 座標を更新
		x += vx;
		y += vy;
	}

	/**
	 * プレイヤーを描画する
	 */
	@Override
	public void draw(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	/**
	 * x座標を設定する
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * x座標を取得する
	 *
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * y座標を設定する
	 *
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * y座標を取得する
	 *
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * x方向速度を設定する
	 *
	 * @param vx
	 */
	public void setVx(int vx) {
		this.vx = vx;
	}
	/**
	 * x方向速度を取得する
	 *
	 * @return
	 */
	public int getVx() {
		return vx;
	}

	/**
	 * y方向速度を設定する
	 *
	 * @param vy
	 */
	public void setVy(int vy) {
		this.vy = vy;
	}
	/**
	 * y方向速度を取得する
	 *
	 * @return
	 */
	public int getVy() {
		return vy;
	}

	/**
	 * 幅を設定する
	 *
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * 幅を取得する
	 *
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 高さを設定する
	 *
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * 高さを取得する
	 *
	 * @return
	 */
	public int getHeight() {
		return height;
	}
}
