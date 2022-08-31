package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
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
    public void addCreditCard(CreditCard credit,Account account) {
        boolean isAlready=false;
        if(credit==null){
            return;
        }
        for( CreditCard creditCard:account.getCreditCard()){
            if(creditCard.equals(credit)){
                isAlready=true;
                break;
            }
        }
        if(!isAlready){
            account.getCreditCard().add(credit);
        }


    }

    @Override
    public void updateCreditCard(CreditCard creditCard) {

    }

    @Override
    public void removeCreditCard(CreditCard creditCard) {

    }


    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }
}
