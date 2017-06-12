package com.daijiroh.games.action.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BasicController implements KeyListener {

	/** 上方向キーフラグ */
	private boolean keyUp = false;
	/** 下方向キーフラグ */
	private boolean keyDown = false;
	/** 右方向キーフラグ */
	private boolean keyRight = false;
	/** 左方向キーフラグ */
	private boolean keyLeft = false;
	/** Enterキーフラグ */
	private boolean keyEnter = false;
	/** Aボタンキーフラグ */
	private boolean keyA = false;
	/** Bボタンキーフラグ */
	private boolean keyB = false;

	/**
	 * キーが押されたときの処理
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		// 押されたキーのフラグをオンにする
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
//			DebugUtil.println("上方向キーが押されました。");
			keyUp = true;
			break;
		case KeyEvent.VK_DOWN:
//			DebugUtil.println("下方向キーが押されました。");
			keyDown = true;
			break;
		case KeyEvent.VK_RIGHT:
//			DebugUtil.println("右方向キーが押されました。");
			keyRight = true;
			break;
		case KeyEvent.VK_LEFT:
//			DebugUtil.println("左方向キーが押されました。");
			keyLeft = true;
			break;
		case KeyEvent.VK_ENTER:
//			DebugUtil.println("Enterキーが押されました。");
			keyEnter = true;
			break;
		case KeyEvent.VK_A:
//			DebugUtil.println("Aボタンキーが押されました。");
			keyA = true;
			break;
		case KeyEvent.VK_B:
//			DebugUtil.println("Bボタンキーが押されました。");
			keyB = true;
			break;
		}
	}

	/**
	 * キーが離された時の処理
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		// 離されたキーのフラグをオフにする
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
//			DebugUtil.println("上方向キーが離されました。");
			keyUp = false;
			break;
		case KeyEvent.VK_DOWN:
//			DebugUtil.println("下方向キーが離されました。");
			keyDown = false;
			break;
		case KeyEvent.VK_RIGHT:
//			DebugUtil.println("右方向キーが離されました。");
			keyRight = false;
			break;
		case KeyEvent.VK_LEFT:
//			DebugUtil.println("左方向キーが離されました。");
			keyLeft = false;
			break;
		case KeyEvent.VK_ENTER:
//			DebugUtil.println("Enterキーが離されました。");
			keyEnter = false;
			break;
		case KeyEvent.VK_A:
//			DebugUtil.println("Aボタンキーが離されました。");
			keyA = false;
			break;
		case KeyEvent.VK_B:
//			DebugUtil.println("Bボタンキーが離されました。");
			keyB = false;
			break;
		}
	}

	/**
	 * キーがタイプされた時の処理
	 */
	@Override
	public void keyTyped(KeyEvent e) {}

	/**
	 * 上方向キーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyUp() {
		return keyUp;
	}
	/**
	 * 上方向キーフラグを設定する
	 *
	 * @param keyup
	 */
	public void setKeyUp(boolean keyUp) {
		this.keyUp = keyUp;
	}

	/**
	 * 下方向キーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyDown() {
		return keyDown;
	}
	/**
	 * 下方向キーフラグを設定する
	 *
	 * @param keyDown
	 */
	public void setKeyDown(boolean keyDown) {
		this.keyDown = keyDown;
	}

	/**
	 * 右方向キーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyRight() {
		return keyRight;
	}
	/**
	 * 右方向キーフラグを設定する
	 *
	 * @param keyRight
	 */
	public void setKeyRight(boolean keyRight) {
		this.keyRight = keyRight;
	}

	/**
	 * 左方向キーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyLeft() {
		return keyLeft;
	}
	/**
	 * 左方向キーフラグを設定する
	 *
	 * @param keyLeft
	 */
	public void setKeyLeft(boolean keyLeft) {
		this.keyLeft = keyLeft;
	}

	/**
	 * Enterキーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyEnter() {
		return keyEnter;
	}
	/**
	 * Enterキーフラグを設定する
	 *
	 * @param keyEnter
	 */
	public void setKeyEnter(boolean keyEnter) {
		this.keyEnter = keyEnter;
	}

	/**
	 * Aボタンキーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyA() {
		return keyA;
	}
	/**
	 * Aボタンキーフラグを設定する
	 *
	 * @param keyA
	 */
	public void setKeyA(boolean keyA) {
		this.keyA = keyA;
	}

	/**
	 * Bボタンキーフラグを取得する
	 *
	 * @return
	 */
	public boolean isKeyB() {
		return keyB;
	}
	/**
	 * Bボタンキーフラグを設定する
	 *
	 * @param keyB
	 */
	public void setKeyB(boolean keyB) {
		this.keyB = keyB;
	}
}
