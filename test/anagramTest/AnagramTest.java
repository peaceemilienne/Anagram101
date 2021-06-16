package test.anagramTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import src.anagramClasses.*;
import org.junit.Test;

public class AnagramTest {

	@Test
	public void testAnagramDataReader() {

		// Class instances that will be used to access the 2 classes that will be tested
		AnagramDataReaderImpl data = new AnagramDataReaderImpl();
		AnagramEvaluatorImpl anagramImpl = new AnagramEvaluatorImpl();
		@SuppressWarnings("unused")
		Anagrammer anagramaCLI = new Anagrammer();

		// Testing the AnagramDataReaderImpl class

		// Testing the file returned is not null
		Set<String> dataReturned = data.readData();
		Set<String> dataExpected = null;

		// Asserting returned data
		assertThat(373295, is(dataReturned.size()));
		assertNotEquals(dataExpected, dataReturned);

		// Testing the AnagramEvaluatorImpl class

		// Testing filtered words
		List<String> expectedAnagrams = Arrays.asList("DOG", "GOD");
		List<String> returnedAnagrams = anagramImpl.evaluate("DOG", "words");
		List<String> returnedAnagramsE = anagramImpl.evaluate("DOG", "");
		List<String> returnedAnagramsL = anagramImpl.evaluate("DOG", "filter-words");

		// Testing non filtered words
		List<String> expectedAnagrams1 = Arrays.asList("ant", "atn", "nat", "nta", "tan", "tna");
		List<String> returnedAnagrams1 = anagramImpl.evaluate("nta", "nf");
		List<String> returnedAnagramsO = anagramImpl.evaluate("nta", "no-filter");
		List<String> returnedAnagramsC = anagramImpl.evaluate("pEace", "");

		// Testing case insensitivity
		boolean caseIgnored = false;
		if (returnedAnagramsC.contains("pEace") || returnedAnagramsC.contains("peacE")) {
			caseIgnored = true;
		}

		// Testing invalid and null options
		List<String> expectedAnagramsM = null;
		List<String> returnedAnagramsM = anagramImpl.evaluate("nta", "nofilter");
		List<String> returnedAnagramsN = anagramImpl.evaluate("nta", null);

		String[] mainArray1 = new String[] { "-anagram", "nta", "nf" };
		String[] mainArray2 = new String[] { "-a", "nta", "no-filter" };
		String[] mainArray3 = new String[] { "-a", "DOG", "words" };
		String[] mainArray4 = new String[] { "-a", "DOG", "filter-words" };
		String[] mainArray5 = new String[] { "-a", "DOG", "" };
		String[] mainArray6 = new String[] { "-a", "DOG" };
		String[] mainArray7 = new String[] { "h" };
		String[] mainArray8 = new String[] { "-nf" };
		String[] mainArray9 = new String[] { "-filter-words" };
		String[] mainArray10 = new String[] { "-noft" };
		String[] mainArray11 = new String[] { "-a", "Nzi" };

		Anagrammer.main(mainArray1);
		Anagrammer.main(mainArray2);
		Anagrammer.main(mainArray3);
		Anagrammer.main(mainArray4);
		Anagrammer.main(mainArray5);
		Anagrammer.main(mainArray6);
		Anagrammer.main(mainArray7);
		Anagrammer.main(mainArray8);
		Anagrammer.main(mainArray9);
		Anagrammer.main(mainArray11);

		// Asserting all returned arrayLists from AnagramEvaluatorImpl class

		assertThat(true, is(caseIgnored));
		assertThat(expectedAnagrams, is(returnedAnagramsL));
		assertThat(expectedAnagrams1, is(returnedAnagramsO));
		assertThat(expectedAnagrams, is(returnedAnagrams));
		assertThat(expectedAnagrams, is(returnedAnagramsE));
		assertThat(expectedAnagrams1, is(returnedAnagrams1));
		assertThat(expectedAnagramsM, is(returnedAnagramsM));
		assertThat(expectedAnagramsM, is(returnedAnagramsN));

		try {

			Anagrammer.main(mainArray10);
		} catch (Exception message) {
			fail("Parsing exception");
		}

		AnagramDataReaderImpl.anagramFile = "non.txt";

		try {

			data.readData();
		} catch (Exception e) {
			fail("File not found  exception");
		}
	}

}
