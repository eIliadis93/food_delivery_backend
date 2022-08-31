package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.domain.CreditCard;


public interface AccountService extends BaseService<Account>{
    Account findByEmail(String email);

    void addCreditCard(CreditCard creditCard,Account account);

    void removeCreditCard(CreditCard creditCard, Account account);

    void addAddress(Account account, Address address);

    void updateAddress(Account account, Address address);

    void removeAddress(Account account, Address address);



}
