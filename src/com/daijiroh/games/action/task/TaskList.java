package com.daijiroh.games.action.task;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class TaskList {

	private static List<Task> list;
	static {
		// タスクリストの初期化
		list = new LinkedList<Task>();
	}

	/**
	 * タスクリストの初期化
	 */
	public static void init() {
		list = new LinkedList<Task>();
	}

	/**
	 * タスクリストにタスクを追加
	 *
	 * @param task
	 */
	public static void add(Task task) {

		// 追加するタスクの優先度
		float priority = task.getPriority();

		// タスクリスト内の優先度の低いタスクの前に追加
		for (int i=0; i<list.size(); i++) {
			if (priority < list.get(i).getPriority()) {
				list.add(i, task);
				return;
			}
		}
		// リストの末尾に追加
		list.add(task);
	}

	/**
	 * タスクリストからタスクを取得
	 *
	 * @param index
	 * @return
	 */
	public static Task get(int index) {
		return list.get(index);
	}

	/**
	 * タスクリストの要素数を取得
	 *
	 * @return
	 */
	public static int size() {
		return list.size();
	}

	/**
	 * タスクリスト内のタスクの状態を更新
	 */
	public static void update() {

		for (Task task : list) {
			task.update();
		}
	}

	/**
	 * タスクリスト内のタスクを描画
	 *
	 * @param g
	 */
	public static void draw(Graphics g) {

		for (Task task : list) {
			task.draw(g);
		}
	}
}
