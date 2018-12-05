package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Advent2_part1 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\MPeters\\Desktop\\input2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		
		int count2letters = 0;
		int count3letters = 0;
		while ((input = br.readLine()) != null) {
			Map<Character, Integer> countPerLetterMap = new HashMap<Character, Integer>();
			for(int i = 0; i < input.length(); i++) {
				 char letter = input.charAt(i);
				 if (countPerLetterMap.containsKey(letter)){
					 int count = countPerLetterMap.get(letter);
					 countPerLetterMap.put(letter,++count);
				 }else {
					 countPerLetterMap.put(letter, 1);
				 }

			}
			int count2holder = count2letters + 1;
			int count3holder = count3letters + 1;
			for(int value: countPerLetterMap.values()) {
				if(value == 2 && count2letters < count2holder) {
					count2letters++;
				}
				if(value==3 && count3letters < count3holder) {
					count3letters++;
				}
			}
		}
		System.out.println("checksum = " + count2letters * count3letters);
	}
}
