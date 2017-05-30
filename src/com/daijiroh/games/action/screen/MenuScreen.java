package com.daijiroh.games.action.screen;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.daijiroh.games.action.share.status.GameStatus;

public class MenuScreen extends BaseScreen {

	// === メニュー1 ===
	/** メニュー名称 */
	private static final String MENU1_NAME = "New Game";
	/** 遷移先画面クラス */
	private static final String MENU1_SCREEN = "com.daijiroh.games.action.screen.StageSelectScreen";
	/** メニュー表示位置：x座標 */
	private static final int MENU1_X = 250;
	/** メニュー表示位置：y座標 */
	private static final int MENU1_Y = 240;

	// === メニュー2 ===
	/** メニュー名称 */
	private static final String MENU2_NAME = "Option";
	/** 遷移先画面クラス */
	private static final String MENU2_SCREEN = "com.daijiroh.games.action.screen.OptionScreen";
	/** メニュー表示位置：x座標 */
	private static final int MENU2_X = 250;
	/** メニュー表示位置：y座標 */
	private static final int MENU2_Y = 260;

	/**
	 * 内部クラス：メニュー
	 */
	static class Menu {

		/** メニュー名称 */
		public String name;
		/** 遷移先画面クラス */
		public String screen;
		/** メニュー表示位置：x座標 */
		public int x;
		/** メニュー表示位置：y座標 */
		public int y;

		/**
		 * コンストラクタ
		 *
		 * @param name メニュー名称
		 * @param screen 遷移先画面クラス
		 * @param x x座標
		 * @param y y座標
		 */
		public Menu(String name, String screen, int x, int y) {
			this.name = name;
			this.screen = screen;
			this.x = x;
			this.y = y;
		}
	}

	/** メニューリスト */
	private static final List<Menu> MENU_LIST;
	/** 選択メニュー */
	private int select = 0;

	static {
		// メニュー生成
		Menu menu1 = new Menu(MENU1_NAME, MENU1_SCREEN, MENU1_X, MENU1_Y);
		Menu menu2 = new Menu(MENU2_NAME, MENU2_SCREEN, MENU2_X, MENU2_Y);

		List<Menu> list = new ArrayList<Menu>();
		list.add(menu1);
		list.add(menu2);

		// メニューリスト初期化
		MENU_LIST = Collections.unmodifiableList(list);
	}

	/**
	 * コンストラクタ
	 *
	 * @param controller
	 */
	public MenuScreen() {
		select = 0;
	}

	/**
	 * 画面の状態を更新する
	 */
	@Override
	public void update() {

		// Enterキー押下時
		if (GameStatus.controller.isKeyEnter()) {
			GameStatus.controller.setKeyEnter(false);
			try {
				// 遷移先画面を設定
				Menu selectedMenu = MENU_LIST.get(select);
				Class<?> clazz = Class.forName(selectedMenu.screen);
				nextScreen = (BaseScreen)clazz.newInstance();

			} catch (Exception e) {
				e.printStackTrace();
			}

		// 下方向キー押下時
		} else if (GameStatus.controller.isKeyDown()) {
			GameStatus.controller.setKeyDown(false);
			if ((select + 1) > (MENU_LIST.size() - 1)) {
				select = 0;
			} else {
				select++;
			}

		// 上方向キー押下時
		} else if (GameStatus.controller.isKeyUp()) {
			GameStatus.controller.setKeyUp(false);
			if ((select - 1) < 0) {
				select = MENU_LIST.size() - 1;
			} else {
				select--;
			}
		}
	}

	/**
	 * 画面を描画する
	 */
	@Override
	public void draw(Graphics g) {

		for (int i=0; i<MENU_LIST.size(); i++) {

			// 描画色を設定
			if (i == select) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLACK);
			}
			// メニューを描画
			Menu menu = MENU_LIST.get(i);
			g.drawString(menu.name, menu.x, menu.y);
		}
	}
}
