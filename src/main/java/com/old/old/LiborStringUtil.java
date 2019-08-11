package main.java.com.old.old;

import java.util.Arrays;
import java.util.Random;

/**
 * Utils for string
 * @author Libor B. Lodestar
 */
public class LiborStringUtil {
	/**
	 * the string waited to be processed
	 */
	private String mainString;

	public String getMainString() {
		return mainString;
	}

	public void setMainString(String mainString) {
		this.mainString = mainString;
	}

	public static final String INCLUDE_NUMBER = "includeNumber";
	private static final int ASCII_LENGTH_ZERO_TO_Z = 43;
	private static final int ASCII_INDEX_ZERO = 48;

	/**
	 * default mainString = "" instead of null
	 */
	public LiborStringUtil(){
		super();
		mainString = "";
	}

	public LiborStringUtil(final String mainStringInput) {
		super();
		mainString = mainStringInput;
	}

	/**
	 * get random string
	 * @param mainTypeInput the type of string
	 * @param mainLengthInput the length of string
	 */
	public LiborStringUtil(final String mainTypeInput, final int mainLengthInput) {
		boolean isTypeEqualsIncludeNumber = INCLUDE_NUMBER.equals(mainTypeInput);
		char[] charArrayForMainString = new char[mainLengthInput];
		Random randomNumber = new Random();
		if (isTypeEqualsIncludeNumber) {
			for (int i = 0; i < mainLengthInput; i++) {
				// 使用强制类型转换而不是直接赋值
				charArrayForMainString[i] = (char)(randomNumber.nextInt(ASCII_LENGTH_ZERO_TO_Z) + ASCII_INDEX_ZERO);
			}
		}
		mainString = String.valueOf(charArrayForMainString);
	}

	public String getTheLongestNumberString() throws Exception {
		String stringInput = mainString;
		char[] stringInputList = stringInput.toCharArray();
		int indexMaxNumberString = 0;
		int lengthMaxNumberString = 0;
		int indexThisNumberString = 0;
		int lengthThisNumberString = 0;
		boolean isLastCharDigit = false;
		int lengthOfStringInputList = stringInputList.length;
		for (int i = 0; i < lengthOfStringInputList; i++) {
			boolean isThisDigit = Character.isDigit(stringInputList[i]);
			if ((!isLastCharDigit) && isThisDigit) {
				indexThisNumberString = i;
				lengthThisNumberString = 1;
			}
			if (isLastCharDigit && isThisDigit) {
				lengthThisNumberString += 1;
			}
			// TODO 这里有问题,两个一样长的怎么处理? 暂取前一个
			boolean isLengthNowGreaterThanMax = lengthThisNumberString > lengthMaxNumberString;
			boolean isThisTheLastOne = (i + 1) == lengthOfStringInputList;
			if (isLastCharDigit && (!isThisDigit || isThisTheLastOne) && isLengthNowGreaterThanMax) {
				indexMaxNumberString = indexThisNumberString;
				lengthMaxNumberString = lengthThisNumberString;
			}
			boolean isResidualLengthLessThanMaxLength = (lengthOfStringInputList - i) < lengthMaxNumberString;
			boolean isMaxLengthIsOneAndAtLast = isThisTheLastOne && lengthMaxNumberString == 1;
			if (isResidualLengthLessThanMaxLength || isMaxLengthIsOneAndAtLast) {
				char[] longestNumberStringArray = Arrays.copyOfRange(stringInputList,
						indexMaxNumberString,indexMaxNumberString + lengthMaxNumberString);
				return String.valueOf(longestNumberStringArray);
			}
			boolean isMaxLengthIsZeroAndAtLast = isThisTheLastOne && lengthMaxNumberString == 0;
			if (isMaxLengthIsZeroAndAtLast) {
				if (isThisDigit) {
					return String.valueOf(stringInputList[i]);
				} else {
					return "There are no numbers in this String";
				}
			}
			isLastCharDigit = isThisDigit;
		}
		throw new Exception(mainString+"\'s condition was not caught!");
	}

}
