package main.java.com.bluelodestar.controller;

import main.java.com.bluelodestar.dtos.IntegerArrayDTO;
import main.java.com.bluelodestar.service.DataTransmitService;
import main.java.com.bluelodestar.service.LiborIntegerArrayService;
import main.java.com.bluelodestar.vos.IntegerArrayVO;

public class IntegerArrayController {
    private DataTransmitService dataTransmitService = new DataTransmitService();
    private LiborIntegerArrayService liborIntegerArrayService = new LiborIntegerArrayService();

	public IntegerArrayVO doSort(IntegerArrayVO integerArrayVO) {
        IntegerArrayDTO integerArrayDTO = dataTransmitService.transmitNormalIntegerArray(integerArrayVO);
        if (integerArrayDTO.getMessage() != null) {
            integerArrayVO.setProcess(integerArrayDTO.getMessage());
            return integerArrayVO;
        }
        integerArrayDTO = liborIntegerArrayService.createRandomIntegerArray(integerArrayDTO);
        switch (integerArrayVO.getSortType()){
            case "1" :
                integerArrayDTO = liborIntegerArrayService.doBubbleSort(integerArrayDTO);
                break;
            case "2" :
                integerArrayDTO = liborIntegerArrayService.doSelectSort(integerArrayDTO);
                break;
            case "3" :
                integerArrayDTO = liborIntegerArrayService.doInsertionSort(integerArrayDTO);
                break;
            case "4" :
                integerArrayDTO = liborIntegerArrayService.doShellSort(integerArrayDTO);
                break;
        }
        integerArrayVO.setProcess(integerArrayDTO.getProcess());
        return integerArrayVO;
	}

}
