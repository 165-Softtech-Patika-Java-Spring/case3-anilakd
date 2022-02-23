package com.anilakdemir.case3anilakd.usr.controller;

import com.anilakdemir.case3anilakd.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anilakdemir
 */
@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
public class UsrUserController {

    private final UsrUserService usrUserService;

}
