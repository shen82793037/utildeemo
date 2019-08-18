package test.java.com.blodestar;

import test.java.com.blodestar.arrayTest.IntegerArrayArithmeticTest;
import test.java.com.blodestar.stringTest.StringManipulationTest;

public class MainTest {
    private static StringManipulationTest stringManipulationTest = new StringManipulationTest();
    private static IntegerArrayArithmeticTest integerArrayArithmeticTest = new IntegerArrayArithmeticTest();

    public static void main(String[] args) {
        // stringManipulationTest.getTheLongestNumberInRandomString();
        // stringManipulationTest.getThePercentNumberInRandomLetterString();

        integerArrayArithmeticTest.doSort();
    }
}
