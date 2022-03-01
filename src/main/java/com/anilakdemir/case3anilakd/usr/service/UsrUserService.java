package com.anilakdemir.case3anilakd.usr.service;

import com.anilakdemir.case3anilakd.usr.converter.UsrUserMapper;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserSaveRequestDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserUpdateRequestDto;
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

    /**
     * it converts to list which comes from usrUserEntityService to dtoList
     *
     * @return List<UsrUserDto>
     */
    public List<UsrUserDto> findAll () {
        List<UsrUser> usrUserList = usrUserEntityService.findAll();
        List<UsrUserDto> usrUserDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);
        return usrUserDtoList;
    }

    /**
     * it converts to entity which comes from usrUserEntityService to dto
     *
     * @param id
     * @return UsrUserDto
     */
    public UsrUserDto findById (Long id) {
        UsrUser usrUser = usrUserEntityService.getByIdWithControl(id);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);
        return usrUserDto;
    }

    /**
     * it converts to entity which comes from usrUserEntityService to dto
     *
     * @param username
     * @return UsrUserDto
     */
    public UsrUserDto findByUsername (String username) {
        UsrUser usrUser = usrUserEntityService.getByUsername(username);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);
        return usrUserDto;
    }

    /**
     * if request is valid, it returns the saved request
     *
     * @param usrUserSaveRequestDto
     * @return UsrUserDto
     */
    public UsrUserDto saveWithControl (UsrUserSaveRequestDto usrUserSaveRequestDto) {
        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveRequestDto);
        usrUser = usrUserEntityService.saveWithControl(usrUser);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

    /**
     * it is used to send the parameters to usrUserEntityService to delete if there is an existing user
     *
     * @param username
     * @param phoneNumber
     */
    public void deleteByUsernameAndPhoneNumber (String username, String phoneNumber) {
        usrUserEntityService.deleteByUsernameAndPhoneNumber(username, phoneNumber);
    }

    /**
     * if there is an existing user with id which is in the request, it returns the user entity to dto.
     * if there is not an existing user it throws exception.
     *
     * @param usrUserUpdateRequestDto
     * @return UsrUserDto
     */
    public UsrUserDto updateWithControl (UsrUserUpdateRequestDto usrUserUpdateRequestDto) {
        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserUpdateRequestDto);
        usrUser = usrUserEntityService.updateWithControl(usrUser);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        return usrUserDto;
    }

}
