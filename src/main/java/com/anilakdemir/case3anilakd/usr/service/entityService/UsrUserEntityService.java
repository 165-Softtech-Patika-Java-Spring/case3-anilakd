package com.anilakdemir.case3anilakd.usr.service.entityService;


import com.anilakdemir.case3anilakd.gen.service.BaseEntityService;
import com.anilakdemir.case3anilakd.usr.dao.UsrUserDao;
import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author anilakdemir
 */
@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {

    public UsrUserEntityService (UsrUserDao dao) {
        super(dao);
    }

    public List<UsrUser> findAll () {
        return getDao().findAll();
    }

    public Optional<UsrUser> findById(Long id){
        return getDao().findById(id);
    }
}
