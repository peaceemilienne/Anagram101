package src.anagramClasses;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Option.Builder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Anagrammer { 

	public static void main(String[] args) {
		// Creating variables and instances I will be using thought this class
		AnagramEvaluatorImpl evaluator = new AnagramEvaluatorImpl();
		Options anagrammerOptions = new Options();
		String start = "Options";
		String end = "";
		Builder anagrammerBuilder = Option.builder("a").argName("word").hasArg(true)
				.desc("Supplies the anagram to evaluate").longOpt("anagram");

		CommandLineParser anagrammerParser = new DefaultParser();
		CommandLine anagrammerLine = null;
		String anagramWord = "";
		boolean defaultAnagram = true;

		// Adding options
		anagrammerOptions.addOption(anagrammerBuilder.build());
		anagrammerOptions.addOption("nf", "no-filter", false, "output all anagram values with no filter");
		anagrammerOptions.addOption("words", "filter-words", false, "output only values that are known words");
		anagrammerOptions.addOption("h", "help", false, "displays the help for this program");

		try {

			anagrammerLine = anagrammerParser.parse(anagrammerOptions, args);

		} catch (ParseException e) {

			System.out.println("The option can't be recognised!");
			return;

		}

		if (anagrammerLine.hasOption("a") || anagrammerLine.hasOption("anagram")) {

			anagramWord = anagrammerLine.getOptionValue("a", "anagram");
			defaultAnagram = true;

		}
		if (anagrammerLine.hasOption("nf") || anagrammerLine.hasOption("no-filter")
				|| args[args.length - 1].equals("nf") && !args[args.length - 1].equals("h")
				|| args[args.length - 1].equals("no-filter") && !args[args.length - 1].equals("h")) {
			defaultAnagram = false;
			String optionN = anagrammerLine.getOptionValue("no-filter", "nf");

			if (anagramWord.isEmpty() || anagramWord.length() == 0 || anagramWord == null) {
				System.out.println("Missing required option: -a");
				return;
			}
			List<String> optionB = evaluator.evaluate(anagramWord, optionN);

			for (String allPossible : optionB) {
				System.out.println(allPossible);

			}
			System.out.println("\n");
			System.out.println("-- " + optionB.size() + " value(s) found");
		}

		if (anagrammerLine.hasOption("words") || anagrammerLine.hasOption("filter-words")
				|| defaultAnagram && !anagrammerLine.hasOption("h") && !args[args.length - 1].equals("h")) {
			String optionW = anagrammerLine.getOptionValue("filter-words", "words");
			if (anagramWord.isEmpty() || anagramWord.length() == 0 || anagramWord == null) {
				System.out.println("Missing required option: -a");
				return;
			}

			List<String> optionC = evaluator.evaluate(anagramWord, optionW);
			if (optionC.size() == 0) {
				System.out.println("Your word's anagrams doesn't exist in the file!");
				return;

			}
			for (String possible : optionC) {
				System.out.println(possible);
			}
			System.out.println("\n");
			System.out.println("-- " + optionC.size() + " value(s) found");
		}
		if (anagrammerLine.hasOption("h") || anagrammerLine.hasOption("help") || args[0].equals("h")) {

			HelpFormatter anagrammerHelper = new HelpFormatter();
			anagrammerHelper.printHelp("anagrammer", start, anagrammerOptions, end);

		}

	}
}
