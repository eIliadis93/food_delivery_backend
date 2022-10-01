package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.QueryHint;
import javax.validation.constraints.NotNull;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByEmail(@NotNull String email);

    @Query(value = "select new Address(a.streetName,a.streetNumber,a.town) from Address a where a.id = :id")
    Address findAddress(@NotNull @RequestParam Long id);
}

