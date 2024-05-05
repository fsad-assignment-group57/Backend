package com.bitswilp.langLearn.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitswilp.langLearn.api.models.UserLanguageModel;
import com.bitswilp.langLearn.api.models.UserLanguageQuizModel;
import com.bitswilp.langLearn.api.models.UserLanguageSentenceModel;
import com.bitswilp.langLearn.api.models.UserLanguageStructureModel;
import com.bitswilp.langLearn.api.models.UserLanguageYoutubeLinkModel;
import com.bitswilp.langLearn.api.repository.UserLanguageRepository;
import com.bitswilp.langLearn.api.service.UserLanguageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name="userlanguagecontroller",description = "to perform operations on language")
public class UserLanguageController {
	
	@Autowired
	private UserLanguageRepository userLangRepo;
	
	@Autowired
	private UserLanguageService userLangSer;
	
	
	
	 @Operation( 
			 summary = "GET Operation on languages", 
			 description ="to fetch details of languages from database" 
			 )
	 
	@GetMapping("languages")
	public ResponseEntity<List<UserLanguageModel>> getAllLanguages(){
	    List<UserLanguageModel> langg = userLangSer.getAllLanguages();
        return ResponseEntity.ok(langg);

}



	 @Operation( summary = "GET Operation on quiz related to languages",
			  description = "to fetch quiz details of languages from database" )
 
 
	@GetMapping("/languages_quiz/{level}/{language}")
	public ResponseEntity<List<UserLanguageQuizModel>> getAllLanguageQuiz(@PathVariable String level,@PathVariable String language){
	    List<UserLanguageQuizModel> lang_quiz = userLangSer.findQuizByLevelAndLanguages(level,language);
        return ResponseEntity.ok(lang_quiz);

}


 @Operation( summary = "GET Operation on structure of languages", description
= "to fetch structure details of languages from database" )

	@GetMapping("/languages_structure/{level}/{language}")
	public ResponseEntity<List<UserLanguageStructureModel>> getAllLanguageStructure(@PathVariable String level,@PathVariable String language){
	 System.out.println("level"+level+"language"+language);   
	 List<UserLanguageStructureModel> lang_stru = userLangSer.findByLevelAndLanguages(level,language);
        return ResponseEntity.ok(lang_stru);

	}
	
	
	
	 @Operation( summary = "GET Operation on youtube links of languages",
	 description = "to fetch youtube link details of languages from database" )
	
	 
	@GetMapping("/youtubeLink/{level}/{language}")
	public ResponseEntity<List<UserLanguageYoutubeLinkModel>> getAllYoutubeLink(@PathVariable String level,@PathVariable String language){
		List<UserLanguageYoutubeLinkModel> youtube_link = userLangSer.findYoutubeByLevelAndLanguages( level, language);
		return ResponseEntity.ok(youtube_link);
	}
	 
	 
		
	 @Operation( summary = "GET Operation on youtube links of languages",
	 description = "to fetch youtube link details of languages from database" )
	
	 
	@GetMapping("/sentence/{level}/{language}")
	public ResponseEntity<List<UserLanguageSentenceModel>> getAllSetence(@PathVariable String level,@PathVariable String language){
		List<UserLanguageSentenceModel> sentence_link = userLangSer.findSentenceByLevelAndLanguages( level, language);
		return ResponseEntity.ok(sentence_link);
	}
	

}
