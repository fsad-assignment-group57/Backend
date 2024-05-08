package com.bitswilp.langLearn.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserLevelKey {
	
	@Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "level", nullable = false)
    private String level;
    
    @Column(name = "langauge", nullable = false)
    private String langauge;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLangauge() {
		return langauge;
	}

	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}
    
}
