package com.bitswilp.langLearn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitswilp.langLearn.api.models.UserLanguageSentenceModel;
import com.bitswilp.langLearn.api.models.UserLanguageStructureModel;

@Repository
public interface UserLanguageSentenceRepo extends JpaRepository<UserLanguageSentenceModel, Long>{
	
	List<UserLanguageSentenceModel> findByLevelAndLanguage(String level, String language);


}