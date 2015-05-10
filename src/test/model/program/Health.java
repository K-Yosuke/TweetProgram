package test.model.program;

import java.io.Serializable;

/*
 * eclipse自動生成のgetter, setter専用クラス
 */
public class Health implements Serializable {
	
	/**
	 * SerialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	private double height, weight, bmi;
	
	private String bodyType;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

}
