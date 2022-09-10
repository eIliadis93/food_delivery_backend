package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;

import java.util.List;

public interface CreditCardService extends BaseService<CreditCard> {

    List<CreditCard> findCreditCardByAccount(Account account);
}
