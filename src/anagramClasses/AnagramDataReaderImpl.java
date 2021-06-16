package src.anagramClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class AnagramDataReaderImpl implements AnagramDataReader {
	// Creating variables to be used in a class
	public static Scanner dataReader = null;
	public static String anagramFile = "C:\\Users\\peaceemilienne4\\Desktop\\projectsPeace\\Anagram101\\src\\anagramText\\anagram_data.txt";

	@Override
	public Set<String> readData() {

		Set<String> anagramData = new LinkedHashSet<String>();

		try {
			dataReader = new Scanner(new File(anagramFile));

			while (dataReader.hasNextLine()) {

				anagramData.add(dataReader.nextLine());

			}
			dataReader.close();

		} catch (FileNotFoundException exceptionMessage) {
			System.out.println("File not found");
		}
		return anagramData;
	}
}