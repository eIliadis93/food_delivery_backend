package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;


public interface AccountService extends BaseService<Account>{
    Account findByEmail(String email);

    void addCreditCard(Account account, CreditCard creditCard);

    void updateCreditCard(Account account, CreditCard creditCard);

    void removeCreditCard(Account account, CreditCard creditCard);

}
