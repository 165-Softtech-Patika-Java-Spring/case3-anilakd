package com.anilakdemir.case3anilakd.cmt.entity;

import com.anilakdemir.case3anilakd.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "CMT_COMMENT")
@Data
public class CmtComment extends BaseEntity {

    @Id
    @SequenceGenerator(name = "CmtComment", sequenceName = "CMT_COMMENT_ID_SEQ")
    @GeneratedValue(generator = "CmtComment")
    private Long id;

    @Column(name = "CONTENT", length = 150, nullable = false)
    private String content;

    @Column(name = "ID_PRODUCT")
    private Long productId;

    @Column(name = "ID_USER")
    private Long userId;
}
