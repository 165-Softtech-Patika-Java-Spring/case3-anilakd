package com.anilakdemir.case3anilakd.prd.dao;

import com.anilakdemir.case3anilakd.prd.entity.PrdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anilakdemir
 */
@Repository
public interface PrdProductDao extends JpaRepository<PrdProduct, Long> {
}
