package com.bitswilp.langLearn.api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_language_model")
@Data //To get Access to Getters and Setters
@NoArgsConstructor
public class UserLevelModel {
	
	@EmbeddedId
    private UserLevelKey userLevelKey;
	
	 @Column(name = "points")
	 private long points;
	 
	 

}
