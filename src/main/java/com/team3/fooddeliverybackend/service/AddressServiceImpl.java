package com.team3.fooddeliverybackend.service;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    @Transactional
    public List<Address> findAddressByAccount(Account account) {
        return addressRepository.findAddressByAccount(account);
    }
}
