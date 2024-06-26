package com.bitswilp.langLearn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitswilp.langLearn.api.models.UserLanguageQuizModel;
import com.bitswilp.langLearn.api.models.UserLevelKey;
import com.bitswilp.langLearn.api.models.UserLevelModel;

@Repository
public interface UserLevelModelRepo extends JpaRepository<UserLevelModel, UserLevelKey>{
	
	//List<UserLevelModelRepo> findByLevelAndLanguage(String level, String language);
    @Query("SELECT u FROM UserLevelModel u WHERE u.userLevelKey.userId = :userId and u.userLevelKey.langauge = :language ORDER BY u.userLevelKey.level DESC")
    List<UserLevelModel> findByUserIdOrderByLevelDesc(String userId,String language);



}
