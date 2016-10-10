package com.cecep.model;

public class CecepWords {

	public CecepWords() {
	}

	public CecepWords(String pinyin, String word) {
		this.pinyin = pinyin;
		this.word = word;
	}

	private Integer id;

	private String pinyin;

	private String word;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin == null ? null : pinyin.trim();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word == null ? null : word.trim();
	}

	@Override
	public String toString() {
		return "CecepWords [pinyin=" + pinyin + ", word=" + word + "]";
	}

}