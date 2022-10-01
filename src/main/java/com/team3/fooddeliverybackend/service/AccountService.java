package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.domain.CreditCard;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;


public interface AccountService extends BaseService<Account> {
    Account findByEmail(String email);

    void addAddress(Account account, Address address);

    void removeAddress(Account account, Long id);

    void addCard(Account account, CreditCard creditCard);

    void removeCard(Account account, Long id);

    Address findAddress(@NotNull @RequestParam Long id);
}
