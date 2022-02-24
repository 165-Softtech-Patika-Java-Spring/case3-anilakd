package com.anilakdemir.case3anilakd.usr.service.entityService;

import com.anilakdemir.case3anilakd.gen.service.BaseEntityService;
import com.anilakdemir.case3anilakd.usr.dao.UsrUserDao;
import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    /**
     * if there is an existing user with username, email and phoneNumber it will throw an exception
     * otherwise, it will save the usrUser
     * @param usrUser
     * @return
     */
    public UsrUser saveWithControl(UsrUser usrUser){
        try{
            return save(usrUser);
        }catch (Exception exception){
            throw new RuntimeException("Already exists");
        }
    }

    /**
     * it returns all UsrUser objects from database
     * @return List<UsrUser>
     */
    public List<UsrUser> findAll() {
        return getDao().findAll();
    }

    /**
     * it returns UsrUser by id parameter.
     * @param id
     * @return Optional<UsrUser>
     */
    public Optional<UsrUser> findById(Long id){
        return getDao().findById(id);
    }

    /**
     * it returns UsrUser by id parameter from database,
     * if there is no UsrUser it throws exception.
     * @param id
     * @return UsrUser
     */
    public UsrUser getByIdWithControl(Long id) {

        Optional<UsrUser> optionalUsrUser = findById(id);

        UsrUser usrUser;
        if (optionalUsrUser.isPresent()){
            usrUser = optionalUsrUser.get();
        }else{
            throw new RuntimeException("User not found"); //TODO: Handle exception
        }

        return usrUser;
    }

    /**
     * it returns UsrUser from database by username parameter
     * @param username
     * @return Optional<UsrUser>
     */
    public Optional<UsrUser> findByUsername(String username){
        return getDao().findByUsername(username);
    }

    /**
     * findByUsername(username) methods return Optional.
     * if Optional is null it throws exception.
     * @param username
     * @return UsrUser
     */
    public UsrUser getByUsername(String username){
        return findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));// TODO: Handle Exception
    }

    /**
     * if there is an existing user with parameters, the user will be deleted.
     * if there is no existing user the function will throw an exception.
     * @param username
     * @param phoneNumber
     */
    @Transactional
    public void deleteByUsernameAndPhoneNumber(String username, String phoneNumber){
        boolean isExist = getDao().existsByUsernameAndPhoneNumber(username, phoneNumber);

        if(isExist){
            getDao().deleteByUsernameAndPhoneNumber(username, phoneNumber);
        }else{
            throw new RuntimeException("User not found");// TODO: Handle Exception
        }
    }

    /**
     * if there is an existing user,
     * it will be updated.
     * otherwise the function will throw an exception.
     * @param usrUser
     * @return UsrUser
     */
    public UsrUser updateWithControl(UsrUser usrUser){
        Long userId = usrUser.getId();
        if(findById(userId).isPresent()){
            return saveWithControl(usrUser);
        }else{
            throw new RuntimeException("User not found");
        }
    }
}
