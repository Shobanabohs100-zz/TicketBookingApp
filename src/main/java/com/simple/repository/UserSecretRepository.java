package com.simple.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.model.UserSecret;

/**
 * The UserSecret Repository
 * @author sriram
 * @since 25/12/2017
 */
@Repository
public interface UserSecretRepository extends JpaRepository<UserSecret, UUID> {

	UserSecret findByUserInfoIdAndIsActiveTrue(String userInfoId);

}
