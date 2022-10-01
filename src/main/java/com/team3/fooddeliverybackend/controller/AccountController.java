package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Address;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.service.AccountService;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
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

    @PostMapping("addAddress")
    public ResponseEntity<ApiResponse<Account>> addAddress(@RequestBody Address address, @RequestParam Long id){
        final Account account = accountService.get(id);
        accountService.addAddress(account ,address);
        return ResponseEntity.ok(ApiResponse.<Account>builder().data(account).build());
    }
    @DeleteMapping("/{id}/removeAddress")
    public  ResponseEntity<ApiResponse<Account>> removeAddress(@RequestParam Long addId, @PathVariable Long id){
        final Account account = accountService.get(id);
        accountService.removeAddress(account, addId);
        return ResponseEntity.ok(ApiResponse.<Account>builder().data(account).build());
    }

    @PostMapping("addCard")
    public ResponseEntity<ApiResponse<Account>> addCard(@RequestBody CreditCard creditCard, @RequestParam Long id){
        final Account account = accountService.get(id);
        accountService.addCard(account ,creditCard);
        return ResponseEntity.ok(ApiResponse.<Account>builder().data(account).build());
    }
    @DeleteMapping("/{id}/removeCard")
    public  ResponseEntity<ApiResponse<Account>> removeCard(@RequestParam Long cardId, @PathVariable Long id){
        final Account account = accountService.get(id);
        accountService.removeCard(account, cardId);
        return ResponseEntity.ok(ApiResponse.<Account>builder().data(account).build());
    }
}
