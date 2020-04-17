package resources;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class SharedProps {

	// Objects to be shared within the different steps to run parallel. 
	public WebDriver driver;
	public Properties prop;
	
	// Auxiliary objects to share between steps
	public int auxInteger;
	public String auxString;
	
	public void setAuxInt(int value) {
		auxInteger = value;
	}
	
	public int getAuxInt() {
		return auxInteger;
	}
	
	public void setAuxString(String value) {
		auxString = value;
	}
	
	public String getAuxString() {
		return auxString;
	}

	public void resetAux() {
		auxInteger = 0;
		auxString = "";
	}
}
