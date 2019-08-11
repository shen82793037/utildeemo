package main.java.com.old.old;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LiborIntegerArrayUtil {
	private int[] mainArray;

	public int[] getMainArray() {
		return mainArray;
	}

	public void setMainArray(int[] mainArray) {
		this.mainArray = mainArray;
	}

	public String getStringToShowMainArray() {
		// TODO 强迫症要求之搞一下排版
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 0; i < mainArray.length; i++) {
			if (i%10 == 0) {
				stringBuilder.append("\n");
			}
			stringBuilder.append(i);
			stringBuilder.append(".");
			stringBuilder.append(mainArray[i]);
			stringBuilder.append(" | ");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

	public static final String INTEGER = "integer";

	public LiborIntegerArrayUtil(){
		super();
		mainArray = new int[0];
	}
	public LiborIntegerArrayUtil(int[] mainArrayInput) {
		super();
		mainArray = mainArrayInput;
	}
	public LiborIntegerArrayUtil(String arrayTypeInput, int arrayLengthInput) {
		super();
		mainArray = new int[arrayLengthInput];
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		if (INTEGER.equals(arrayTypeInput)) {
			for (int i = 0; i < arrayLengthInput; i++ ) {
				// TODO can't value to the Integer.MAX_VALUE;
				int integerRandom = threadLocalRandom.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
				mainArray[i] = integerRandom;
			}
		}
	}

	// it's selection sort instead of bubbleSort
	public void doSelectionSort() {
		int lengthOfMainArray = mainArray.length;
		for (int i = (lengthOfMainArray - 1); i > 0; i--) { // i++ is wrong
			int[] arrayRemaining = Arrays.copyOfRange(mainArray, 0, i + 1); // third parameter is quantity not index
			int maxIntegerRemainingIndex = getMaxIntegerOfArray(arrayRemaining);
			int exchange = mainArray[maxIntegerRemainingIndex];
			// need the index of maxInteger change the function getMaxIntegerOfArray
			mainArray[maxIntegerRemainingIndex] = mainArray[i];
			mainArray[i] = exchange;
			// show more clearly, but can do this at the function getStringToShowArray;
			/* System.out.println(exchange); */
			System.out.println(this.getStringToShowMainArray());
		}
	}
	// getMaxIntegerOfArray instead of getMaxIntegerRemaining for more reusability
	private int getMaxIntegerOfArray(int[] arrayInput) {
		int maxIntegerIndex = 0;
		int maxInteger = arrayInput[0];
		int lengthOfArrayInput = arrayInput.length;
		for (int i = 1; i < lengthOfArrayInput; i++) {
			boolean isThisNumberGreaterThanMax = mainArray[i] > maxInteger;
			if (isThisNumberGreaterThanMax) {
				maxInteger = mainArray[i];
				maxIntegerIndex = i;
			}
		}
		return maxIntegerIndex;
	}

	// TODO Maybe it can be batter to add a flag to show when there is no change in a circulation, and then break;
	public void doBubbleSort() {
		int lengthOfMainArray = mainArray.length;
		for (int j = 1; j < lengthOfMainArray - 1; j++) {
			for (int i = 0; i < lengthOfMainArray - j; i++) {
				boolean isThisGreaterThanNext = mainArray[i] > mainArray[i + 1];
				if (isThisGreaterThanNext) {
					mainArray[i] = mainArray[i] ^ mainArray[i + 1]; // a ^ b
					mainArray[i + 1] = mainArray[i] ^ mainArray[i + 1]; // a ^ b ^ b = a
					mainArray[i] = mainArray[i] ^ mainArray[i + 1]; // a ^ b ^ a = b
				}
			}
			System.out.println(this.getStringToShowMainArray());
		}
	}

}
