package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;


public interface AccountService extends BaseService<Account>{
    Account findByEmail(String email);

    void addCreditCard(CreditCard creditCard,Account account);

    void updateCreditCard(CreditCard creditCard);

    void removeCreditCard(CreditCard creditCard);

}
