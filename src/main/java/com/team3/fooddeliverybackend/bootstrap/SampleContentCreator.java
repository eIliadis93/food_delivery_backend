package com.team3.fooddeliverybackend.bootstrap;

import com.team3.fooddeliverybackend.base.BaseComponent;
import com.team3.fooddeliverybackend.domain.Account;
import com.team3.fooddeliverybackend.domain.CreditCard;
import com.team3.fooddeliverybackend.domain.Product;
import com.team3.fooddeliverybackend.domain.ProductCategory;
import com.team3.fooddeliverybackend.service.AccountService;
import com.team3.fooddeliverybackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
//@Profile("populate data")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {

    private final ProductService productService;
    private final AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        List<Account> accounts = accountService.createAll(
                Account.builder().email("guest1@gmail.com").password("admin1234!")
                        .firstname("Joey").lastname("Tribbiani").age(30).address("Somewhere in Brooklyn").build(),
                Account.builder().email("guest2@gmail.com").password("admin1234!")
                        .firstname("Chandler").lastname("Bing").age(31).address("Somewhere in Manhattan").build(),
                Account.builder().email("guest3@gmail.com").password("admin1234!")
                        .firstname("Rachel").lastname("Green").age(31).address("Somewhere in Long Island").build(),
                Account.builder().email("guest4@gmail.com").password("admin1234!")
                        .firstname("Monika").lastname("Geller").age(31).address("Somewhere in East Hampton").build(),
                Account.builder().email("guest5@gmail.com").password("admin1234!")
                        .firstname("Ross").lastname("Geller").age(31).address("Somewhere in Queens").build()
        );
        logger.info("Created accounts {}.", accounts);

        List<Product> products = productService.createAll(
                Product.builder().name("Pizza Special").serial("asdasd").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Coca Cola").serial("asdasdasd").price(BigDecimal.valueOf(1.50)).productCategory(ProductCategory.DRINK).build(),
                Product.builder().name("Freddo Espresso").serial("asdasdasdasd").price(BigDecimal.valueOf(2.30)).productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Black Forest").serial("qweqwe").price(BigDecimal.valueOf(14.90)).productCategory(ProductCategory.DESERT).build(),
                Product.builder().name("Souvlaki").serial("zxczxc").price(BigDecimal.valueOf(3.50)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Xwriatikh").serial("qweasd").price(BigDecimal.valueOf(5.60)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Burger").serial("asdfqwer").price(BigDecimal.valueOf(7.90)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Ice Cream").serial("asdasda95d").price(BigDecimal.valueOf(2.80)).productCategory(ProductCategory.DESERT).build(),
                Product.builder().name("Margarita").serial("asdasda963d").price(BigDecimal.valueOf(8)).productCategory(ProductCategory.DRINK).build(),
                Product.builder().name("Spaghetti").serial("asdasda4521sd").price(BigDecimal.valueOf(6.30)).productCategory(ProductCategory.FOOD).build()
        );
        logger.info("Created products {}", products);

        List<CreditCard> creditCards = List.of(
                CreditCard.builder().cardNumber(Long.valueOf("1012111312141315")).holderName("J Tribbiani")
                        .expirationDate("12/12/2022").threeDigitCode(123).account(accounts.get(0)).build(),
                CreditCard.builder().cardNumber(Long.valueOf("1113121413151416")).holderName("C Bing")
                        .expirationDate("11/11/2023").threeDigitCode(234).account(accounts.get(1)).build(),
                CreditCard.builder().cardNumber(Long.valueOf("1214131514161517")).holderName("R Green")
                        .expirationDate("10/10/2024").threeDigitCode(345).account(accounts.get(2)).build(),
                CreditCard.builder().cardNumber(Long.valueOf("1315141615171618")).holderName("M Geller")
                        .expirationDate("10/11/2023").threeDigitCode(456).account(accounts.get(3)).build(),
                CreditCard.builder().cardNumber(Long.valueOf("1113121413151416")).holderName("R Bing")
                        .expirationDate("11/12/2025").threeDigitCode(567).account(accounts.get(4)).build()
        );
    }

}
