package com.bitswilp.langLearn.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bitswilp.langLearn.api.dto.UserLanguageDto;
import com.bitswilp.langLearn.api.models.UserLanguageModel;
import com.bitswilp.langLearn.api.models.UserLanguageQuizModel;
import com.bitswilp.langLearn.api.models.UserLanguageSentenceModel;
import com.bitswilp.langLearn.api.models.UserLanguageStructureModel;
import com.bitswilp.langLearn.api.models.UserLanguageYoutubeLinkModel;



public interface UserLanguageService {
	
	List<UserLanguageModel> getAllLanguages();
	List<UserLanguageQuizModel> getAllLanguageQuiz();
	List<UserLanguageStructureModel> getAllLanguageStructure();
	List<UserLanguageYoutubeLinkModel> getAllYoutubeLink();
	
	List<UserLanguageStructureModel> findByLevelAndLanguages(String level, String language);
	List<UserLanguageYoutubeLinkModel> findYoutubeByLevelAndLanguages(String level, String language);
	List<UserLanguageQuizModel> findQuizByLevelAndLanguages(String level, String language);
	List<UserLanguageSentenceModel> findSentenceByLevelAndLanguages(String level, String language);
	

}
