package com.bitswilp.langLearn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitswilp.langLearn.api.models.UserLanguageStructureModel;



@Repository
public interface UserLanguageStructureRepo extends JpaRepository<UserLanguageStructureModel, Long>{
	
	List<UserLanguageStructureModel> findByLevelAndLanguages(String level, String language);


}
