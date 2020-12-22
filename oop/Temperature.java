package oop;

public class Temperature {
	private double tempValue;
	private char scale;
	Temperature(){
		tempValue=0;
		scale='C';
	}
	Temperature(double tempValue){
		this();
		this.tempValue= tempValue;
	}
	Temperature(char scale){
		this();
		this.scale=scale;
	}
	Temperature(double tempValue,char scale){
		this.tempValue= tempValue;
		this.scale=scale;
	}
	double getTempValueCelcius() {
		if (scale == 'C'){
				return tempValue;
		}
		else {
			return 5*(tempValue-32)/9;
		}
	}
	double getTempValueFahrenheit() {
		if (scale == 'F'){
				return tempValue;
		}
		else {
			return 9*(tempValue/5)+32;
		}
	}
	void setTempValue(double tempValue) {
		this.tempValue=tempValue;
	}
	void setScale(char scale) {
		this.scale=scale;
	}
	void setTempValueAndScale(double tempValue,char scale) {
		this.tempValue=tempValue;
		this.scale=scale;
	}
	char getScale() {
		return scale;
	}
}
