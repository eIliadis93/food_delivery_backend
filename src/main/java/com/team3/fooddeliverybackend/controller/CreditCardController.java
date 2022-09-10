package com.team3.fooddeliverybackend.controller;

import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.service.BaseService;
import com.team3.fooddeliverybackend.service.CreditCardService;
import com.team3.fooddeliverybackend.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("creditCards")
public class CreditCardController extends BaseController<CreditCard> {

    private final CreditCardService creditCardService;

    @Override
    protected BaseService<CreditCard> getBaseService() {
        return creditCardService;
    }

    @GetMapping(params = "findByAccount")
    public ResponseEntity<ApiResponse<List<CreditCard>>> findCreditCardByAccount(@RequestParam(value = "findByAccount") Account findByAccount) {
        final List<CreditCard> byAccount = creditCardService.findCreditCardByAccount(findByAccount);
        if (byAccount == null) {
            throw new NoSuchElementException("CreditCard not found (by account)");
        }
        return ResponseEntity.ok(ApiResponse.<List<CreditCard>>builder().data(byAccount).build());
    }
}
