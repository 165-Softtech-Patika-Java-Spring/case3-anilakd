package com.anilakdemir.case3anilakd.cmt.dao;

import com.anilakdemir.case3anilakd.cmt.entity.CmtComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anilakdemir
 */
@Repository
public interface CmtCommentDao extends JpaRepository<CmtComment, Long> {

    List<CmtComment> findAllByUserId (Long userId);

    List<CmtComment> findAllByProductId (Long productId);
}
