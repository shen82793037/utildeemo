package main.java.com.blodestar.service;

import main.java.com.blodestar.dto.StringDTO;
import main.java.com.blodestar.util.LiborArrayUtil;
import main.java.com.blodestar.vo.StringVO;

import java.lang.reflect.Field;

public class DataTransmitService {
	public StringDTO checkNecessaryData(final StringVO stringVO, final String[] necessaryAttributeArray) {
		StringDTO stringDTO = new StringDTO();
		Field[] fields = stringVO.getClass().getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			String attributeName = fields[i].getName();
			boolean accessFlag = fields[i].isAccessible();
			fields[i].setAccessible(true);
			try {
				Object thisObject = fields[i].get(stringVO);
				// if (int)length == 0, thisObject = (Integer)0
				if (LiborArrayUtil.containsString(necessaryAttributeArray, attributeName) && thisObject == null) {
					stringDTO.setResultString(attributeName + " is blank!");
					fields[i].setAccessible(accessFlag);
					return stringDTO;
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				stringDTO.setResultString(e.getMessage());
				fields[i].setAccessible(accessFlag);
				return stringDTO;
			}
			fields[i].setAccessible(accessFlag);
		}
		return stringDTO;
	}

	public StringDTO transmitToStringDTO(StringVO stringVOInput) {
		StringDTO stringDTO = new StringDTO();
		stringDTO.setMainString(stringVOInput.getMainString());
		stringDTO.setResultString(stringVOInput.getResultString());
		return stringDTO;
	}

	public StringVO transmitToStringVO(StringDTO stringDTOInput) {
		StringVO stringVO = new StringVO();
		stringVO.setMainString(stringDTOInput.getMainString());
		stringVO.setResultString(stringDTOInput.getResultString());
		return stringVO;
	}

}
