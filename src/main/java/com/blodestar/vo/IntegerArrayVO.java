package main.java.com.blodestar.vo;

import java.io.Serializable;

public class IntegerArrayVO implements Serializable {
    private Integer length;
    private int[] mainArray;
    private int[] resultArray;

    public Integer getLength() {
        return length;
    }

    public int[] getMainArray() {
        return mainArray;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setMainArray(int[] mainArray) {
        this.mainArray = mainArray;
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }

    public int[] getResultArray() {
        return resultArray;
    }
}
