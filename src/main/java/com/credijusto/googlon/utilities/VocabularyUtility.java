package com.credijusto.googlon.utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Rafael León Gómez
 *
 */
public class VocabularyUtility {
	
	private VocabularyUtility() {}
	
	public static List<String> getWords(final String text) {
		List<String> wordList = new LinkedList<>();
		wordList.addAll(Arrays.asList(text.split(Constants.SPACE_LETTER)));
		return wordList;
	}

	public static Set<String> getSortedVocabulary(final List<String> words) {
		Set<String> result = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int match = Constants.ZERO;
				int endIndexO1 = o1.length() - 1;
				int endIndexO2 = o2.length() - 1;
				int equalLength = o1.length() - o2.length();
				for (int index = Constants.ZERO; index < o1.length() || index < o2.length(); index++) {
					if ((match = Constants.GOOBLON_ALPHABET.indexOf(o1.charAt(index))
							- Constants.GOOBLON_ALPHABET.indexOf(o2.charAt(index))) != Constants.ZERO)
						return match;
					else if (index == endIndexO1 || index == endIndexO2)
						return equalLength;
				}
				return match;
			}
		});
		result.addAll(words);
		return result;
	}

}
