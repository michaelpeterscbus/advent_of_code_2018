package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Advent2_part2 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\MPeters\\Desktop\\input2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		String id="";
		String id2="";
		List<Character[]> boxIDs = new ArrayList<Character[]>();
		while ((input = br.readLine()) != null) {
			Character[] letters = new Character[input.toCharArray().length];
			for(int i = 0; i < letters.length; i++) {
				letters[i] = input.charAt(i);
			}
			boxIDs.add(letters);
		}
		for(int firstIDindex = 0; firstIDindex < boxIDs.size(); firstIDindex++) {
			for(int nextIDindex = 1; nextIDindex < boxIDs.size(); nextIDindex++) {
				int countMismatch = 0;
				for(int letterIndex = 0; letterIndex < boxIDs.get(nextIDindex).length; letterIndex++) {
					if(boxIDs.get(firstIDindex)[letterIndex] != boxIDs.get(nextIDindex)[letterIndex]) {
						countMismatch++;
					}
				}
				if(countMismatch == 1) {
					for(char letter : boxIDs.get(firstIDindex)) {
						id = id + letter;
					}
					for(char letter : boxIDs.get(nextIDindex)) {
						id2 = id2 + letter;
					}		
				}
			}
		}
		System.out.println(id);
		System.out.println(id2);
	}

}
