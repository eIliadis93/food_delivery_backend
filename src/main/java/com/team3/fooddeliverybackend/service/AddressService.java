package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;

import java.util.List;


public interface AddressService extends BaseService<Address> {

    List<Address> findAddressByAccount(Account account);
}
