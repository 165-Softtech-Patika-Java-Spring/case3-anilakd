package com.anilakdemir.case3anilakd.usr.dto;

import com.anilakdemir.case3anilakd.usr.enums.UsrUserType;
import lombok.Data;

/**
 * @author anilakdemir
 */
@Data
public class UsrUserUpdateRequestDto {

    private Long id;

    private String username;

    private String email;

    private String phoneNumber;

    private UsrUserType userType;
}
