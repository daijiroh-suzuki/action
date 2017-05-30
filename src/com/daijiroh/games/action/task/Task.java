package com.daijiroh.games.action.task;

import java.awt.Graphics;

public abstract class Task {

	/** カテゴリー：自機 */
	protected static final int CATEGORY_PLAYER = 0;
	/** カテゴリー：自機攻撃 */
	protected static final int CATEGORY_PLAYER_ATTACK = 1;
	/** カテゴリー：敵 */
	protected static final int CATEGORY_ENEMY = 2;
	/** カテゴリー：敵攻撃 */
	protected static final int CATEGORY_ENEMY_ATTACK = 3;
	/** カテゴリー：ステージ */
	protected static final int CATEGORY_STAGE = 4;

	/** 優先度 */
	protected float priority = 1.0f;
	/** カテゴリー */
	protected int category;
	/** 削除フラグ */
	protected boolean deleteFlag = false;

	/** タスクの状態を更新 */
	public abstract void update();
	/** タスクを描画 */
	public abstract void draw(Graphics g);

	/**
	 * 優先度を設定
	 *
	 * @param priority
	 */
	public void setPriority(float priority) {
		this.priority = priority;
	}
	/**
	 * 優先度を取得
	 *
	 * @return
	 */
	public float getPriority() {
		return priority;
	}

	/**
	 * カテゴリーを設定
	 *
	 * @param category
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	/**
	 * カテゴリーを取得
	 *
	 * @return
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * 削除フラグを取得
	 *
	 * @param deleteFlag
	 */
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 削除フラグを設定
	 *
	 * @return
	 */
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
}
