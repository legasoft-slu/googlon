package com.credijusto.googlon.utilities;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rafael León Gómez
 *
 */
public class PrepositionsUtility {
	
	private PrepositionsUtility() {}

	public static List<String> searchPrepositions(final List<String> words) {
		List<String> result = new LinkedList<>();
		List<String> wordList = new LinkedList<>(words);
		for (String word : wordList) {
			if (isPreposition(word)) {
				((LinkedList<String>) result).addLast(word);
				words.remove(word);
			}
		}
		return result;
	}

	private static boolean isPreposition(String word) {
		return (word.length() == Constants.PREPOSITION_LENGTH && endsWithFoo(word) && !containsU(word));
	}

	private static boolean endsWithFoo(String word) {
		for (String foo : Constants.FOO_LETTERS) {
			if (word.endsWith(foo))
				return true;
		}
		return false;
	}

	private static boolean containsU(String word) {
		return word.contains(Constants.U_LETTER);
	}
	
}
