package com.daijiroh.games.action;

import javax.swing.JFrame;

public class ActionFrame extends JFrame {

	/**
	 * コンストラクタ
	 */
	public ActionFrame() {
		// タイトルを設定
		setTitle("アクションプロトタイプ");
		// メインパネルを生成
		MainPanel panel = new MainPanel();
		// メインパネルをフレームに追加
		this.getContentPane().add(panel);

		pack();
	}

	/**
	 * エントリポイント
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// フレームを生成
		ActionFrame frame = new ActionFrame();
		// 閉じるボタン押下時の処理を設定
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// フレームの表示位置を設定
		frame.setLocationRelativeTo(null);
		// フレームを表示
		frame.setVisible(true);
	}
}
