package com.anilakdemir.case3anilakd.cmt.converter;

import com.anilakdemir.case3anilakd.cmt.dto.CmtCommentDto;
import com.anilakdemir.case3anilakd.cmt.dto.CmtCommentSaveRequestDto;
import com.anilakdemir.case3anilakd.cmt.entity.CmtComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CmtCommentMapper {

    CmtCommentMapper INSTANCE = Mappers.getMapper(CmtCommentMapper.class);

    CmtComment convertToCmtComment (CmtCommentSaveRequestDto cmtCommentSaveRequestDto);

    CmtCommentDto convertToCmtComment (CmtComment cmtComment);

    List<CmtCommentDto> convertToCmtCommentDtoList (List<CmtComment> cmtCommentList);
}
