package com.anilakdemir.case3anilakd.usr.controller;

import com.anilakdemir.case3anilakd.usr.dto.UsrUserDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserSaveRequestDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserUpdateRequestDto;
import com.anilakdemir.case3anilakd.usr.service.UsrUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author anilakdemir
 */
@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
public class UsrUserController {

    private final UsrUserService usrUserService;

    @Operation(summary = "Create user")
    @PostMapping
    public ResponseEntity save (@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto) {
        UsrUserDto usrUserDto = usrUserService.saveWithControl(usrUserSaveRequestDto);
        return ResponseEntity.ok(usrUserDto);
    }

    @Operation(summary = "Get all users")
    @GetMapping()
    public ResponseEntity getAll () {
        List<UsrUserDto> usrUserDtoList = usrUserService.findAll();
        return ResponseEntity.ok(usrUserDtoList);
    }

    @Operation(summary = "Find user by id")
    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable Long id) {
        UsrUserDto usrUserDto = usrUserService.findById(id);
        return ResponseEntity.ok(usrUserDto);
    }

    @Operation(summary = "Find user by username")
    @GetMapping("/username/{username}")
    public ResponseEntity getByUsername (@PathVariable String username) {
        UsrUserDto usrUserDto = usrUserService.findByUsername(username);
        return ResponseEntity.ok(usrUserDto);
    }

    @Operation(summary = "Delete if username and phone number match")
    @DeleteMapping()
    public ResponseEntity deleteByUsernameAndPhoneNumber (@RequestParam String username, @RequestParam String phoneNumber) {
        usrUserService.deleteByUsernameAndPhoneNumber(username, phoneNumber);
        return ResponseEntity.ok(Void.TYPE);
    }

    @Operation(summary = "Update user")
    @PutMapping
    public ResponseEntity updateUsrUser (@RequestBody UsrUserUpdateRequestDto usrUserUpdateRequestDto) {
        UsrUserDto usrUserDto = usrUserService.updateWithControl(usrUserUpdateRequestDto);
        return ResponseEntity.ok(usrUserDto);
    }

}
