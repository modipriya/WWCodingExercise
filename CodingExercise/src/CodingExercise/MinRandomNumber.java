package CodingExercise;

import java.util.*;

public class MinRandomNumber {

	public static void main(String args[]) {
		
		List<Integer> randomNumbers = new ArrayList<>();
		Random rand = new Random();
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter n value");
		Integer number = Integer.parseInt(myObj.nextLine());
		
		for(int i=0;i<500;i++) {
			int randomNumber = rand.nextInt();
			randomNumbers.add(randomNumber);
			System.out.println(randomNumber);
		}
		
		Collections.sort(randomNumbers);
		System.out.println(number+"th smallest Number"+ +randomNumbers.get(number));

	}

}
