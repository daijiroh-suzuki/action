package com.daijiroh.games.action.screen;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daijiroh.games.action.controller.BasicController;

public class StageSelectScreen extends AbstractScreen {

	// ==== ステージ1 ===
	/** ステージ名称 */
	private static final String STAGE1_NAME = "Stage A（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE1_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE1_X = 10;
	/** ステージ表示：y座標 */
	private static final int STAGE1_Y = 10;
	/** ステージ表示：幅 */
	private static final int STAGE1_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE1_H = 100;

	// === ステージ2 ===
	/** ステージ名称 */
	private static final String STAGE2_NAME = "Stage B（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE2_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE2_X = 166;
	/** ステージ表示：y座標 */
	private static final int STAGE2_Y = 10;
	/** ステージ表示：幅 */
	private static final int STAGE2_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE2_H = 100;

	// === ステージ3 ===
	/** ステージ名称 */
	private static final String STAGE3_NAME = "Stage C（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE3_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE3_X = 322;
	/** ステージ表示：y座標 */
	private static final int STAGE3_Y = 10;
	/** ステージ表示：幅 */
	private static final int STAGE3_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE3_H = 100;

	// === ステージ4 ===
	/** ステージ名称 */
	private static final String STAGE4_NAME = "Stage D（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE4_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE4_X = 478;
	/** ステージ表示：y座標 */
	private static final int STAGE4_Y = 10;
	/** ステージ表示：幅 */
	private static final int STAGE4_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE4_H = 100;

	// === ステージ5 ===
	/** ステージ名称 */
	private static final String STAGE5_NAME = "Stage E（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE5_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE5_X = 10;
	/** ステージ表示：y座標 */
	private static final int STAGE5_Y = 370;
	/** ステージ表示：幅 */
	private static final int STAGE5_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE5_H = 100;

	// === ステージ6 ===
	/** ステージ名称 */
	private static final String STAGE6_NAME = "Stage F（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE6_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE6_X = 168;
	/** ステージ表示：y座標 */
	private static final int STAGE6_Y = 370;
	/** ステージ表示：幅 */
	private static final int STAGE6_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE6_H = 100;

	// === ステージ7 ===
	/** ステージ名称 */
	private static final String STAGE7_NAME = "Stage G（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE7_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE7_X = 322;
	/** ステージ表示：y座標 */
	private static final int STAGE7_Y = 370;
	/** ステージ表示：幅 */
	private static final int STAGE7_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE7_H = 100;

	// === ステージ8 ===
	/** ステージ名称 */
	private static final String STAGE8_NAME = "Stage H（仮）";
	/** 遷移先画面クラス */
	private static final String STAGE8_CLAZZ = "";
	/** ステージ表示：x座標 */
	private static final int STAGE8_X = 478;
	/** ステージ表示：y座標 */
	private static final int STAGE8_Y = 370;
	/** ステージ表示：幅 */
	private static final int STAGE8_W = 151;
	/** ステージ表示：高さ */
	private static final int STAGE8_H = 100;

	/**
	 * 内部クラス：ステージ
	 */
	static class Stage {

		/** ステージ名称 */
		public String name;
		/** 遷移先画面クラス */
		public String clazz;
		/** ステージ表示：x座標 */
		public int x;
		/** ステージ表示：y座標 */
		public int y;
		/** ステージ表示：幅 */
		public int w;
		/** ステージ表示：高さ */
		public int h;

		/**
		 * コンストラクタ
		 *
		 * @param name ステージ名称
		 * @param clazz 遷移先画面クラス
		 * @param x x座標
		 * @param y y座標
		 */
		public Stage(String name, String clazz, int x, int y, int w, int h) {
			this.name = name;
			this.clazz = clazz;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}

	/** ステージリスト */
	private static final List<Stage> STAGE_LIST;
	/** 選択ステージ */
	private int select = 0;

