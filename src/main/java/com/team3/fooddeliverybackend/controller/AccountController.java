package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.service.AccountService;
import com.team3.fooddeliverybackend.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("account")
public class AccountController extends BaseController<Account> {
    private final AccountService accountService;

    @Override
    protected BaseService<Account> getBaseService() {
        return accountService;
    }

    @GetMapping(params = "email")
    public ResponseEntity<Account> findByEmail(@RequestParam String email) {
        final Account byEmail = accountService.findByEmail(email);
        if (byEmail == null) {
            throw new NoSuchElementException("Element not found");
        }
        return ResponseEntity.ok(byEmail);
    }

    @PostMapping("{creditCard}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCreditCard(@RequestBody @PathVariable @Valid CreditCard creditCard, Account  account){accountService.addCreditCard(creditCard, account);}

    @DeleteMapping("{creditCard}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCreditCard(@PathVariable CreditCard creditCard, Account account){accountService.removeCreditCard(creditCard,account);}

    @PostMapping("{address}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(Account account,@RequestBody @PathVariable @Valid Address address){accountService.addAddress(account,address);}

    @PutMapping("{address}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAddress(Account account,@Valid @RequestBody @PathVariable Address address){accountService.updateAddress(account,address);}

    @DeleteMapping("{address}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAddress(Account account,@PathVariable Address address){accountService.removeAddress(account,address);}

}
