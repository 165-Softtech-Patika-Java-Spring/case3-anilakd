package com.anilakdemir.case3anilakd.usr.controller;

import com.anilakdemir.case3anilakd.usr.dto.UsrUserDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserSaveRequestDto;
import com.anilakdemir.case3anilakd.usr.dto.UsrUserUpdateRequestDto;
import com.anilakdemir.case3anilakd.usr.service.UsrUserService;
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

    @PostMapping
    public ResponseEntity save(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){
        UsrUserDto usrUserDto = usrUserService.saveWithControl(usrUserSaveRequestDto);
        return ResponseEntity.ok(usrUserDto);
    }

    @GetMapping()
    public ResponseEntity getAll(){
        List<UsrUserDto> usrUserDtoList = usrUserService.findAll();
        return ResponseEntity.ok(usrUserDtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        UsrUserDto usrUserDto = usrUserService.findById(id);
        return ResponseEntity.ok(usrUserDto);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getByUsername(@PathVariable String username){
        UsrUserDto usrUserDto = usrUserService.findByUsername(username);
        return ResponseEntity.ok(usrUserDto);
    }

    @DeleteMapping()
    public ResponseEntity deleteByUsernameAndPhoneNumber(@RequestParam String username, @RequestParam String phoneNumber){
        usrUserService.deleteByUsernameAndPhoneNumber(username, phoneNumber);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping
    public ResponseEntity updateUsrUser(@RequestBody UsrUserUpdateRequestDto usrUserUpdateRequestDto){
        UsrUserDto usrUserDto = usrUserService.updateWithControl(usrUserUpdateRequestDto);
        return ResponseEntity.ok(usrUserDto);
    }

}
