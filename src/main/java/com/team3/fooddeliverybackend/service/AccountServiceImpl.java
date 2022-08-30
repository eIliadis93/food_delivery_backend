package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addCreditCard(Account account, CreditCard creditCard) {
        account.getCreditCard().add(creditCard);
        logger.info("CreditCard {} has been added into Account {}.",creditCard,account);
    }

    @Override
    public void updateCreditCard(Account account, CreditCard creditCard) {

    }

    @Override
    public void removeCreditCard(Account account, CreditCard creditCard) {
        account.getCreditCard().removeIf(cc -> cc.getAccount().getCreditCard().equals(creditCard.getCardNumber()));
        logger.info("CreditCard {} has been removed from Account {}.", creditCard, account);
    }

    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }
}
