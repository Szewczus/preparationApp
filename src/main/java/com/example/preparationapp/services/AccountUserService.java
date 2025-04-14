package com.example.preparationapp.services;

import com.example.preparationapp.UpdatedAccountUser;
import com.example.preparationapp.entity.AccountUser;
import com.example.preparationapp.repositories.AccountUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountUserService {

    private final AccountUserRepository accountUserRepository;

    public AccountUserService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    public AccountUser getUser(Long id){
        return accountUserRepository.findById(id).orElse(null);
    }

    public AccountUser saveAccountUser(AccountUser accountUser){
        return accountUserRepository.save(accountUser);
    }

    public AccountUser updateAllAccountUserData(UpdatedAccountUser updatedAccountUser, Long id){
        AccountUser accountUser = accountUserRepository.findById(id).orElseThrow(()-> new RuntimeException("Account user not found"));
        accountUser.setEmail(updatedAccountUser.getEmail());
        accountUser.setName(updatedAccountUser.getName());
        accountUser.setSurname(updatedAccountUser.getSurname());
        return accountUserRepository.save(accountUser);
    }

    public void deleteUser(Long id){
        accountUserRepository.deleteById(id);
    }
}
