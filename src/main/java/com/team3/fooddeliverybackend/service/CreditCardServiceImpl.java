package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl extends BaseServiceImpl<CreditCard> implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Override
    public JpaRepository<CreditCard, Long> getRepository() {
        return creditCardRepository;
    }

    @Override
    public List<CreditCard> findCreditCardByAccount(Account account) {
        return creditCardRepository.findCreditCardByAccount(account);
    }
}
