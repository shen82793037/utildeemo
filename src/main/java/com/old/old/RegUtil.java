package main.java.com.old.old;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtil {

	public static String getPercentageTest(final String contentInput) {
		String pattern = "(([1-9]\\d?)|100|0)%";


		Pattern patternO = Pattern.compile(pattern);
		Matcher matcherO = patternO.matcher(contentInput);

		String percentageGet = "";

		// m.find() 可以执行一下这个返回第一个
		while(matcherO.find()) { // 必须先 find, 这里返回所有的
			// System.out.println(m.group()); 可以打印出所有的
			percentageGet = matcherO.group(); // 这里就是返回最后一个;
		}

		String patternPercent = "%";
		Pattern patternP = Pattern.compile(patternPercent);
		Matcher matcherP = patternP.matcher(percentageGet);

		return matcherP.replaceAll("").trim(); // 删除掉"%"
	}

}
