package com.team3.fooddeliverybackend.bootstrap;

import com.team3.fooddeliverybackend.base.BaseComponent;
import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.ProductCategory;
import com.team3.fooddeliverybackend.service.AccountService;
import com.team3.fooddeliverybackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("populate data")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent {

    private final ProductService productService;
    private final AccountService accountService;

    List<Account> accounts = List.of(
      Account.builder().email("guest1@gmail.com").password("admin1234!")
              .firstname("Joey").lastname("Tribbiani").age(30).address("Somewhere in Bruklin").build(),
      Account.builder().email("guest2@gmail.com").password("admin1234!")
              .firstname("Chandler").lastname("Bing").age(31).address("Somewhere in NY").build()
    );

    List<Product> products = List.of(
      Product.builder().name("Pizza Special").serial("asdasd").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).build(),
      Product.builder().name("Coca Cola").serial("asdasdasd").price(BigDecimal.valueOf(1.50)).productCategory(ProductCategory.DRINK).build()
    );
}
