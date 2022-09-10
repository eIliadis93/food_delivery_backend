package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByEmail(@NotNull String email);
}

