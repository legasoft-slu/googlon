package com.credijusto.googlon.beans;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Rafael León Gómez
 *
 */
public class Googlon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7751812666278492721L;

	/**
	 * The distinctNumbers of Gooblon
	 */
	private long distinctNumbers;

	/**
	 * The prepositions of Gooblon
	 */
	private long prepositions;

	/**
	 * The subjunctives of Gooblon
	 */
	private long subjunctives;

	/**
	 * The verbs of Gooblon
	 */
	private long verbs;

	/**
	 * The vocabulary list of Gooblon
	 */
	private String[] vocabularyList;

	/**
	 * @param prepositions
	 * @param verbs
	 * @param subjunctives
	 * @param vocabulary
	 * @param distinctNumbers
	 */
	public Googlon(final long prepositions, final long verbs, final long subjunctives, final String[] vocabularyList,
			final long distinctNumbers) {
		this.prepositions = prepositions;
		this.verbs = verbs;
		this.subjunctives = subjunctives;
		this.vocabularyList = vocabularyList;
		this.distinctNumbers = distinctNumbers;
	}

	/**
	 * @return the distinctNumbers
	 */
	public final long getdistinctNumbers() {
		return distinctNumbers;
	}

	/**
	 * @return the prepositions
	 */
	public long getPrepositions() {
		return prepositions;
	}

	/**
	 * @return the subjunctives
	 */
	public long getSubjunctives() {
		return subjunctives;
	}

	/**
	 * @return the verbs
	 */
	public long getVerbs() {
		return verbs;
	}

	/**
	 * @return the vocabulary
	 */
	public String[] getVocabularyList() {
		return vocabularyList;
	}

	/**
	 * @param distinctNumbers
	 *            the distinctNumbers to set
	 */
	public void setdistinctNumbers(final long distinctNumbers) {
		this.distinctNumbers = distinctNumbers;
	}

	/**
	 * @param prepositions
	 *            the prepositions to set
	 */
	public void setPrepositions(final long prepositions) {
		this.prepositions = prepositions;
	}

	/**
	 * @param subjunctives
	 *            the subjunctives to set
	 */
	public void setSubjunctives(final long subjunctives) {
		this.subjunctives = subjunctives;
	}

	/**
	 * @param verbs
	 *            the verbs to set
	 */
	public void setVerbs(final long verbs) {
		this.verbs = verbs;
	}

	/**
	 * @param vocabulary
	 *            the vocabulary to set
	 */
	public void setVocabularyList(final String[] vocabularyList) {
		this.vocabularyList = vocabularyList;
	}

	public String printOutput() {
		return "1) There are " + prepositions + " prepositions in the text\n" + "2) There are " + verbs
				+ " verbs in the text\n" + "3) There are " + subjunctives + " subjunctive verbs in the text\n"
				+ "4) Vocabulary list:" + printVocabularyList() + "\n5) There are " + distinctNumbers
				+ " distinct pretty numbers in the text";
	}

	private String printVocabularyList() {
		StringBuilder result = new StringBuilder("");
		for (String word : vocabularyList)
			result.append(" ").append(word);
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (distinctNumbers ^ (distinctNumbers >>> 32));
		result = prime * result + (int) (prepositions ^ (prepositions >>> 32));
		result = prime * result + (int) (subjunctives ^ (subjunctives >>> 32));
		result = prime * result + (int) (verbs ^ (verbs >>> 32));
		result = prime * result + Arrays.hashCode(vocabularyList);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Googlon)) {
			return false;
		}
		Googlon other = (Googlon) obj;
		if (distinctNumbers != other.distinctNumbers) {
			return false;
		}
		if (prepositions != other.prepositions) {
			return false;
		}
		if (subjunctives != other.subjunctives) {
			return false;
		}
		if (verbs != other.verbs) {
			return false;
		}
		if (!Arrays.equals(vocabularyList, other.vocabularyList)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Googlon [distinctNumbers=" + distinctNumbers + ", prepositions=" + prepositions + ", subjunctives="
				+ subjunctives + ", verbs=" + verbs + ", vocabulary=" + Arrays.toString(vocabularyList) + "]";
	}

}
