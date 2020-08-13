package CodingExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class WordMeaning {
	
	static void doesFileExist(String path) {
		BufferedReader br = null;
		String strline = "";
		try {
			br=new BufferedReader (new FileReader(path));
			
			while((strline = br.readLine()) != null) {
				String key[] = strline.split("-");
				
				for (int i=0;i<key.length;i++) {
					
					if (key[i].contains(",")) {
						String value[] = key[i].split(",");
						for (int j=0;j<value.length;j++) {
							System.out.println(value[j].toString().trim());
						}
					}
					else {
						System.out.println(key[i].toString().trim());
					}
				}
			}
			
			br.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
		catch (IOException e) {
			System.err.println("unable to read the file");
		}
	}

	public static void main(String[] args) {
		
		//Create input file and give Location.
		String path = "C:/input.txt";
		doesFileExist(path);
        
	}

}
