package src.anagramClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AnagramEvaluatorImpl implements AnagramEvaluator {

	@Override
	public List<String> evaluate(String anagram, String option) {

		// Creating variables and instances to be used in this class
		List<String> anagrammerWords = new ArrayList<String>();
		List<String> anagrammerWordsFiltered = new ArrayList<String>();
		List<String> anagrammerFile = new ArrayList<String>();
		List<String> anagrammerDuplicates = new ArrayList<String>();
		Set<String> removeDuplicates = new LinkedHashSet<String>();
		AnagramDataReaderImpl readFile = new AnagramDataReaderImpl();

		// Retrieving the words from the supplied file, finding anagram words and
		// sorting them
		anagrammerFile.addAll(readFile.readData());
		int anagramLength = findAnagrammerWords(anagram.length());
		int anagramCount = 0;

		while (anagramCount < anagramLength) {
			anagrammerWords.add(findDifferentWords(anagram));
			anagramCount++;
		}

		removeDuplicates.addAll(anagrammerWords);

		anagrammerWords.clear();

		anagrammerWords.addAll(removeDuplicates);

		anagrammerDuplicates.addAll(anagrammerWords);
		Collections.sort(anagrammerWords, new Comparator<String>() {
			@Override
			public int compare(String word1, String word2) {
				int compareWords = 0;

				compareWords = word1.compareToIgnoreCase(word2);
				if (word1.equalsIgnoreCase(word2)) {

					anagrammerDuplicates.remove(word2);

				}

				return compareWords;
			}
		});

		Collections.sort(anagrammerDuplicates);
		anagrammerWords.clear();

		anagrammerWords.addAll(anagrammerDuplicates);
		if (option == null) {

			System.out.println("The option can't be null!");
			return null;
		}
		if (option.equals("nf") || option.equals("no-filter")) {

			return anagrammerWords;

		} else if (option.isEmpty() || option.equals("words") || option.length() == 0
				|| option.equals("filter-words")) {

			for (String nfAnagram : anagrammerWords) {

				if (anagrammerFile.contains(nfAnagram.toUpperCase())) {

					anagrammerWordsFiltered.add(nfAnagram);
				}
			}

			return anagrammerWordsFiltered;
		} else {
			System.out.println("Invalid option!");
			return null;
		}

	}

	public int findAnagrammerWords(int wordLength) {

		int wordsAnagram = 1, countChar = 0;

		while (countChar <= wordLength) {
			countChar++;
			wordsAnagram = wordsAnagram * countChar;

		}

		return wordsAnagram;
	}

	public String findDifferentWords(String word) {
		List<Character> anagramChar = new ArrayList<Character>();
		int wordCount = 0;
		for (char anagramChars : word.toCharArray()) {
			anagramChar.add(anagramChars);
		}
		StringBuilder differentWords = new StringBuilder();
		while (wordCount < word.length()) {
			int differentIndex = new Random().nextInt(anagramChar.size());
			differentWords.append(anagramChar.get(differentIndex));
			anagramChar.remove(differentIndex);
			wordCount++;
		}
		return differentWords.toString();
	}
}
