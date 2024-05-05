package com.bitswilp.langLearn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitswilp.langLearn.api.models.UserLanguageQuizModel;
import com.bitswilp.langLearn.api.models.UserLanguageYoutubeLinkModel;



@Repository
public interface UserLanguageQuizRepository extends JpaRepository<UserLanguageQuizModel, Long>{
	
	List<UserLanguageQuizModel> findByLevelAndLanguage(String level, String language);


}
