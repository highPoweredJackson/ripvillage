import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class algo {
	
	//technique 1
	public static boolean tech1(String s1, String s2) {
		int i,j;
		s1.toLowerCase();
		s2.toLowerCase();
		
		StringBuilder sb = new StringBuilder(s2);

		//checks if word1 and word2 are same length
		if(s1.length() != s2.length()) {
			return false;
		}
		
		for(i = 0; i < s1.length(); i++) {
			for(j = 0; j < sb.length(); j++) {
				if(s1.charAt(i)==sb.charAt(j)){
					sb.deleteCharAt(j);
					break;
				}
			}
		}
		if(sb.length()== 0) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean tech2(String s1, String s2){
		int i;
		s1.toLowerCase();
		s2.toLowerCase();

		//checks if word1 and word2 are same length
		if(s1.length()!= s2.length()) {
			return false;
		}
		char[] word1 = s1.toCharArray();
		char[] word2 = s2.toCharArray();
		
		Arrays.sort(word1);
		Arrays.sort(word2);
		
		for(i = 0;i < word1.length; i++){
			if(word1[i] != word2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean tech3(String s1, String s2){
		int i, j, k;
		
		if(s1.length() != s2.length()){
			return false;
		}
		int[] array = new int[128];
		for (i = 0; i < s1.length(); i++) {
			array[(s1.charAt(i))]++;
		}
		for (j = 0; j < s2.length(); j++) {
			array[(s2.charAt(j))]++;
		}
		for (k = 0; k < array.length; k++) {
			if(array[k] != 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("src/Dict.txt");
		String word;
		int i, j;
		int count = 0;
		int maxCount = 0;
		String maxAnagram = null;
		int nano = 1000000000;
		
		try{			
	        @SuppressWarnings("resource")
			Scanner scan = new Scanner(file);
	        while (scan.hasNext()) {
				word = scan.next();
				list.add(word);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TESTING TECH1
		long start = System.nanoTime();
		for(i = 0; i < list.size();i++){
			count = 0;
			for(j = i + 1; j < list.size(); j++) {
				if(tech1(list.get(i),list.get(j))) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxAnagram = list.get(i);
			}
		}
		long end = System.nanoTime();
		long time = (end - start)/nano;

		System.out.println("tech1: " + time + "seconds" + "\n" 
		+ "most used anagram: " + maxAnagram + "\n"
				+ "used: " + maxCount + "\n");
		
		//TESTING TECH2
		start = System.nanoTime();
		for(i = 0; i < list.size();i++){
			count = 0;
			for(j = i + 1; j < list.size(); j++) {
				if(tech2(list.get(i),list.get(j))) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxAnagram = list.get(i);
			}
		}
		end = System.nanoTime();
		time = (end - start)/nano;
		System.out.println("tech2: " + time + "seconds" + "\n" 
		+ "most used anagram: " + maxAnagram + "\n"
				+ "used: " + maxCount + "\n");
		
		//TEST TECH3
		start = System.nanoTime();
		for(i = 0; i < list.size();i++){
			count = 0;
			for(j = i + 1; j < list.size(); j++) {
				if(tech3(list.get(i),list.get(j))) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxAnagram = list.get(i);
			}
		}
		end = System.nanoTime();
		time = (end - start)/nano;
		System.out.println("tech3: " + time + "seconds" + "\n" 
		+ "most used anagram: " + maxAnagram + "\n"
				+ "used: " + maxCount + "\n");
	}
}
