package com.simple.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simple.model.UserSession;

/**
 * The UserSession Repository
 * @author sriram
 * @since 25/12/2017
 */
@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, UUID> {

	@Query("select userSession from UserSession userSession where userSession.sessionToken = :token and "
			+ " userSession.userInfoId = :userInfoId and userSession.expirationDtTm > CURRENT_TIMESTAMP and "
			+ " userSession.isActive = TRUE ")
	UserSession findUserSessionByTokenAndUserInfo(@Param("token")String token, @Param("userInfoId") String userInfoId);

	List<UserSession> findByUserInfoIdAndIsActiveTrue(String userInfoId);

}
