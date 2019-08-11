package main.java.com.old.old;

public class StringTest {

	public void main(String[] args) {
		// get the longest numeric string from a string like "sdsd21315sddsd3132123131sdsdds"
		/* String stringIncludeNumber = "sdsd21315sddsd3132123131";
		StringManipulation stringManipulation = new StringManipulation(stringIncludeNumber);
		String theLongestNumberString = stringManipulation.getTheLongestNumberString();
		System.out.println(theLongestNumberString); */
		// refactor the code behind 15点48分2019.08.04;
		System.out.println("------------------------Each Sort-------------------------");
		LiborIntegerArrayUtil randomArray = new LiborIntegerArrayUtil(LiborIntegerArrayUtil.INTEGER, 5);
		// array is different from String, directive print array will show the memory address;
		int[] randomArrayBeforeSort = randomArray.getMainArray();
		System.out.println("The array before sort is " + randomArrayBeforeSort
				+ randomArray.getStringToShowMainArray());

		// 1.PASS_TEST: test the function getMaxIntegerOfArray
		// 2.PASS_TEST: test the new return of getMaxIntegerOfArray Index;
		/* int maxIndex = randomArray.getMaxIntegerOfArray(randomArrayBeforeSort);
		System.out.println("The max one is: " + maxIndex + "." + randomArrayBeforeSort[maxIndex]); */

		// ABANDONED: change the logic, instead of redundant object
		/* LiborIntegerArrayUtil bubbleSortArray = new LiborIntegerArrayUtil(randomArray.doBubbleSortResult()); */

		/* randomArray.doSelectionSort(); */
		randomArray.doBubbleSort();
		/* randomArray.doInsertionSort(); */
		System.out.println("The array after sort is " + randomArray.getMainArray()
				+ randomArray.getStringToShowMainArray());
	}

}
