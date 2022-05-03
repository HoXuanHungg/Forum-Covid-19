package com.dg3.forum.forum.util;

import org.apache.commons.io.FilenameUtils;

public class GetNameExtensionsForbase64 {
	/**
	 * format prefix for base 64
	 * @param nameFile
	 * @return prefix for base 64
	 */
	public static String getPartExtensions(String nameFile) {
		return "data:image/"+FilenameUtils.getExtension(nameFile)+";base64,";
	}
	
}
