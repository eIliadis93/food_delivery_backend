package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByEmail(String email);


//    void addCreditCards(Account account, Long id);
//
//    void removeCreditCards(Account account, Long id);
//
//    void addAddresses(Account account, Long id);
//
//    void removeAddresses(Account account, Long id);
}
