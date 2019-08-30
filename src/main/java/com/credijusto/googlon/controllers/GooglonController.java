/**
 * 
 */
package com.credijusto.googlon.controllers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credijusto.googlon.beans.Googlon;
import com.credijusto.googlon.utilities.Constants;
import com.credijusto.googlon.utilities.NumbersUtility;
import com.credijusto.googlon.utilities.PrepositionsUtility;
import com.credijusto.googlon.utilities.VerbsUtility;
import com.credijusto.googlon.utilities.VocabularyUtility;

/**
 * @author Rafael León Gómez
 *
 */
@RestController
public class GooglonController {

	/**
	 * 
	 * @param text
	 * @return a Googlon result output
	 */
	@RequestMapping(Constants.GOOGLON_MAPPING)
	public String googlon(@PathVariable(Constants.PARH_VARIABLE) String text) {
		return analyzeGooglonText(text);
	}

	private String analyzeGooglonText(final String text) {
		LinkedList<String> words = (LinkedList<String>) VocabularyUtility.getWords(text); 
		TreeSet<String> sortedVocabulary = (TreeSet<String>) VocabularyUtility.getSortedVocabulary(words);
		HashSet<String> numbers = (HashSet<String>) NumbersUtility.searchPrettyNumbers(words);
		LinkedList<String> verbs = (LinkedList<String>) VerbsUtility.searchVerbs(words);
		LinkedList<String> prepositions = (LinkedList<String>) PrepositionsUtility.searchPrepositions(words);
		LinkedList<String> subjunctive = (LinkedList<String>) VerbsUtility.getSubjunctives(verbs);
		Googlon googlon = new Googlon(prepositions.size(), verbs.size(), subjunctive.size(),
				sortedVocabulary.toArray(new String[0]), numbers.size());
		return googlon.printOutput();
	}

}
