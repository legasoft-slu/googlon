package com.credijusto.googlon.utilities;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rafael León Gómez
 *
 */
public class VerbsUtility {
	
	private VerbsUtility() {}

	public static List<String> searchVerbs(List<String> words) {
		List<String> result = new LinkedList<>();
		List<String> wordList = new LinkedList<>(words);
		for (String word : wordList) {
			if (isVerb(word)) {
				((LinkedList<String>) result).addLast(word);
				words.remove(word);
			}
		}
		return result;
	}
	
	public static List<String> getSubjunctives(List<String> verbs) {
		List<String> result = new LinkedList<>();
		if (verbs != null && !verbs.isEmpty()) {
			for (String verb : verbs.toArray(new String[0])) {
				if (isSubjunctive(verb))
					((LinkedList<String>) result).addLast(verb);
			}
		}
		return result;
	}

	private static boolean isVerb(String word) {
		return (word.length() >= Constants.PREPOSITION_LENGTH && endsWithBar(word));
	}

	private static boolean endsWithBar(String word) {
		for (String bar : Constants.BAR_LETTERS) {
			if (word.endsWith(bar))
				return true;
		}
		return false;
	}

	private static boolean isSubjunctive(String verb) {
		for (String bar : Constants.BAR_LETTERS) {
			if (verb.startsWith(bar))
				return true;
		}
		return false;
	}
	
}
