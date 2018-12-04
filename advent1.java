package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class advent1 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\MPeters\\Desktop\\input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		 String input; 
		 int sum = 0;
		  while ((input = br.readLine()) != null) 
		    if(input.charAt(0)=='+') {
		    	sum+=Integer.parseInt(input.substring(1));
		    }else {
		    	sum-=Integer.parseInt(input.substring(1));
		    }
		  System.out.println(sum);
	}
}
