package com.daijiroh.games.action.share.util;

import java.util.ResourceBundle;

import com.daijiroh.games.action.share.constant.CommonConstant;

public class ResourceUtil {

	/** リソースバンドル */
	private static ResourceBundle resource;

	static {
		// リソースバンドル取得
		resource = ResourceBundle.getBundle(CommonConstant.RESOURCES);
	}

	/**
	 * プロパティファイルから値を取得
	 *
	 * @param key
	 * @return
	 */
	public static String getResource(String key) {
		return resource.getString(key);
	}
}
