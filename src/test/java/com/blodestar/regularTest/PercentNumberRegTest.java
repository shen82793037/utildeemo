package test.java.com.blodestar.regularTest;

import main.java.com.blodestar.controller.StringController;
import main.java.com.blodestar.vo.StringVO;

public class PercentNumberRegTest {
	public static void main(String[] args) {
		StringVO stringVO = new StringVO();
		stringVO.setType(StringVO.INCLUDE_PERCENTAGE);
		// int 默认值为0 不能为 null
		// stringVO.setLength(20);
		StringController stringController = new StringController();
		stringVO = stringController.getThePercentNumberString(stringVO);
		System.out.println(stringVO.getMainString() + "," +stringVO.getResultString());
	}
}
