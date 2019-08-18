package main.java.com.bluelodestar.controller;

import main.java.com.bluelodestar.dtos.StringDTO;
import main.java.com.bluelodestar.service.DataTransmitService;
import main.java.com.bluelodestar.service.LiborStringService;
import main.java.com.bluelodestar.vos.StringVO;

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
