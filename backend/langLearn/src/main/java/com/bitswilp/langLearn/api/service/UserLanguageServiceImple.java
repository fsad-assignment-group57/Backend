package com.bitswilp.langLearn.api.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitswilp.langLearn.api.dto.UserLevel;
import com.bitswilp.langLearn.api.models.UserLanguageModel;
import com.bitswilp.langLearn.api.models.UserLanguageQuizModel;
import com.bitswilp.langLearn.api.models.UserLanguageSentenceModel;
import com.bitswilp.langLearn.api.models.UserLanguageStructureModel;
import com.bitswilp.langLearn.api.models.UserLanguageYoutubeLinkModel;
import com.bitswilp.langLearn.api.models.UserLevelKey;
import com.bitswilp.langLearn.api.models.UserLevelModel;
import com.bitswilp.langLearn.api.repository.UserLanguageQuizRepository;
import com.bitswilp.langLearn.api.repository.UserLanguageRepository;
import com.bitswilp.langLearn.api.repository.UserLanguageSentenceRepo;
import com.bitswilp.langLearn.api.repository.UserLanguageStructureRepo;
import com.bitswilp.langLearn.api.repository.UserLanguageYoutubeLinkModelRepo;
import com.bitswilp.langLearn.api.repository.UserLevelModelRepo;

@Service
public class UserLanguageServiceImple implements UserLanguageService {

	@Autowired
	private UserLanguageRepository userLangRepo;

	@Autowired
	private UserLanguageQuizRepository langquizrepo;

	@Autowired
	private UserLanguageStructureRepo langstrurepo;

	@Autowired
	private UserLanguageYoutubeLinkModelRepo youtubeRepo;
	
	@Autowired
	private UserLanguageSentenceRepo langsetnenceRepo;
	
	@Autowired
	private UserLevelModelRepo userLevelModelRepo;

	@Override
	public List<UserLanguageModel> getAllLanguages() {
		List<UserLanguageModel> langs = userLangRepo.findAll();
		return langs.stream().map((lan) -> mapToLang(lan)).collect(Collectors.toList());
	}

	private UserLanguageModel mapToLang(UserLanguageModel langMod) {
		UserLanguageModel langsMod = new UserLanguageModel();
		langsMod.setLanguages(langMod.getLanguages());
		return langsMod;

	}

	@Override
	public List<UserLanguageQuizModel> getAllLanguageQuiz() {
		List<UserLanguageQuizModel> langQuiz = langquizrepo.findAll();

		return langQuiz.stream().map(this::mapToLangs).collect(Collectors.toList());
	}

	private UserLanguageQuizModel mapToLangs(UserLanguageQuizModel langquizMod) {
		UserLanguageQuizModel langs_quiz_Mod = new UserLanguageQuizModel();
		langs_quiz_Mod.setLevel(langquizMod.getLevel());
		langs_quiz_Mod.setLanguage(langquizMod.getLanguage());
		langs_quiz_Mod.setQuestion(langquizMod.getQuestion());
		langs_quiz_Mod.setOptions(langquizMod.getOptions());
		langs_quiz_Mod.setAnswer(langquizMod.getAnswer());
		return langquizMod;

	}

	@Override
	public List<UserLanguageStructureModel> getAllLanguageStructure() {
		List<UserLanguageStructureModel> langStru = langstrurepo.findAll();

		return langStru.stream().map((l) -> mapToLangs(l)).collect(Collectors.toList());
	}

	private UserLanguageStructureModel mapToLangs(UserLanguageStructureModel langstruMod) {
		UserLanguageStructureModel langs_stru_Mod = new UserLanguageStructureModel();
		langs_stru_Mod.setLanguages(langstruMod.getLanguages());
		langs_stru_Mod.setLevel(langstruMod.getLevel());
		langs_stru_Mod.setEnglish_word(langstruMod.getEnglish_word());
		langs_stru_Mod.setLanguage_word(langstruMod.getLanguage_word());
		langs_stru_Mod.setWord_spell_in_english(langstruMod.getWord_spell_in_english());
		return langstruMod;

	}

	@Override
	public List<UserLanguageYoutubeLinkModel> getAllYoutubeLink() {
		List<UserLanguageYoutubeLinkModel> youtubeLin = youtubeRepo.findAll();

		return youtubeLin.stream().map((l) -> mapToLangs1(l)).collect(Collectors.toList());
	}

	private UserLanguageYoutubeLinkModel mapToLangs1(UserLanguageYoutubeLinkModel youtubeLink) {
		UserLanguageYoutubeLinkModel youtube_Link = new UserLanguageYoutubeLinkModel();
		youtube_Link.setLevel(youtubeLink.getLevel());
		youtube_Link.setLanguage(youtubeLink.getLanguage());
		youtube_Link.setLink_youtube_word(youtubeLink.getLink_youtube_word());

		return youtubeLink;

	}

	@Override
	public List<UserLanguageStructureModel> findByLevelAndLanguages(String level, String langauge){
		// TODO Auto-generated method stub
		
		return langstrurepo.findByLevelAndLanguages(level,langauge);
	}
	
	@Override
	public List<UserLanguageYoutubeLinkModel> findYoutubeByLevelAndLanguages(String level, String langauge){
		// TODO Auto-generated method stub
		
		return youtubeRepo.findByLevelAndLanguage(level,langauge);
	}
	
	@Override
	public List<UserLanguageQuizModel> findQuizByLevelAndLanguages(String level, String langauge) {
		return langquizrepo.findByLevelAndLanguage(level,langauge);
	}
	
	@Override
	public List<UserLanguageSentenceModel> findSentenceByLevelAndLanguages(String level, String language){
		return langsetnenceRepo.findByLevelAndLanguage(level,language);
	}

	@Override
	public List<UserLevelModel> postUserLevelDetails(String username, String level, String language) {
		
		UserLevelKey userLevelKey = new UserLevelKey();
		userLevelKey.setLangauge(language);
		userLevelKey.setLevel(level);
		userLevelKey.setUserId(username);
		
		UserLevelModel userLevelModel = new UserLevelModel();
		userLevelModel.setUserLevelKey(userLevelKey);
				
		int points = Integer.parseInt(level)*5;
		
		userLevelModel.setPoints(points);
		
		userLevelModelRepo.save(userLevelModel);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserLevel> getAllPoints() {
		// TODO Auto-generated method stub
		List<UserLevelModel> userLevelModel = userLevelModelRepo.findAll();
		
		Map<String,Long> userPoints = new HashMap<>();
		for(UserLevelModel userIterator : userLevelModel) {
			String userId = userIterator.getUserLevelKey().getUserId();
			userPoints.put(userId, userPoints.getOrDefault(userId, (long) 0) + userIterator.getPoints());
		}
		
		List<UserLevel> userLevel = new  ArrayList<>();
		
		for(Map.Entry<String,Long> entry : userPoints.entrySet()) {
			UserLevel userLevelPoints = new UserLevel();
			userLevelPoints.setUserId(entry.getKey());
			userLevelPoints.setPoints(entry.getValue());
			userLevel.add(userLevelPoints);
		}
			
		
		return userLevel;
	}
	
	@Override
	public Long getLevelFromUser(String userId,String language) {

		 List<UserLevelModel> levels = userLevelModelRepo.findByUserIdOrderByLevelDesc(userId,language);
		 
		 if (levels.isEmpty()) {
	            return 0l; // or throw an exception if needed
	        }

	        return Long.parseLong(levels.get(0).getUserLevelKey().getLevel());


	}
	
	

	
	
}
