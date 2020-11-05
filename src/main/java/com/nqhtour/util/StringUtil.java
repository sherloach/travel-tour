package com.nqhtour.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtil {
	public static String createSlug(String tourName) {
		String temp = Normalizer.normalize(tourName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String code = pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
        String[] codes = code.split(" ");
        StringBuilder codeNew = new StringBuilder(codes[0]);

        for(int i=1;i<codes.length;i++) codeNew.append("-"+codes[i]);
        return codeNew.toString().toLowerCase();
	}
}
