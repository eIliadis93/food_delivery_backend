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
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public Account findByEmail(final String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public void addAddress(Account account, Address address) {
        account.getAddresses().add(address);
        accountRepository.save(account);
        logger.info("Address added to Account {}",account);
    }

    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }


    @Override
    public void removeAddress(Account account, Long id) {
        account.getAddresses().removeIf(ad -> ad.getId().equals(id));
        accountRepository.save(account);
        logger.info("Address with id {} removed from Account {}", id, account);
    }

    @Override
    public void addCard(Account account, CreditCard creditCard) {
        account.getCreditCards().add(creditCard);
        accountRepository.save(account);
        logger.info("Credit card added to Account {}",account);
    }

    @Override
    public void removeCard(Account account, Long id) {
        account.getCreditCards().removeIf(cr -> cr.getId().equals(id));
        accountRepository.save(account);
        logger.info("Card with id {} removed from Account {}", id, account);
    }

    @Override
    public Address findAddress(Long id) {
        return accountRepository.findAddress(id);
    }
}
