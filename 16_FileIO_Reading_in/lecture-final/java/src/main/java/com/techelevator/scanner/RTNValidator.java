package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args){

		printApplicationBanner();
		File inputFile = new File("java/rtn.txt");//"C:\\Users\\Student\\workspace\\NLR-2\\peggygreen\\module-1\\16_FileIO_Reading_in\\student-lecture\\java\\rtn.txt");

		if (inputFile.exists()){
			System.out.println("file exists");
		} else {
			System.out.println("file doesn't exist");
		}
		try (Scanner fileScanner = new Scanner(inputFile)){  // try with resources means it will close the file after it is done
			while(fileScanner.hasNextLine()){  // while there is still content to read in the file
				String line = fileScanner.nextLine(); // pick up one line of code from the file
//				System.out.println(line);
				if (checksumIsValid(line) == false){
					System.out.println("Bad checksum: " + line);
				}
			}
		} catch (FileNotFoundException e){
			System.out.println("uhoh!  File not found!!!");
		}

	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
