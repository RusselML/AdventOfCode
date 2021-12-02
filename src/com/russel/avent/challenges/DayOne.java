package com.russel.avent.challenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DayOne {
	File file;
	BufferedReader buffReader;
	
	public DayOne(String filePath) {
		file = new File(filePath);
		try {
			buffReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int processText() {
		int count = 0;
		int num;
		int num2;
		
		String next;
		//read the first number
		try {
			num = Integer.parseInt(buffReader.readLine());
			while((next = buffReader.readLine()) != null) {
				num2 = Integer.parseInt(next);
				if(num2>num) count++;
				num = num2;
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}
	
	public int processTextTwo() {
		int count = 0;
		
		int window = 3;
		
		int[] numArr1 = new int[window];
		int[] numArr2 = new int[window];
		
		int sum1 = 0;
		int sum2 = 0;
		
		
		
		String next;
		
		//read the first three nums 
		try {
			for(int i = 0; i < window; i++) {
				numArr1[i] = Integer.parseInt(buffReader.readLine());
				sum1 += numArr1[i];
			}
			
			//populate the next sum, offsetting the second array by one
			for(int i = 0; i < window - 1; i++) {
				numArr2[i] = numArr1[i+1];
				sum2 += numArr2[i];
			}
			
			//grab the last number to fill this array, add it to sum
			numArr2[window-1] = Integer.parseInt(buffReader.readLine());
			sum2 += numArr2[2];
			
			if(sum2 > sum1) count++;
			
			while((next = buffReader.readLine()) != null){
				//set the first array equal to the second, repopulate the second using the same method above
				sum1 = sum2;
				sum2 = 0;
				numArr1 = numArr2;
				
				for(int i = 0; i < window-1; i++) {
					numArr2[i]  = numArr1[i+1];
					sum2 += numArr2[i];
				}
				
				//fill the last index
				numArr2[window-1] = Integer.parseInt(next);
				sum2 += numArr2[window-1];
				
				if(sum2 > sum1) count++;
				
			}
				
			
		}catch (NumberFormatException | IOException e) {
			
		}
		
		return count;
	}
}
