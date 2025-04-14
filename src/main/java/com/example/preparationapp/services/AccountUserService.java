package com.example.preparationapp.services;

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
}
