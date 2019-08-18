package main.java.com.bluelodestar.vos;

import java.io.Serializable;

public class IntegerArrayVO implements Serializable {
    private String length;
    private String process;
    private String sortType;

    public String getLength() {
        return length;
    }

    public String getProcess() {
        return process;
    }

    public String getSortType() {
        return sortType;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
