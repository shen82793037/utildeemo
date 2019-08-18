package main.java.com.bluelodestar.service;

import main.java.com.bluelodestar.dtos.IntegerArrayDTO;
import main.java.com.bluelodestar.util.LiborArrayUtil;
import main.java.com.bluelodestar.enums.MessageEnum;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LiborIntegerArrayService {
    /**
     * @param integerArrayDTO need length;
     * @return a random integer array which's length is length;
     */
    public IntegerArrayDTO createRandomIntegerArray(IntegerArrayDTO integerArrayDTO) {
        int arrayLength = integerArrayDTO.getLength();
        int[] newArray = new int[arrayLength];
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < arrayLength; i++) {
            // TODO can't value to the Integer.MAX_VALUE;
            int integerRandom = threadLocalRandom.nextInt(0, 100);
            newArray[i] = integerRandom;
        }
        integerArrayDTO.setMainArray(newArray);
        String stringProcess = MessageEnum.SUCCESSFULLY_CREATE.getMessageText() + "\n"
                + LiborArrayUtil.integerArrayToString(newArray) + "\n";
        integerArrayDTO.setProcess(stringProcess);
        return integerArrayDTO;
    }

    /**
     * @param integerArrayDTO need mainArray to sort;
     * @return process include the sequencer procedure, resultArray is the result;
     */
    public IntegerArrayDTO doBubbleSort(IntegerArrayDTO integerArrayDTO) {
        int[] mainArray = integerArrayDTO.getMainArray();
        StringBuilder processBuilder = new StringBuilder(integerArrayDTO.getProcess());
        processBuilder.append("Start bubble sort:\n");
        int lengthOfMainArray = mainArray.length;
        for (int j = 1; j < lengthOfMainArray - 1; j++) {
            for (int i = 0; i < lengthOfMainArray - j; i++) {
                if (mainArray[i] > mainArray[i + 1]) {
                    mainArray[i] = mainArray[i] ^ mainArray[i + 1]; // a ^ b
                    mainArray[i + 1] = mainArray[i] ^ mainArray[i + 1]; // a ^ b ^ b = a
                    mainArray[i] = mainArray[i] ^ mainArray[i + 1]; // a ^ b ^ a = b
                }
            }
            processBuilder.append(j);
            processBuilder.append(": ");
            processBuilder.append(LiborArrayUtil.integerArrayToString(mainArray));
            processBuilder.append('\n');
        }
        processBuilder.append("End;\n");
        integerArrayDTO.setProcess(processBuilder.toString());
        integerArrayDTO.setResultArray(mainArray);
        return integerArrayDTO;
    }

    /**
     * @param integerArrayDTO need mainArray to sort;
     * @return process include the sequencer procedure, resultArray is the result;
     */
    public IntegerArrayDTO doSelectSort(IntegerArrayDTO integerArrayDTO) {
        int[] mainArray = integerArrayDTO.getMainArray();
        StringBuilder processBuilder = new StringBuilder(integerArrayDTO.getProcess());
        processBuilder.append("Start select sort:\n");
        int lengthOfMainArray = mainArray.length;
        for (int i = (lengthOfMainArray - 1); i > 0; i--) { // i++ is wrong
            int[] arrayRemaining = Arrays.copyOfRange(mainArray, 0, i + 1); // third parameter is quantity not index
            int maxIntegerRemainingIndex = getMaxIntegerOfArray(arrayRemaining);
            int exchange = mainArray[maxIntegerRemainingIndex];
            // need the index of maxInteger change the function getMaxIntegerOfArray
            mainArray[maxIntegerRemainingIndex] = mainArray[i];
            mainArray[i] = exchange;
            processBuilder.append(lengthOfMainArray - i);
            processBuilder.append(": ");
            processBuilder.append(LiborArrayUtil.integerArrayToString(mainArray));
            processBuilder.append('\n');
        }
        processBuilder.append("End;\n");
        integerArrayDTO.setProcess(processBuilder.toString());
        integerArrayDTO.setResultArray(mainArray);
        return integerArrayDTO;
    }

    /**
     * @param integerArrayDTO need mainArray to sort;
     * @return process include the sequencer procedure, resultArray is the result;
     */
    public IntegerArrayDTO doInsertionSort(IntegerArrayDTO integerArrayDTO) {
        int[] mainArray = integerArrayDTO.getMainArray();
        StringBuilder processBuilder = new StringBuilder(integerArrayDTO.getProcess());
        processBuilder.append("Start insertion sort:\n");
        int lengthOfMainArray = mainArray.length;
        for (int i = 1; i < lengthOfMainArray; i++) { // i is the index of integer operated now;
            int[] arrayOrdered = Arrays.copyOfRange(mainArray, 0, i); // to is the length;
            int thisInteger = mainArray[i];
            int indexInsert = getIndexToInsert(arrayOrdered, thisInteger);
            if (i - indexInsert >= 0) {
                System.arraycopy(mainArray, indexInsert, mainArray, indexInsert + 1, i - indexInsert);
                mainArray[indexInsert] = thisInteger;
            }
            processBuilder.append(i);
            processBuilder.append(": ");
            processBuilder.append(LiborArrayUtil.integerArrayToString(mainArray));
            processBuilder.append('\n');
        }
        processBuilder.append("End;\n");
        integerArrayDTO.setProcess(processBuilder.toString());
        integerArrayDTO.setResultArray(mainArray);
        return integerArrayDTO;
    }

    /**
     * 移动法,希尔增量采用原值 gap/2(Math.floor());
     * @param integerArrayDTO need mainArray to sort;
     * @return process include the sequencer procedure, resultArray is the result;
     */
    public IntegerArrayDTO doShellSort(IntegerArrayDTO integerArrayDTO) {
        int[] mainArray = integerArrayDTO.getMainArray();
        StringBuilder processBuilder = new StringBuilder(integerArrayDTO.getProcess());
        processBuilder.append("Start shell sort:\n");
        int lengthOfMainArray = mainArray.length;
        for (int gap = lengthOfMainArray/2; gap > 0; gap/=2) {
            String gapMsg = "gap = " + gap + "\n";
            processBuilder.append(gapMsg);
            for (int i = gap; i < lengthOfMainArray; i++) { // i is the index of integer operated now;
                String iMsg = "i=" + i + ": " +LiborArrayUtil.integerArrayToString(mainArray) + "\n";
                processBuilder.append(iMsg);
                int j = i;
                int temp = mainArray[j];
                if (mainArray[j] < mainArray[j - gap]) {
                    while (j - gap >= 0 && temp < mainArray[j - gap]) {
                        mainArray[j] = mainArray[j - gap];
                        j -= gap;
                    }
                    mainArray[j] = temp;
                }
            }
        }
        String endMsg = "End: " + LiborArrayUtil.integerArrayToString(mainArray) + "\n";
        processBuilder.append(endMsg);
        integerArrayDTO.setProcess(processBuilder.toString());
        integerArrayDTO.setResultArray(mainArray);
        return integerArrayDTO;
    }

    /**
     * getMaxIntegerOfArray instead of getMaxIntegerRemaining for more reusability
     * @param arrayInput the Integer array;
     * @return index of max integer in this array
     */
    private int getMaxIntegerOfArray(int[] arrayInput) {
        int maxIntegerIndex = 0;
        int maxInteger = arrayInput[0];
        int lengthOfArrayInput = arrayInput.length;
        for (int i = 1; i < lengthOfArrayInput; i++) {
            boolean isThisNumberGreaterThanMax = arrayInput[i] > maxInteger;
            if (isThisNumberGreaterThanMax) {
                maxInteger = arrayInput[i];
                maxIntegerIndex = i;
            }
        }
        return maxIntegerIndex;
    }

    /**
     * @param array must be ordered
     * @param number > numberIndex-1 numberIndex< +1
     * @return index numberIndex + 1, maybe > array.length;
     */
    private int getIndexToInsert(int[] array, int number) {
        int index = array.length;
        for (int i = 0, len = array.length; i < len; i++) {
            if (number < array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
