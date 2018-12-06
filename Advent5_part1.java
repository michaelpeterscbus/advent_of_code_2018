package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Advent5_part1 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\MPeters\\Desktop\\input5.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String polymer;

		while ((polymer = br.readLine()) != null) {
			for (int i = 0; i < polymer.length(); i++) {
				if (i + 1 < polymer.length()) {
					Character a = polymer.charAt(i);
					Character b = polymer.charAt(i + 1);
					if ((Character.toLowerCase(a) == Character.toLowerCase(b))
							&& ((Character.isUpperCase(a) && Character.isLowerCase(b))
									|| (Character.isLowerCase(a) && Character.isUpperCase(b)))) {

						polymer = polymer.substring(0, i) + polymer.substring(i + 2);
						i = -1;
					}

				}

			}
			System.out.println(polymer.length());
		}
	}
}
