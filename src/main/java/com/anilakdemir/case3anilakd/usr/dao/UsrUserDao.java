package com.anilakdemir.case3anilakd.usr.dao;

import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anilakdemir
 */
@Repository
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {
}
