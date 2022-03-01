package com.anilakdemir.case3anilakd.usr.entity;

import com.anilakdemir.case3anilakd.gen.entity.BaseEntity;
import com.anilakdemir.case3anilakd.usr.enums.UsrUserType;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "USR_USER")
@Data
public class UsrUser extends BaseEntity {

    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 11, nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30, nullable = false)
    private UsrUserType userType;
}