	static {
		// ステージ生成
		Stage stage1 = new Stage(STAGE1_NAME, STAGE1_CLAZZ, STAGE1_X, STAGE1_Y, STAGE1_W, STAGE1_H);
		Stage stage2 = new Stage(STAGE2_NAME, STAGE2_CLAZZ, STAGE2_X, STAGE2_Y, STAGE2_W, STAGE2_H);
		Stage stage3 = new Stage(STAGE3_NAME, STAGE3_CLAZZ, STAGE3_X, STAGE3_Y, STAGE3_W, STAGE3_H);
		Stage stage4 = new Stage(STAGE4_NAME, STAGE4_CLAZZ, STAGE4_X, STAGE4_Y, STAGE4_W, STAGE4_H);
		Stage stage5 = new Stage(STAGE5_NAME, STAGE5_CLAZZ, STAGE5_X, STAGE5_Y, STAGE5_W, STAGE5_H);
		Stage stage6 = new Stage(STAGE6_NAME, STAGE6_CLAZZ, STAGE6_X, STAGE6_Y, STAGE6_W, STAGE6_H);
		Stage stage7 = new Stage(STAGE7_NAME, STAGE7_CLAZZ, STAGE7_X, STAGE7_Y, STAGE7_W, STAGE7_H);
		Stage stage8 = new Stage(STAGE8_NAME, STAGE8_CLAZZ, STAGE8_X, STAGE8_Y, STAGE8_W, STAGE8_H);

		List<Stage> list = new ArrayList<Stage>();
		list.add(stage1);
		list.add(stage2);
		list.add(stage3);
		list.add(stage4);
		list.add(stage5);
		list.add(stage6);
		list.add(stage7);
		list.add(stage8);

		// ステージリスト初期化
		STAGE_LIST = Collections.unmodifiableList(list);
	}

	/**
	 * コンストラクタ
	 *
	 * @param controller
	 */
	public StageSelectScreen(BasicController controller) {
		super(controller);
		select = 0;
	}

	/**
	 * 画面の状態を更新する
	 */
	@Override
	public void update() {

		// Enterキー押下時
		if (controller.isKeyEnter()) {
			controller.setKeyEnter(false);
			try {
				// 遷移先画面を設定
				Stage stage = STAGE_LIST.get(select);
				Class<?> clazz = Class.forName(stage.clazz);
				Class<?>[] types = { BasicController.class };
				Constructor<?> constructor = clazz.getConstructor(types);

				Object[] args = { this.controller };
				nextScreen = (AbstractScreen)constructor.newInstance(args);

			} catch (Exception e) {
				e.printStackTrace();
			}

		// 右方向キー押下時
		} else if (controller.isKeyRight()) {
			controller.setKeyRight(false);
			if ((select + 1) > (STAGE_LIST.size() - 1)) {
				select = 0;
			} else {
				select++;
			}

		// 左方向キー押下時
		} else if (controller.isKeyLeft()) {
			controller.setKeyLeft(false);
			if ((select - 1) < 0) {
				select = STAGE_LIST.size() - 1;
			} else {
				select--;
			}

		// 上方向キー押下時
		} else if (controller.isKeyUp()) {
			controller.setKeyUp(false);
			if ((select - 4) < 0) {
				select += 4;
			} else {
				select -= 4;
			}

		// 下方向キー押下時
		} else if (controller.isKeyDown()) {
			controller.setKeyDown(false);
			if ((select + 4) > (STAGE_LIST.size() - 1)) {
				select -= 4;
			} else {
				select += 4;
			}
		}
	}

	/**
	 * 画面を描画する
	 */
	@Override
	public void draw(Graphics g) {

		for (int i=0; i<STAGE_LIST.size(); i++) {

			// 描画色を設定
			if (i == select) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}

			// ステージを描画
			Stage stage = STAGE_LIST.get(i);
			g.drawString(stage.name, stage.x, stage.y);
			g.drawRect(stage.x, stage.y, stage.w, stage.h);
		}
	}
}
