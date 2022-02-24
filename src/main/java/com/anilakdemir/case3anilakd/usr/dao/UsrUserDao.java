package com.anilakdemir.case3anilakd.usr.dao;

import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author anilakdemir
 */
@Repository
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {

    Optional<UsrUser> findByUsername (String username);

    boolean existsByUsernameAndPhoneNumber(String username, String phoneNumber);

    void deleteByUsernameAndPhoneNumber(String username, String phoneNumber);

    boolean existsById(Long id);
}
