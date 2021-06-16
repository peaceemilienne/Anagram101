package src.anagramClasses;

import java.util.Set;

// Creating an interface
public interface AnagramDataReader {
	/**
	 * Returns a Set containing all words read from the anagram data text file.
	 *
	 * @return the Set or empty Set if no words are found.
	 */
	Set<String> readData();
}
