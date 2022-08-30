package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import org.springframework.stereotype.Service;


@Service
public interface AccountService extends BaseService<Account>{

    Account findByEmail(String email);
}
