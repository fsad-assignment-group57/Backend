package com.bitswilp.langLearn.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_sentence_formation")
public class UserLanguageSentenceModel {

	@Id
	private long id;

	@Column(name = "level")
	private String level;

	@Column(name = "language")
	private String language;

	@Column(name = "english_word")
	private String english_word;

	@Column(name = "language_word")
	private String language_word;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEnglish_word() {
		return english_word;
	}

	public void setEnglish_word(String english_word) {
		this.english_word = english_word;
	}

	public String getLanguage_word() {
		return language_word;
	}

	public void setLanguage_word(String language_word) {
		this.language_word = language_word;
	}

	public UserLanguageSentenceModel(String level, String language, String link_youtube_word,String language_word,  String english_word) {
		super();
		this.level = level;
		this.language = language;
		this.language_word = language_word;
		this.english_word = english_word;
	}

	public UserLanguageSentenceModel() {

	}

}
