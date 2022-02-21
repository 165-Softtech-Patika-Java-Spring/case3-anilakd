package com.anilakdemir.case3anilakd.usr.dto;

import com.anilakdemir.case3anilakd.usr.enums.UsrUserType;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anilakdemir
 */
@Data
public class UsrUserDto {

    private Long id;

    private String username;

    private String email;

    private UsrUserType userType;
}
