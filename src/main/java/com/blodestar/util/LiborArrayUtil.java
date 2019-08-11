package main.java.com.blodestar.util;

public final class LiborArrayUtil {
	public static boolean containsString(String[] strings, String stringInput) {
		boolean flag = false;
		for (int i = 0, len = strings.length; i < len; i++) {
			if (stringInput.equals(strings[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
