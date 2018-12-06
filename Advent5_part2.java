package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent5_part2 {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\MPeters\\Desktop\\input5.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String polymer;
		Map<Character, Integer> unitMap = new HashMap<Character, Integer>();
		unitMap.put('a', 0);
		unitMap.put('b', 0);
		unitMap.put('c', 0);
		unitMap.put('d', 0);
		unitMap.put('e', 0);
		unitMap.put('f', 0);
		unitMap.put('g', 0);
		unitMap.put('h', 0);
		unitMap.put('i', 0);
		unitMap.put('j', 0);
		unitMap.put('k', 0);
		unitMap.put('l', 0);
		unitMap.put('m', 0);
		unitMap.put('n', 0);
		unitMap.put('o', 0);
		unitMap.put('p', 0);
		unitMap.put('q', 0);
		unitMap.put('r', 0);
		unitMap.put('s', 0);
		unitMap.put('t', 0);
		unitMap.put('u', 0);
		unitMap.put('v', 0);
		unitMap.put('w', 0);
		unitMap.put('x', 0);
		unitMap.put('y', 0);
		unitMap.put('z', 0);
		while ((polymer = br.readLine()) != null) {
			String polymerHolder = polymer;
			for (Character key : unitMap.keySet()) {
				for (int i = 0; i < polymer.length(); i++) {
					if (Character.toLowerCase(polymer.charAt(i)) == key) {
						polymer = polymer.substring(0, i) + polymer.substring(i + 1);
						i = -1;
					}
				}
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
					unitMap.put(key, polymer.length());
				}
				polymer = polymerHolder;
			}
			List<Integer> valueList = new ArrayList<Integer>();
			for (int value : unitMap.values()) {
				valueList.add(value);
			}
			Collections.sort(valueList);
			for (Integer value : valueList) {
				if (value != 0) {
					System.out.println(value);
					break;
				}
			}
		}
	}
}
