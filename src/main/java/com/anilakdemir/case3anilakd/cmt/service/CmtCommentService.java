package com.anilakdemir.case3anilakd.cmt.service;

import com.anilakdemir.case3anilakd.cmt.converter.CmtCommentMapper;
import com.anilakdemir.case3anilakd.cmt.dto.CmtCommentDto;
import com.anilakdemir.case3anilakd.cmt.dto.CmtCommentSaveRequestDto;
import com.anilakdemir.case3anilakd.cmt.entity.CmtComment;
import com.anilakdemir.case3anilakd.cmt.exception.NoCmtCommentAboutPrdProductException;
import com.anilakdemir.case3anilakd.cmt.exception.NoCmtCommentByUsrUserException;
import com.anilakdemir.case3anilakd.cmt.service.entityService.CmtCommentEntityService;
import com.anilakdemir.case3anilakd.prd.entity.PrdProduct;
import com.anilakdemir.case3anilakd.prd.service.entityService.PrdProductEntityService;
import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import com.anilakdemir.case3anilakd.usr.service.entityService.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class CmtCommentService {

    private final CmtCommentEntityService cmtCommentEntityService;
    private final UsrUserEntityService usrUserEntityService;
    private final PrdProductEntityService prdProductEntityService;

    public CmtCommentDto saveWithControl (CmtCommentSaveRequestDto cmtCommentSaveRequestDto) {
        boolean isValidRequest = isValidSaveRequest(cmtCommentSaveRequestDto);

        if (!isValidRequest){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not valid request");
        }

        CmtComment cmtComment = CmtCommentMapper.INSTANCE.convertToCmtComment(cmtCommentSaveRequestDto);
        cmtComment = cmtCommentEntityService.save(cmtComment);
        CmtCommentDto cmtCommentDto = CmtCommentMapper.INSTANCE.convertToCmtComment(cmtComment);
        return cmtCommentDto;
    }

    public List<CmtCommentDto> findAllByUserId (Long userId) {
        UsrUser usrUser = usrUserEntityService.getByIdWithControl(userId);
        List<CmtComment> cmtCommentList = cmtCommentEntityService.findAllByUserId(userId);

        if (cmtCommentList.isEmpty()){
            String username = usrUser.getUsername();
            throw new NoCmtCommentByUsrUserException(String.format("%s did not comment yet",username));
        }

        List<CmtCommentDto> cmtCommentDtoList = CmtCommentMapper.INSTANCE.convertToCmtCommentDtoList(cmtCommentList);
        return cmtCommentDtoList;
    }

    public List<CmtCommentDto> findAllByProductId (Long productId) {
        PrdProduct product = prdProductEntityService.getByIdWithControl(productId);
        List<CmtComment> cmtCommentList = cmtCommentEntityService.findAllByProductId(productId);

        if (cmtCommentList.isEmpty()){
            String productName = product.getName();
            throw new NoCmtCommentAboutPrdProductException(String.format("There are no comments about the %s", productName));
        }

        List<CmtCommentDto> cmtCommentDtoList = CmtCommentMapper.INSTANCE.convertToCmtCommentDtoList(cmtCommentList);
        return cmtCommentDtoList;
    }


    public void deleteByIdWithControl (Long id) {
        cmtCommentEntityService.deleteByIdWithControl(id);
    }

    private boolean isValidSaveRequest (CmtCommentSaveRequestDto cmtCommentSaveRequestDto) {
        Long userId = cmtCommentSaveRequestDto.getUserId();
        Long productId = cmtCommentSaveRequestDto.getProductId();
        boolean isExistUser = usrUserEntityService.existById(userId);
        boolean isExistProduct = prdProductEntityService.existById(productId);

        boolean isValidRequest = isExistProduct && isExistUser;

        return isValidRequest;
    }
}
