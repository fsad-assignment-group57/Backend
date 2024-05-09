package com.bitswilp.langLearn.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userlanguages")
public class UserLanguageModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long language_id;
	
	
	@Column(name = "languages")
	private String languages;
	
	@Column(name = "native_language")
	private String nativeLanguage;

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getNativeLanguage() {
		return nativeLanguage;
	}

	public void setNativeLanguage(String nativeLanguage) {
		this.nativeLanguage = nativeLanguage;
	}

	

}
