package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{

    private final AccountRepository accountRepository;



    @Override
    public Account findByEmail(final String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public void addCreditCard(CreditCard creditCard,Account account) {
        account.getCreditCards().add(creditCard);
        logger.info("CreditCard {} added to Account {}", creditCard, account);
    }

    @Override
    public void removeCreditCard(CreditCard creditCard, Account account) {

        account.getCreditCards().remove(creditCard);
        logger.info("CreditCard {} removed from Account {}", creditCard, account);
    }

    @Override
    public void addAddress(Account account, Address address) {
        account.getAddresses().add(address);
        logger.info("Address {} added to Account {}", address, account);
    }

    @Override
    public void updateAddress(Account account, Address address) {
        if(account.getAddresses().contains(address)) {
            account.getAddresses().removeIf(ad -> ad.getAccount().getEmail().equals(account.getEmail()));
            account.getAddresses().add(Address.builder().build());
            logger.info("Address {} updated in account {}", address, account);
        }
        logger.info("Address {} does not exist in account {}", address, account);
    }

    @Override
    public void removeAddress(Account account, Address address) {
        account.getAddresses().remove(address);
        logger.info("Address {} removed from Account {}", address, account);
    }


    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }
}
