package main.java.com.blodestar.service;

import main.java.com.blodestar.dto.StringDTO;
import main.java.com.blodestar.util.LiborArrayUtil;
import main.java.com.blodestar.vo.StringVO;

import java.lang.reflect.Field;

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



}
