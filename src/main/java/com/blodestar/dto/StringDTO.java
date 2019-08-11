package main.java.com.blodestar.dto;

import java.io.Serializable;

public class StringDTO implements Serializable {
	private String mainString;
	private String resultString;

	public String getMainString() {
		return mainString;
	}

	public String getResultString() {
		return resultString;
	}

	public void setMainString(String mainString) {
		this.mainString = mainString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
}
