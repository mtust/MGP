package com.mgp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Converter {

	public List<Double> stringArrayToDoubleArray(String[] inputString)
			throws NumberFormatException {
		List<Double> inputDouble = new ArrayList<Double>();		
		for (String inputElement : inputString) {
			try{
				inputDouble.add(Double.parseDouble(inputElement));
			} catch(NumberFormatException  e){
				System.out.println(inputElement + " ");
			}
		}
		return inputDouble;
	}

}
