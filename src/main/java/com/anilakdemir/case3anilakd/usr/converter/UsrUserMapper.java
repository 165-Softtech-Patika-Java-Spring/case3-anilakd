package com.anilakdemir.case3anilakd.usr.converter;

import com.anilakdemir.case3anilakd.usr.dto.UsrUserDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserSaveRequestDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserUpdateRequestDto;
import com.anilakdemir.case3anilakd.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList);

    UsrUserDto convertToUsrUserDto(UsrUser usrUser);

    UsrUser convertToUsrUser(UsrUserSaveRequestDto usrUserSaveRequestDto);

    UsrUser convertToUsrUser(UsrUserUpdateRequestDto usrUserUpdateRequestDto);
}
