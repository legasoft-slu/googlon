package com.credijusto.googlon.utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rafael León Gómez
 *
 */
public class NumbersUtility {
	
	private NumbersUtility() {}
	
	public static Set<String> searchPrettyNumbers(final List<String> words) {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			if (isPrettyNumber(word))
				result.add(word);
		}
		return result;
	}

	private static boolean isPrettyNumber(String word) {
		long numberValue = getNumberValue(word, Constants.ZERO);
		return (numberValue >= Constants.MINIMUM_PRETTY_NUMBER_VALUE
				&& (numberValue % Constants.THREE) == Constants.ZERO);
	}

	private static long getNumberValue(final String word, final int position) {
		if (position < word.length()) {
			int digitValue = Constants.GOOBLON_ALPHABET.indexOf(word.charAt(position));
			return (digitValue * ((long) Math.pow(20, position))) + getNumberValue(word, position + Constants.ONE);
		} else
			return 0;

	}

}
