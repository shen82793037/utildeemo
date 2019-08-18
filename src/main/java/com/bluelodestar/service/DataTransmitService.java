package main.java.com.bluelodestar.service;

import main.java.com.bluelodestar.dtos.IntegerArrayDTO;
import main.java.com.bluelodestar.dtos.StringDTO;
import main.java.com.bluelodestar.util.LiborArrayUtil;
import main.java.com.bluelodestar.enums.MessageEnum;
import main.java.com.bluelodestar.vos.IntegerArrayVO;
import main.java.com.bluelodestar.vos.StringVO;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTransmitService {
	private StringDTO checkNecessaryData(final StringVO stringVO, final String[] necessaryAttributeArray) {
		// Available resultString must be null;
		StringDTO stringDTO = new StringDTO();
		Field[] fields = stringVO.getClass().getDeclaredFields();
		StringBuilder stringBuilder = new StringBuilder("Miss attribute: ");
		for (int i = 0, len = fields.length; i < len; i++) {
			String attributeName = fields[i].getName();
			boolean accessFlag = fields[i].isAccessible();
			fields[i].setAccessible(true);
			try {
				Object thisObject = fields[i].get(stringVO);
				// if (int)length == 0, thisObject = (Integer)0
				if (LiborArrayUtil.containsString(necessaryAttributeArray, attributeName) && thisObject == null) {
					stringBuilder.append(attributeName);
					stringBuilder.append(",");
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				stringDTO.setResultString(e.getMessage());
				return stringDTO;
			} finally {
				fields[i].setAccessible(accessFlag);
			}
			fields[i].setAccessible(accessFlag);
		}
		if (!"Miss attribute: ".equals(stringBuilder.toString())) {
			stringBuilder.setCharAt(stringBuilder.length() - 1, ';');
			stringDTO.setResultString(stringBuilder.toString());
		}
		return stringDTO;
	}

	public StringDTO transmitNormalString(final StringVO stringVO) {
		// Available resultString must be null;
		StringDTO stringDTO = checkNecessaryData(
				stringVO, LiborStringService.NECESSARY_ATTRIBUTE_FOR_CREATE_STRING);
		if (stringDTO.getResultString() != null) {
			return stringDTO;
		}
		stringDTO.setType(stringVO.getType());
		stringDTO.setLength(stringVO.getLength());
		return stringDTO;
	}

	private IntegerArrayDTO checkLengthData(final IntegerArrayVO integerArrayVO) {
		IntegerArrayDTO integerArrayDTO = new IntegerArrayDTO();
		String positiveIntegerReg = "^[1-9]\\d*$";
		String length = integerArrayVO.getLength();
		String sortType = integerArrayVO.getSortType();
		Pattern pattern = Pattern.compile(positiveIntegerReg);
		Matcher lengthMatcher = pattern.matcher(length);
		Matcher sortTypeMatcher = pattern.matcher(sortType);
		if (!lengthMatcher.matches()) {
		    integerArrayDTO.setMessage(integerArrayDTO.getMessage() + ",length is "
				    + MessageEnum.NOT_A_NUMBER.getMessageText());
		}
		if (!sortTypeMatcher.matches()) {
			integerArrayDTO.setMessage(integerArrayDTO.getMessage() + ",order message is "
					+ MessageEnum.NOT_A_NUMBER.getMessageText());
		}
		return integerArrayDTO;
	}

	public IntegerArrayDTO transmitNormalIntegerArray(final IntegerArrayVO integerArrayVO) {
		IntegerArrayDTO integerArrayDTO = checkLengthData(integerArrayVO);
		if (integerArrayDTO.getMessage() != null) {
			String message = integerArrayDTO.getMessage();
			integerArrayDTO.setMessage(message.substring(5)); // null. = 5
			return integerArrayDTO;
		}
		integerArrayDTO.setLength(Integer.valueOf(integerArrayVO.getLength()));
		return integerArrayDTO;
	}


}
