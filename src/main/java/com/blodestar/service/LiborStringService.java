package main.java.com.blodestar.service;

import main.java.com.blodestar.dto.StringDTO;
import main.java.com.blodestar.vo.StringVO;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service for string
 * @author Libor B. Lodestar
 */
public class LiborStringService {
	private static final int ASCII_LENGTH_ZERO_TO_Z = 43;
	private static final int ASCII_INDEX_ZERO = 48;

    public static final String INCLUDE_NUMBER = "includeNumber";
    public static final String INCLUDE_PERCENTAGE = "includePercentage";
	public static final String ONLY_LETTERS = "onlyLetters";
	public static final String STRING_ONLY_LETTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

	public static final String[] NECESSARY_ATTRIBUTE_FOR_CREATE_STRING = {"type", "length"};

	public StringDTO createNewString(StringDTO stringDTOInput) {
		StringDTO stringDTO = new StringDTO();
		int mainLengthInput = stringDTOInput.getLength();
		char[] charArrayForMainString = new char[mainLengthInput];
		Random randomNumber = new Random();
		if (INCLUDE_NUMBER.equals(stringDTOInput.getType())) {
			for (int i = 0; i < mainLengthInput; i++) {
				// 使用强制类型转换而不是直接赋值
				charArrayForMainString[i] = (char) (randomNumber.nextInt(ASCII_LENGTH_ZERO_TO_Z)
						+ ASCII_INDEX_ZERO);
			}
		} else if (INCLUDE_PERCENTAGE.equals(stringDTOInput.getType())) {
		    // [a-z][A-Z] include percent number
			StringDTO stringDTOForCreate = new StringDTO();
			stringDTOForCreate.setLength(stringDTOInput.getLength());
			stringDTOForCreate.setType(ONLY_LETTERS);
			charArrayForMainString = createNewString(stringDTOForCreate).getMainString().toCharArray();
			char[] randomNumberLessThan100 = (randomNumber.nextInt(101) + "%").toCharArray();
			int randomNumberLength = randomNumberLessThan100.length;
			int indexStartRange = stringDTOInput.getLength() - randomNumberLength - 1;
			if (indexStartRange < 0) {
				stringDTO.setResultString("Length is too short!");
				return stringDTO;
			} else {
				int indexStart = randomNumber.nextInt(indexStartRange + 1);
				System.arraycopy(randomNumberLessThan100, 0,
						charArrayForMainString, indexStart, randomNumberLength);
			}
		} else if (ONLY_LETTERS.equals(stringDTOInput.getType())) {
			char[] charsOnlyLetters = STRING_ONLY_LETTERS.toCharArray();
			for (int i = 0; i < mainLengthInput; i++) {
				charArrayForMainString[i] = charsOnlyLetters[randomNumber.nextInt(charsOnlyLetters.length)];
			}
		}
		stringDTO.setMainString(String.valueOf(charArrayForMainString));
		return stringDTO;
	}

	public StringDTO getTheLongestNumberString(final StringDTO stringDTO) {
		char[] stringInputList = stringDTO.getMainString().toCharArray();
		int indexMaxNumberString = 0;
		int lengthMaxNumberString = 0;
		int indexThisNumberString = 0;
		int lengthThisNumberString = 0;
		boolean isLastCharDigit = false;
		int lengthOfStringInputList = stringInputList.length;
		for (int i = 0; i < lengthOfStringInputList; i++) {
			boolean isThisDigit = Character.isDigit(stringInputList[i]);
			// TODO 这里有问题,两个一样长的怎么处理? 暂取前一个
			boolean isLengthNowGreaterThanMax = lengthThisNumberString > lengthMaxNumberString;
			boolean isThisTheLastOne = (i + 1) == lengthOfStringInputList;
			boolean isResidualLengthGreaterThanMaxLength =
					(lengthOfStringInputList - i) < lengthMaxNumberString;
			boolean isMaxLengthIsOneAndAtLast = isThisTheLastOne && lengthMaxNumberString == 1;
			boolean isMaxLengthIsZeroAndAtLast = isThisTheLastOne && lengthMaxNumberString == 0;
			if (isThisDigit) {
				if (isLastCharDigit) {
					lengthThisNumberString += 1;
				} else {
					indexThisNumberString = i;
					lengthThisNumberString = 1;
				}
			}
			if (isLastCharDigit && (!isThisDigit || isThisTheLastOne) && isLengthNowGreaterThanMax) {
				indexMaxNumberString = indexThisNumberString;
				lengthMaxNumberString = lengthThisNumberString;
			}
			if (!(!isResidualLengthGreaterThanMaxLength && !isMaxLengthIsOneAndAtLast)) {
				char[] longestNumberStringArray = Arrays.copyOfRange(stringInputList,
						indexMaxNumberString, indexMaxNumberString + lengthMaxNumberString);
				stringDTO.setResultString(String.valueOf(longestNumberStringArray));
			}
			if (isMaxLengthIsZeroAndAtLast) {
				if (isThisDigit) {
					stringDTO.setResultString(String.valueOf(stringInputList[i]));
				} else {
					stringDTO.setResultString("There are no numbers in this String");
				}
			}
			isLastCharDigit = isThisDigit;
		}
		return stringDTO;
	}

	public StringDTO getThePercentNumberString(final StringDTO stringDTO) {
		String originalString = stringDTO.getMainString();
		String pattern = "(([1-9]\\d?)|100|0)%";
		Pattern patternO = Pattern.compile(pattern);
		Matcher matcherO = patternO.matcher(originalString);
		// m.find() 可以执行一下这个返回第一个
		while(matcherO.find()) { // 必须先 find, 这里返回所有的
			// System.out.println(m.group()); 可以打印出所有的
			stringDTO.setResultString(matcherO.group()); // 这里就是返回最后一个;
		}
		return stringDTO;
	}

}
