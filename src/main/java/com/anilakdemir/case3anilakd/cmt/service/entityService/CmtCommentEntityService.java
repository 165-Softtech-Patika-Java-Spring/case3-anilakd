package com.anilakdemir.case3anilakd.cmt.service.entityService;

import com.anilakdemir.case3anilakd.cmt.dao.CmtCommentDao;
import com.anilakdemir.case3anilakd.cmt.entity.CmtComment;
import com.anilakdemir.case3anilakd.cmt.exception.CmtCommentNotFoundException;
import com.anilakdemir.case3anilakd.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
public class CmtCommentEntityService extends BaseEntityService<CmtComment, CmtCommentDao> {

    public CmtCommentEntityService (CmtCommentDao dao) {
        super(dao);
    }

    public List<CmtComment> findAllByUserId (Long userId) {
        return getDao().findAllByUserId(userId);
    }

    public List<CmtComment> findAllByProductId (Long productId) {
        return getDao().findAllByProductId(productId);
    }

    public void deleteByIdWithControl (Long id) {
        boolean isExist = getDao().existsById(id);

        if (isExist){
            getDao().deleteById(id);
        }else{
            throw new CmtCommentNotFoundException();
        }
    }
}
