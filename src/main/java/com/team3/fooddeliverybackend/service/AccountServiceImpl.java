package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.repository.AccountRepository;
import com.team3.fooddeliverybackend.repository.AddressRepository;
import com.team3.fooddeliverybackend.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;
    private final CreditCardRepository creditCardRepository;


    @Override
    public Account findByEmail(final String email) {
        return accountRepository.findByEmail(email);
    }

//    @Override
//    public void addCreditCards(Account account, CreditCard creditCard) {
//        creditCardRepository.findById(id).get();
//        accountRepository.addCreditCards(account, creditCardRepository.findById(creditCard.getId()).get());
//        logger.info("CreditCard {} added to Account {}", creditCard, account);
//    }
//
//    @Override
//    public void removeCreditCards(Account account, Long id) {
//
//        accountRepository.removeCreditCards(creditCard, account);
//        logger.info("CreditCard {} removed from Account {}", creditCard, account);
//    }
//
//    @Override
//    public void addAddresses(Account account, Long id) {
//        accountRepository.addAddresses(account, address.getId());
//        logger.info("Address {} added to Account {}", address, account);
//    }
//
//
//    @Override
//    public void removeAddresses(Account account, Long id) {
//        accountRepository.removeAddresses(account, address);
//        logger.info("Address {} removed from Account {}", address, account);
//    }


    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }
}
