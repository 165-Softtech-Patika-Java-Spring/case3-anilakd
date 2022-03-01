package com.anilakdemir.case3anilakd.cmt.dto;

import lombok.Data;

/**
 * @author anilakdemir
 */
@Data
public class CmtCommentSaveRequestDto {

    private String content;

    private Long productId;

    private Long userId;
}
