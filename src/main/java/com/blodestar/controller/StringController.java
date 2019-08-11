package main.java.com.blodestar.controller;

import main.java.com.blodestar.dto.StringDTO;
import main.java.com.blodestar.service.DataTransmitService;
import main.java.com.blodestar.service.LiborStringService;
import main.java.com.blodestar.vo.StringVO;

public class StringController {
	private DataTransmitService dataTransmitService = new DataTransmitService();

	private LiborStringService liborStringService = new LiborStringService();

	public StringVO getTheLongestNumberInString(final StringVO stringVO) {
		StringDTO stringDTO = liborStringService.createNewString(stringVO);
		stringDTO = liborStringService.getTheLongestNumberString(stringDTO);
 		return dataTransmitService.transmitToStringVO(stringDTO);
	}

	public StringVO getThePercentNumberString(final StringVO stringVO) {
		final String[] necessaryAttributeArray = {"type", "length"};
		// resultString must be null;
		StringDTO stringDTO = dataTransmitService.checkNecessaryData(stringVO, necessaryAttributeArray);
		/* int missingAttributeLength = missingAttributeArray.length;
		if (missingAttributeLength != 0) {
			StringBuilder stringBuilder = new StringBuilder("miss these data:");
			for (int i = 0; i < missingAttributeLength; i++) {
				stringBuilder.append(missingAttributeArray[i]);
				stringBuilder.append(",");
			}
			stringBuilder.setCharAt(missingAttributeLength, ';');
			stringVO.setResultString(stringBuilder.toString());
			return stringVO;
		} */
		if (stringDTO.getResultString() != null) {
			stringVO.setResultString(stringDTO.getResultString());
			return stringVO;
		}
		stringDTO = liborStringService.createNewString(stringVO);
		stringDTO = liborStringService.getThePercentNumberString(stringDTO);
		return dataTransmitService.transmitToStringVO(stringDTO);
	}

	/* public IntegerArrayVO doBubbleSort() {
		System.out.println("------------------------Each Sort-------------------------");
		LiborIntegerArrayUtil randomArray = new LiborIntegerArrayUtil(LiborIntegerArrayUtil.INTEGER, 5);
		int[] randomArrayBeforeSort = randomArray.getMainArray();
		System.out.println("The array before sort is " + randomArrayBeforeSort
				+ randomArray.getStringToShowMainArray());
		System.out.println("The array after sort is " + randomArray.getMainArray()
				+ randomArray.getStringToShowMainArray());
	} */

}
