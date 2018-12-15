package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Advent4_part1 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\MPeters\\Desktop\\input4.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input;
		String[] splitParts = new String[2];
		String[] timeArray = new String[6];
		Map<LocalDateTime, String> map = new TreeMap<LocalDateTime, String>();
		while ((input = br.readLine()) != null) {
			splitParts = input.split("\\]");
			timeArray = splitParts[0].split("[- :]");
			String description = splitParts[1];
			int year = Integer.parseInt(timeArray[0].substring(1));
			int month = Integer.parseInt(timeArray[1]);
			int day = Integer.parseInt(timeArray[2]);
			int hour = Integer.parseInt(timeArray[3]);
			int minute = Integer.parseInt(timeArray[4].substring(0, 2));
			LocalDate date = LocalDate.of(year, month, day);
			LocalTime time = LocalTime.of(hour, minute);
			LocalDateTime dateAndTime = LocalDateTime.of(date, time);
			map.put(dateAndTime, description);
		}
		Map<String, Integer> guardMinuteCount = new HashMap<String, Integer>();
		Map<String, LocalDateTime> guardAndTime = new HashMap<String, LocalDateTime>();
		String guardID = "";
		int minutes;
		String startMinute = "";
		String endMinute = "";
		int timeAsleep = 0;
		for (Map.Entry<LocalDateTime,String> entry : map.entrySet()) {
			if (entry.getValue().startsWith(" Guard")){
				guardID = "";
				String[] splitDescription = entry.getValue().split("#");
				
				for(int i = 0; i < splitDescription[1].length(); i++) {
					if(splitDescription[1].charAt(i) == ' ') {
						break;
					}
					guardID = guardID + splitDescription[1].charAt(i);
				}
			
			}else if(entry.getValue().contains("w")){
				if(entry.getKey().getHour() == 0) {
					endMinute = Integer.toString(entry.getKey().getMinute());
				}
			}else {
					startMinute = Integer.toString(entry.getKey().getMinute());
			}
			if(startMinute != "" && endMinute !="") {
				timeAsleep = Integer.parseInt(endMinute) - Integer.parseInt(startMinute);
				if(guardMinuteCount.containsKey(guardID)) {
					guardMinuteCount.put(guardID, guardMinuteCount.get(guardID) + timeAsleep);
				}else {
					guardMinuteCount.put(guardID, timeAsleep);
				}
				startMinute = "";
				endMinute = "";
			}
			
			

		}
		int max = 0;
		String maxGuard = "";
		for(Map.Entry<String, Integer> mapEntry : guardMinuteCount.entrySet() ) {
			if(mapEntry.getValue() > max) {
				max = mapEntry.getValue();
				maxGuard = mapEntry.getKey();
			}
		}
		System.out.println("Most sleepy guard: " + maxGuard);
		Map<LocalDateTime, Integer> maxTimes = new TreeMap<LocalDateTime, Integer>();
		int workIndex = 0;
		for (Map.Entry<LocalDateTime,String> entry : map.entrySet()) {
			if (entry.getValue().startsWith(" Guard")){
				guardID = "";
				String[] splitDescription = entry.getValue().split("#");
				
				for(int i = 0; i < splitDescription[1].length(); i++) {
					if(splitDescription[1].charAt(i) == ' ') {
						break;
					}
					guardID = guardID + splitDescription[1].charAt(i);
				}
				workIndex = 1;
			}else if(entry.getValue().contains("w")){
				workIndex = 3;
			}else {
					workIndex = 2;
			}
			
			
			if(guardID.equals(maxGuard) && workIndex != 1) {
				maxTimes.put(entry.getKey(),workIndex);
			}
		}
		
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < 60; i++) {
			numberMap.put(i, 0);
		}
		String sleep = "";
		String wake = "";
		for(Map.Entry<LocalDateTime, Integer> time : maxTimes.entrySet()) {
			String day = Integer.toString(time.getKey().getDayOfMonth()) + Integer.toString(time.getKey().getMinute());
			if(time.getValue() == 2) {
				sleep = Integer.toString(time.getKey().getMinute());
			}
			if(time.getValue() == 3) {
				wake = Integer.toString(time.getKey().getMinute());
			}
			
			if(sleep != "" && wake != "") {
				int sleepInt = Integer.parseInt(sleep);
				int wakeInt = Integer.parseInt(wake);
				for (int i = sleepInt; i < wakeInt; i++) {
					int value = numberMap.get(i) + 1;
					numberMap.put(i, value);
					sleep = "";
					wake = "";
				}
			}
		}
		
		int maxMinute = 0;
		int goldenMinute = 0;
		for(Map.Entry<Integer, Integer> minute : numberMap.entrySet()) {
			if(minute.getValue() > maxMinute) {
				maxMinute = minute.getValue();
				goldenMinute = minute.getKey();
			}
		}
		
		System.out.println("Minute most asleep: " + goldenMinute);
		System.out.println("Answer: " + (Integer.parseInt(maxGuard) * goldenMinute));
	}
}
