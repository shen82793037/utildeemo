package main.java.com.blodestar.controller;

import main.java.com.blodestar.dto.StringDTO;
import main.java.com.blodestar.service.DataTransmitService;
import main.java.com.blodestar.service.LiborStringService;
import main.java.com.blodestar.vo.StringVO;

public class StringController {
	private DataTransmitService dataTransmitService = new DataTransmitService();

	private LiborStringService liborStringService = new LiborStringService();

	public StringVO getTheLongestNumberInString(final StringVO stringVO) {
		StringDTO stringDTO = dataTransmitService.transmitNormalString(stringVO);
		if (stringDTO.getResultString() != null) {
			stringVO.setResultString(stringDTO.getResultString());
			return stringVO;
		}
		stringDTO = liborStringService.createNewString(stringDTO);
		stringVO.setMainString(stringDTO.getMainString());
		stringDTO = liborStringService.getTheLongestNumberString(stringDTO);
		stringVO.setResultString(stringDTO.getResultString());
 		return stringVO;
	}

	public StringVO getThePercentNumberString(final StringVO stringVO) {
		StringDTO stringDTO = dataTransmitService.transmitNormalString(stringVO);
		if (stringDTO.getResultString() != null) {
			stringVO.setResultString(stringDTO.getResultString());
			return stringVO;
		}
		stringDTO = liborStringService.createNewString(stringDTO);
		if (stringDTO.getResultString() != null) {
			stringVO.setResultString(stringDTO.getResultString());
			return stringVO;
		} else {
			stringVO.setMainString(stringDTO.getMainString());
		}
		stringDTO = liborStringService.getThePercentNumberString(stringDTO);
		stringVO.setResultString(stringDTO.getResultString());
		return stringVO;
	}
}
