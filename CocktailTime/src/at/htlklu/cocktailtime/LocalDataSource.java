package at.htlklu.cocktailtime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocalDataSource {
	public static void main(String[] args) {
		System.out.println(readCocktails("example.txt"));
	}

	public static Map<String, HashSet<String>> readCocktails(String fileName) {
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			int itemsSize = Integer.parseInt(reader.readLine());
			
			Map<String, HashSet<String>> result = new HashMap<String, HashSet<String>>();
			for(int i = 0; i<itemsSize; i++) {
				String[] data = reader.readLine().split(":");
				HashSet<String> ingrediants = new HashSet<>();
				
				for(String value:data[1].split(",")) {
					ingrediants.add(value);
				}
				
				result.put(data[0], ingrediants);
			}
			
			return result;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
