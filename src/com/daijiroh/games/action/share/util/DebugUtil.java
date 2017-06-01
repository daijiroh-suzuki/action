package com.daijiroh.games.action.share.util;

import com.daijiroh.games.action.share.constant.CommonConstant;

public class DebugUtil {

	/**
	 * デバックモード判定
	 *
	 * @return
	 */
	public static boolean isDebugMode() {

		if (CommonConstant.DEBUG_FLG) {
			return true;
		}
		return false;
	}

	/**
	 * 標準出力にデバックメッセージを出力
	 *
	 * @param msg
	 */
	public static void println(String msg) {

		if (isDebugMode()) {
			System.out.println(msg);
		}
	}

	/**
	 * 標準出力にデバックメッセージを出力
	 *
	 * @param msg
	 */
	public static void print(String msg) {

		if (isDebugMode()) {
			System.out.print(msg);
		}
	}
}
