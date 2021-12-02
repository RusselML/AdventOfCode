package com.russel.avent.challenges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DayTwo {

	private File file;
	private BufferedReader buffReader;
	
	public DayTwo(String filePath) {
		this.file = new File(filePath);
		try {
			buffReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * solution to the first part of the problem
	 * @return the positon of the submarine after reading the instructions
	 */
	public int processPosition() {
		int depth = 0;
		int horizontal = 0;
		
		//read each line, split by space then figure out how to adjust your data
		String line;
		try {
			while((line = buffReader.readLine()) != null) {
				String data[] = line.split("\s");
				
				//add calculation based on first command
				if(data[0].equalsIgnoreCase("forward")) {
					horizontal += Integer.parseInt(data[1]);
				}else if(data[0].equalsIgnoreCase("down")) {
					depth += Integer.parseInt(data[1]);
				}else if(data[0].equalsIgnoreCase("up")) {
					depth -= Integer.parseInt(data[1]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(depth);
		System.out.println(horizontal);
		
		return depth * horizontal;
	}
	
	public int processPositionTwo() {
		int depth = 0;
		int horizontal = 0;
		int aim = 0;
		
		//read each line, split by space then figure out how to adjust your data
		String line;
		try {
			while((line = buffReader.readLine()) != null) {
				String data[] = line.split("\s");
				
				//add calculation based on first command
				if(data[0].equalsIgnoreCase("forward")) {
					horizontal += Integer.parseInt(data[1]);
					depth += (aim*Integer.parseInt(data[1]));
				}else if(data[0].equalsIgnoreCase("down")) {
					aim += Integer.parseInt(data[1]);
				}else if(data[0].equalsIgnoreCase("up")) {
					aim -= Integer.parseInt(data[1]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(depth);
		System.out.println(horizontal);
		
		return depth * horizontal;
	}
}
