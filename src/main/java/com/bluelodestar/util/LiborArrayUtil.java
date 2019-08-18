package main.java.com.bluelodestar.util;

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

	public static String integerArrayToString(int[] arrayInput) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0, len = arrayInput.length; i < len; i++) {
			stringBuilder.append(arrayInput[i]);
			stringBuilder.append(",");
		}
		// stringBuilder.deleteCharAt(0);
		stringBuilder.setCharAt(stringBuilder.length() - 1, ';');
		return stringBuilder.toString();
	}
}
