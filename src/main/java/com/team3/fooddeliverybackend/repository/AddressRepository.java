package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressByAccount(Account account);
}
