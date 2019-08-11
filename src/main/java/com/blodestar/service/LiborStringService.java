package main.java.com.blodestar.service;

import main.java.com.blodestar.dto.StringDTO;
import main.java.com.blodestar.vo.StringVO;

import java.util.Arrays;
import java.util.Random;

/**
 * Service for string
 * @author Libor B. Lodestar
 */
public class LiborStringService {
	private static final int ASCII_LENGTH_ZERO_TO_Z = 43;
	private static final int ASCII_INDEX_ZERO = 48;

	public StringDTO createNewString(StringVO stringVOInput) {
		StringDTO stringDTO = new StringDTO();
		int mainLengthInput = stringVOInput.getLength();
		char[] charArrayForMainString = new char[mainLengthInput];
		Random randomNumber = new Random();
		if (StringVO.INCLUDE_NUMBER.equals(stringVOInput.getType())) {
			for (int i = 0; i < mainLengthInput; i++) {
				// 使用强制类型转换而不是直接赋值
				charArrayForMainString[i] = (char) (randomNumber.nextInt(ASCII_LENGTH_ZERO_TO_Z)
						+ ASCII_INDEX_ZERO);
			}
		} else if (StringVO.INCLUDE_PERCENTAGE.equals(stringVOInput.getType())) {
		    // TODO [a-z][A-Z] include percent number


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

	public StringDTO getTheLongestNumberString1(final StringDTO stringDTO) throws Exception {
		String stringInput = stringDTO.getMainString();
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
			boolean isResidualLengthLessThanMaxLength =
					(lengthOfStringInputList - i) < lengthMaxNumberString;
			boolean isMaxLengthIsOneAndAtLast = isThisTheLastOne && lengthMaxNumberString == 1;
			if (isResidualLengthLessThanMaxLength || isMaxLengthIsOneAndAtLast) {
				char[] longestNumberStringArray = Arrays.copyOfRange(stringInputList,
						indexMaxNumberString, indexMaxNumberString + lengthMaxNumberString);
				stringDTO.setResultString(String.valueOf(longestNumberStringArray));
			}
			boolean isMaxLengthIsZeroAndAtLast = isThisTheLastOne && lengthMaxNumberString == 0;
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
}
