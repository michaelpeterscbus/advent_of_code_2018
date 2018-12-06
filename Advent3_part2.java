package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Advent3_part2 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\MPeters\\Desktop\\input3.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		Map<String,Integer> rectangleSizes = new HashMap<String,Integer>();
		String[][] board = new String[1200][1200];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = ".";
			}
		}
		
		while ((input = br.readLine()) != null) {
			String[] splitString = input.split("[@,:x]");
			for(int i = 0; i < splitString.length; i++) {
				splitString[i] = splitString[i].trim();
			}
			String id = splitString[0].substring(1);
			int xCoord = Integer.parseInt(splitString[1]);
			int yCoord = Integer.parseInt(splitString[2]);
			int length = xCoord + Integer.parseInt(splitString[3]);
			int height = yCoord + Integer.parseInt(splitString[4]);
			rectangleSizes.put(id, Integer.parseInt(splitString[3]) * Integer.parseInt(splitString[4]));
			for(int x = xCoord; x < length; x++) {
				for (int y = yCoord; y < height; y++){
					if(board[y][x] == ".") {
						board[y][x] = id;
					}else {
						board[y][x] = "X";
					}
				}
			}
		}
		List<String> ids =new ArrayList<String>();
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board.length; y++) {
				if (board[y][x] != "X" && board[y][x] != ".") {
					ids.add(board[y][x]);
				}
			}
		}
		 Map<String, Long> result = ids.stream()
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Map.Entry<String,Integer> entry : rectangleSizes.entrySet()) {
		    String key = entry.getKey();
		    if(ids.contains(key) && rectangleSizes.get(key) == Integer.parseInt(result.get(key).toString())) {
		    	System.out.println(key);
		    }
		}
	}
}
