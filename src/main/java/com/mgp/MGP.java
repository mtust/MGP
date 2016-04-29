package com.mgp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MGP {
	
	
	
	
	public  void incraseVectors(List<List<Double>> vecors, int k, String fileName){
		
		
		List<List<Double>> newVecors = new ArrayList<List<Double>>();
		
		
		for (List<Double> vector : vecors) {
			List<Double> newVector = new ArrayList<Double>();
			List<List<Double>> neigbours = new ArrayList<List<Double>>();
			List<Double> temporarryMinEvklid = new ArrayList<Double>();
			for(int i = 0; i < k; i++){
				temporarryMinEvklid.add(Double.MAX_VALUE);
				neigbours.add(null);
			}
//			Double[] minEvklid = (Double[]) temporarryMinEvklid.toArray();			
			for (List<Double> runVector : vecors) {
				if(runVector.isEmpty()){
					continue;
				}
				if(runVector.equals(vector)){
					continue;
				}
				double runEvklidDistance = this.evklidDistance(vector, runVector);
				for(int j = 0; j < temporarryMinEvklid.size(); j++){
					if(runEvklidDistance < temporarryMinEvklid.get(j)){
						temporarryMinEvklid.set(j, runEvklidDistance);
						neigbours.set(j, runVector);
						break;
					}
				}
			}
			
			for(int i = 0; i < vector.size() - 1; i++){
				newVector.add(vector.get(i));				
			}
			for (List<Double> neigbourVecor : neigbours) {
				newVector.addAll(neigbourVecor);
			}
			
			if(vector.isEmpty() == true){
				continue;
			}
			
			newVector.add(vector.get(vector.size() - 1));					
			
			newVecors.add(newVector);
			
			String newFileName = "";
			if(fileName.lastIndexOf('.') > 0){
				newFileName = fileName.substring(0, fileName.lastIndexOf('.')) + "incresed" + k + ".txt";  
			}
			
			newFileName = fileName + "incresed" + k + ".txt";
			this.writeNewFile(newVecors, newFileName);
			
		}
		
	}
	
	private void writeNewFile(List<List<Double>> elements,  String fileName){
		try {

			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (List<Double> list : elements) {
				for (int i = 0; i < list.size() - 1; i++) {
					bw.write(list.get(i).toString() + " ");
				}
				bw.write(list.get(list.size() - 1).toString());
				bw.write("\n");
			}
			
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private double evklidDistance(List<Double> vector ,List<Double> runVector){
		double sum = 0;
		for(int i = 0; i < vector.size() - 1; i ++){
			sum += Math.pow((vector.get(i) - runVector.get(i)), 2);
		}
		return Math.sqrt(sum);
	}
		

}
