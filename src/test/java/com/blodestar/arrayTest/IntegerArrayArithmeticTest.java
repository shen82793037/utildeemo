package test.java.com.blodestar.arrayTest;

import main.java.com.bluelodestar.controller.IntegerArrayController;
import main.java.com.bluelodestar.enums.MessageEnum;
import main.java.com.bluelodestar.vos.IntegerArrayVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerArrayArithmeticTest {
    private String getInputStream(String message) throws IOException {
        System.out.println(message);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
    public void doSort() {
        String arrayLengthString = MessageEnum.UNKNOWN_ERROR.getMessageText();
        String sortType = MessageEnum.UNKNOWN_ERROR.getMessageText();
        try {
            arrayLengthString = getInputStream("Please input the length of integer array:");
            sortType = getInputStream("Please input the order method: (1.bubble sort, 2.select sort," +
                    " 3.insertion sort, 4.shell sort)");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (MessageEnum.UNKNOWN_ERROR.getMessageText().equals(arrayLengthString)) {
            System.out.println(arrayLengthString);
            return;
        } else if (MessageEnum.UNKNOWN_ERROR.getMessageText().equals(sortType)) {
            System.out.println(sortType);
            return;
        }
        IntegerArrayVO integerArrayVO = new IntegerArrayVO();
        integerArrayVO.setLength(arrayLengthString);
        integerArrayVO.setSortType(sortType);
        IntegerArrayController integerArrayController = new IntegerArrayController();
        IntegerArrayVO integerArrayVOGet = integerArrayController.doSort(integerArrayVO);
        System.out.println(integerArrayVOGet.getProcess());
    }


}
