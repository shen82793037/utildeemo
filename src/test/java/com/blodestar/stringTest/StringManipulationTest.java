package test.java.com.blodestar.stringTest;

import main.java.com.bluelodestar.controller.StringController;
import main.java.com.bluelodestar.service.LiborStringService;
import main.java.com.bluelodestar.vos.StringVO;

public class StringManipulationTest {
	public void getTheLongestNumberInRandomString() {
		StringVO stringVO = new StringVO();
		stringVO.setType(LiborStringService.INCLUDE_NUMBER);
		stringVO.setLength(40);
		StringController stringController = new StringController();
		stringVO = stringController.getTheLongestNumberInString(stringVO);
		System.out.println(stringVO.getMainString());
		System.out.println(stringVO.getResultString());
	}

	public void getThePercentNumberInRandomLetterString() {
		StringVO stringVO = new StringVO();
		stringVO.setType(LiborStringService.INCLUDE_PERCENTAGE);
		// stringVO.setType(LiborStringService.ONLY_LETTERS);
		// int 默认值为0 不能为 null
		stringVO.setLength(20);
		StringController stringController = new StringController();
		stringVO = stringController.getThePercentNumberString(stringVO);
		System.out.println(stringVO.getMainString() + "," +stringVO.getResultString());
	}
}
