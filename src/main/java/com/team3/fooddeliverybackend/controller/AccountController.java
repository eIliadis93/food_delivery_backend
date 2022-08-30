package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/email")
    public ResponseEntity<String> findByEmail(@RequestParam String email){
        final Account byEmail = accountService.findByEmail(email);
        if (byEmail == null){
            throw new NoSuchElementException("Element not found");
        }
        return ResponseEntity.ok().body(email);
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        if(true) {
            throw new RuntimeException("Something went wrong");
        }
        return accountService.create(account);
    }

    @PostMapping(headers = "content=list")
    public List<Account> createAll(@RequestBody List<Account> accounts) {
        return accountService.createAll(accounts);
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Account account) {
        accountService.update(account);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(accountService.get(id));
    }
}

