package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;


public interface AccountService extends BaseService<Account> {
    Account findByEmail(String email);

//    void addCreditCards(Account account, Long id);
//
//    void removeCreditCards(Account account, Long id);
//
//    void addAddresses(Account account, Long id);
//
//    void removeAddresses(Account account, Long id);


}
