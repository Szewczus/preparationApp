package com.example.preparationapp.controllers;

import com.example.preparationapp.models.UpdatedAccountUser;
import com.example.preparationapp.entity.AccountUser;
import com.example.preparationapp.services.AccountUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-user")
@Slf4j
public class AccountUserController {

    private final AccountUserService accountUserService;

    public AccountUserController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountUser> getUser(@PathVariable Long id){
        AccountUser accountUser = accountUserService.getUser(id);
        if(accountUser == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(accountUser);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountUser> createUser(@RequestBody AccountUser accountUser){
        AccountUser newAccountUser = accountUserService.saveAccountUser(accountUser);
        log.info("User created");
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccountUser);
    }

    @PutMapping("/updateAllAccountUserData/{id}")
    public ResponseEntity<AccountUser> updateAllAccountUserData(@RequestBody UpdatedAccountUser accountUser, @PathVariable Long id){
        AccountUser updatedAccountUser = accountUserService.updateAllAccountUserData(accountUser, id);
        log.info("User with id: {} updated", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedAccountUser);
    }

    @PatchMapping("/updateSurname/{id}")
    public ResponseEntity<AccountUser> updateSurname(@RequestParam String surname, @PathVariable Long id){
        AccountUser accountUser = accountUserService.getUser(id);
        if(accountUser == null){
            return ResponseEntity.notFound().build();
        }
        accountUser.setSurname(surname);
        accountUserService.saveAccountUser(accountUser);
        log.info("User with id: {} updated", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        AccountUser accountUser = accountUserService.getUser(id);
        if(accountUser == null){
            return ResponseEntity.notFound().build();
        }
        accountUserService.deleteUser(id);
        log.info("User with id: {} deleted", id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
