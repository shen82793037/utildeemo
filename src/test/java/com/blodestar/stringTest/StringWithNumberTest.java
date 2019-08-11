package test.java.com.blodestar.stringTest;

import main.java.com.blodestar.controller.StringController;
import main.java.com.blodestar.vo.StringVO;

public class StringWithNumberTest {
	public static void main(String[] args) {
		StringVO stringVO = new StringVO();
		stringVO.setType(StringVO.INCLUDE_NUMBER);
		stringVO.setLength(40);
		StringController stringController = new StringController();
		stringVO = stringController.getTheLongestNumberInString(stringVO);
		System.out.println(stringVO.getMainString());
		System.out.println(stringVO.getResultString());
	}
}
