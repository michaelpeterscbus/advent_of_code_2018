package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Advent1_part2 {
	public static void main(String[] args) throws IOException {
		
		 String input; 
		 int sum = 0;
		 Set<Integer> frequencySet = new HashSet<Integer>();
		 boolean isUniqueFrequency = true;
		 while(isUniqueFrequency) {
			 File file = new File("C:\\Users\\MPeters\\Desktop\\input.txt");
			 BufferedReader br = new BufferedReader(new FileReader(file));
			 while ((input = br.readLine()) != null) {
				 if(input.charAt(0)=='+') {
				    	sum+=Integer.parseInt(input.substring(1));
				    }else {
				    	sum-=Integer.parseInt(input.substring(1));
				    }
				 isUniqueFrequency = frequencySet.add(sum);
				 if(!isUniqueFrequency) {
					 break;
				 }
			 }
		 }
		 System.out.println(sum);
	}
}

