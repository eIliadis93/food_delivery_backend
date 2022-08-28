package com.team3.fooddeliverybackend.repository;

import com.team3.fooddeliverybackend.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
