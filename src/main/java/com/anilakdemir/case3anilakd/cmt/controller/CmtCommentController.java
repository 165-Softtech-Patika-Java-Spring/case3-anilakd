package com.anilakdemir.case3anilakd.cmt.controller;

import com.anilakdemir.case3anilakd.cmt.dto.CmtCommentDto;
import com.anilakdemir.case3anilakd.cmt.dto.CmtCommentSaveRequestDto;
import com.anilakdemir.case3anilakd.cmt.service.CmtCommentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author anilakdemir
 */
@RestController
@RequestMapping("/v1/api/comments")
@RequiredArgsConstructor
public class CmtCommentController {

    private final CmtCommentService cmtCommentService;

    @Operation(summary = "Get all comments by user id")
    @GetMapping("/user/{userId}")
    public ResponseEntity getAllByUserId (@PathVariable Long userId) {
        List<CmtCommentDto> cmtCommentDtoList = cmtCommentService.findAllByUserId(userId);
        return ResponseEntity.ok(cmtCommentDtoList);
    }

    @Operation(summary = "Get all comments by product id")
    @GetMapping("/product/{productId}")
    public ResponseEntity getAllByProductId (@PathVariable Long productId) {
        List<CmtCommentDto> cmtCommentDtoList = cmtCommentService.findAllByProductId(productId);
        return ResponseEntity.ok(cmtCommentDtoList);
    }

    @Operation(summary = "Save comment")
    @PostMapping
    public ResponseEntity save (@RequestBody CmtCommentSaveRequestDto cmtCommentSaveRequestDto) {
        CmtCommentDto cmtCommentDto = cmtCommentService.saveWithControl(cmtCommentSaveRequestDto);
        return ResponseEntity.ok(cmtCommentDto);
    }

    @Operation(summary = "Delete comment by comment id")
    @DeleteMapping
    public ResponseEntity deleteById (@RequestParam Long id) {
        cmtCommentService.deleteByIdWithControl(id);
        return ResponseEntity.ok(Void.TYPE);
    }
}