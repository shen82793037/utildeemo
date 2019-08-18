package main.java.com.bluelodestar.dtos;

import java.io.Serializable;

public class IntegerArrayDTO implements Serializable {
    private Integer length;
    private int[] mainArray;
    private String message;
    private String process;
    private int[] resultArray;

    public Integer getLength() {
        return length;
    }

    public int[] getMainArray() {
        return mainArray;
    }

    public String getProcess() {
        return process;
    }

    public String getMessage() {
        return message;
    }

    public int[] getResultArray() {
        return resultArray;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setMainArray(int[] mainArray) {
        this.mainArray = mainArray;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }


}
