package com.daijiroh.games.action.task;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.daijiroh.games.action.share.status.GameStatus;

public class Player extends Task {

	/** 画像イメージサイズ */
	private final int IMAGE_SIZE = 31;

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
	/** 攻撃フラグ */
	private boolean attack;
	/** 移動フラグ */
	private boolean move;

	/** 画像イメージ */
	private Image image;

	/** フレームカウント */
	private int frameCount;

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
		this.width = IMAGE_SIZE;              // 幅
		this.height = IMAGE_SIZE;             // 高さ
		this.aerial = false;                  // 空中フラグ
		this.attack = false;                  // 攻撃フラグ
		this.move = false;                    // 移動フラグ

		// 画像をロード
		loadImage();
	}

	/**
	 * プレイヤーの状態を更新する
	 */
	@Override
	public void update() {

		// フレームカウント更新
		frameCount++;

		// 座標を更新
		x += vx;
		y += vy;

		// 右方向キー押下時
		if (GameStatus.controller.isKeyRight()) {
			vx = 3;
			move = true;
		// 左方向キー押下時
		} else if (GameStatus.controller.isKeyLeft()) {
			vx = -3;
			move = true;
		} else {
			vx = 0;
			move = false;
		}

		// Bボタン押下時
		if (GameStatus.controller.isKeyB() && !aerial) {
			vy = -10;
			aerial = true;
		}

		// Aボタン押下時
		if (GameStatus.controller.isKeyA()) {
			attack = true;
		} else {
			attack = false;
		}

		// 重力加速度
		vy += 1;

		// 床判定
		if (y >= 240) {
			y = 240;
			aerial = false;
		}
	}

	/**
	 * プレイヤーを描画する
	 */
	@Override
	public void draw(Graphics g) {

		int frm = 0;
		int action = 0;

		if (aerial && attack) {       // ジャンプ攻撃中
			action = 5;
		} else if (aerial) {          // ジャンプ中
			action = 2;
		} else if (move && attack) {  // 移動攻撃中
			action = 4;
			if (frameCount % 50 == 0) {
				if (++frm >= 3) {
					frm = 0;
				}
			}
		} else if (move) {            // 移動中
			action = 1;
			if (frameCount % 50 == 0) {
				if (++frm >= 3) {
					frm = 0;
				}
			}
			frm = (frameCount % 50) % 3;
		} else if (attack) {          // 攻撃中
			action = 3;
		} else {                      // 停止中
			action = 0;
		}

		g.drawImage(
				image,                // 画像イメージ
				x,                    // 描画位置：左上x座標
				y,                    // 描画位置：左上y座標
				x + (width  - 1),     // 描画位置：右下x座標
				y + (height - 1),     // 描画位置：右下y座標
				IMAGE_SIZE * frm,     // 画像ソース：左上x座標
				IMAGE_SIZE * action,  // 
				IMAGE_SIZE * frm    + (IMAGE_SIZE - 1),
				IMAGE_SIZE * action + (IMAGE_SIZE - 1),
				null);

//		if (aerial) {
//			g.setColor(Color.RED);
//		} else {
//			g.setColor(Color.BLUE);
//		}
//		g.fillRect(x, y, width, height);
	}

	/**
	 * 画像をロードする
	 */
	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("image/player.gif"));
		image = icon.getImage();
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
