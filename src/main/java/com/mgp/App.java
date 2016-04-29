package com.mgp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Converter converter = new Converter();
		MGP mgp = new MGP();

		String testFileName = "";
		String trainFileName = "";
		System.out.println("please print test file name (full path)");
		testFileName = new Scanner(System.in).nextLine();
		System.out.println("please print train file name (full path)");
		trainFileName = new Scanner(System.in).nextLine();

		FileParser fileParser = new FileParser();
		try {
			fileParser.initializeCSVReaderTest(testFileName);
//			fileParser.initializeCSVReaderTrain(trainFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<List<Double>> inputListTrain = new ArrayList<List<Double>>();
		List<List<Double>> inputListTest = new ArrayList<List<Double>>();

		try {
//			for (String inputString[] : fileParser.getCsvReaderTest().readAll()) {
//				inputListTest.add(converter
//						.stringArrayToDoubleArray(inputString));
//			}
			 
			String inputString[];
			
			while(true){
				try{
					inputString = fileParser.getCsvReaderTest().readNext();
					for (String string : inputString) {
						System.out.print( string + " ");
					}
					System.out.println();
				inputListTest.add(converter
						.stringArrayToDoubleArray(inputString));
			} 	 catch (IOException | NullPointerException e){
				break;
			}
		}
				
//						
//			while(true){
//				try{
//			inputString = fileParser.getCsvReaderTrain().readNext();
//			for (String string : inputString) {
//				System.out.print( string + " ");				
//			}
//			System.out.println();
//			
//				inputListTrain.add(converter
//						.stringArrayToDoubleArray(inputString));
//			
//				} catch (IOException | NullPointerException e){
//					break;
//				}
//			}
//			
		} catch (Exception e) {
			e.printStackTrace();
		}

		int[] k = {1,2,4};
		for (int i : k) {
//			System.out.println(inputListTest + "\n" + i + "\n" + testFileName );
//			System.out.println(inputListTrain + "\n" + i + "\n" + trainFileName );
			
			mgp.incraseVectors(inputListTest, i, testFileName);
//			mgp.incraseVectors(inputListTrain, i, trainFileName);
		}
		

	}
}