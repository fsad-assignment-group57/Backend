package com.bitswilp.langLearn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitswilp.langLearn.api.models.UserLanguageStructureModel;
import com.bitswilp.langLearn.api.models.UserLanguageYoutubeLinkModel;



public interface UserLanguageYoutubeLinkModelRepo extends JpaRepository<UserLanguageYoutubeLinkModel,Long>{
	
	List<UserLanguageYoutubeLinkModel> findByLevelAndLanguage(String level, String language);


}
