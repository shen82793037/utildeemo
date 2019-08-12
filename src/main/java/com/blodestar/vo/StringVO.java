package main.java.com.blodestar.vo;

import java.io.Serializable;

public class StringVO implements Serializable {
	private String type;
	private Integer length;
	private String mainString;
	private String resultString;

	public String getType() {
		return type;
	}

	public Integer getLength() {
		return length;
	}

	public String getMainString() {
		return mainString;
	}

	public String getResultString() {
		return resultString;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public void setMainString(String mainString) {
		this.mainString = mainString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
}
