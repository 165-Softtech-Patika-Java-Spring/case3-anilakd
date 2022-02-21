package com.anilakdemir.case3anilakd.usr.service;

import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import com.anilakdemir.case3anilakd.usr.service.entityService.UsrUserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;

    public List<UsrUser> findAll(){
        return usrUserEntityService.findAll();
    }
}
