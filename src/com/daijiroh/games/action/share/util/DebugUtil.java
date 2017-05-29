package com.daijiroh.games.action.share.util;

import com.daijiroh.games.action.share.constant.CommonConstant;

public class DebugUtil {

	/**
	 * 標準出力にデバックメッセージを出力
	 *
	 * @param msg
	 */
	public static void println(String msg) {

		if (CommonConstant.DEBUG_FLG) {
			System.out.println(msg);
		}
	}

	/**
	 * 標準出力にデバックメッセージを出力
	 *
	 * @param msg
	 */
	public static void print(String msg) {

		if (CommonConstant.DEBUG_FLG) {
			System.out.print(msg);
		}
	}
}
