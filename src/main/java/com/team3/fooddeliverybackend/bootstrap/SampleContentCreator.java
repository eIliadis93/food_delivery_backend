package com.team3.fooddeliverybackend.bootstrap;

import com.team3.fooddeliverybackend.base.BaseComponent;
import com.team3.fooddeliverybackend.domain.*;
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

        Account account1 = Account.builder().firstname("Vagelis").lastname("Iliadis").age(29).email("e.iliadis@pmmretail.com").password("84848A484frf").build();
        logger.info("Created account {}.", account1);
        Account account2 = Account.builder().firstname("Spiros").lastname("Christodoulou").age(30).email("s.christodoulou@pmmretail.com").password("495849853grhgue").build();
        logger.info("Created account {}.", account2);
        Account account3 = Account.builder().firstname("Vagelis").lastname("Vrailas").age(22).email("e.vrailas@pmmretail.com").password("66818gfb8b9").build();
        logger.info("Created account {}.", account3);
        Account account4 = Account.builder().firstname("John").lastname("Boom").age(65).email("j.boom@pmmretail.com").password("84848A48fww4gb4frf").build();
        logger.info("Created account {}.", account4);
        Account account5 = Account.builder().firstname("Linda").lastname("Twist").age(29).email("l.twist@pmmretail.com").password("84848A484fr==dg4f").build();
        logger.info("Created account {}.", account5);
        Account account6 = Account.builder().firstname("Tom").lastname("Hanks").age(65).email("t.hanks@pmmretail.com").password("84fjie3424!848A484frf").build();
        logger.info("Created account {}.", account6);
        Account account7 = Account.builder().firstname("Tobias").lastname("Jenkins").age(34).email("t.jenkins@pmmretail.com").password("!@#$84848A484frf").build();
        logger.info("Created account {}.", account7);
        Account account8 = Account.builder().firstname("Luna").lastname("Moon").age(80).email("l.moon@pmmretail.com").password("lunamoon84848A484frf").build();
        logger.info("Created account {}.", account8);
        Account account9 = Account.builder().firstname("Erebos").lastname("Black").age(46).email("e.black@pmmretail.com").password("ereboskgnf84848A484frf").build();
        logger.info("Created account {}.", account9);
        Account account10 = Account.builder().firstname("Grey").lastname("Smith").age(18).email("g.smith@pmmretail.com").password("848fttg!*48A484frf").build();
        logger.info("Created account {}.", account10);

        Address address1 = Address.builder().streetName("Athens").account(account1).streetNumber(78).town("Attiki").build();
        logger.info("Created Address {}.", address1);
        Address address2 = Address.builder().streetName("Peristeriou").account(account2).streetNumber(15).town("Attiki").build();
        logger.info("Created Address {}.", address2);
        Address address3 = Address.builder().streetName("Agiou Ioannou").account(account3).streetNumber(32).town("Philadelfia").build();
        logger.info("Created Address {}.", address3);
        Address address4 = Address.builder().streetName("Koloktroni").account(account4).streetNumber(150).town("Petroupoli").build();
        logger.info("Created Address {}.", address4);
        Address address5 = Address.builder().streetName("Thrakis").account(account5).streetNumber(7).town("Chalandri").build();
        logger.info("Created Address {}.", address5);
        Address address6 = Address.builder().streetName("Athinon").account(account6).streetNumber(3).town("Attiki").build();
        logger.info("Created Address {}.", address6);
        Address address7 = Address.builder().streetName("Liosion").account(account7).streetNumber(1).town("Attiki").build();
        logger.info("Created Address {}.", address7);
        Address address8 = Address.builder().streetName("Thrakomakedonon").account(account8).streetNumber(65).town("Patisia").build();
        logger.info("Created Address {}.", address8);
        Address address9 = Address.builder().streetName("Agion Theodoron").account(account9).streetNumber(15).town("Attiki").build();
        logger.info("Created Address {}.", address9);
        Address address10 = Address.builder().streetName("Ermou").account(account10).streetNumber(36).town("Monastiraki").build();
        logger.info("Created Address {}.", address10);

        CreditCard creditCard1 = CreditCard.builder().cardNumber(Long.valueOf("1234567899876543")).expirationDate("5/24").holderName("Holder1").threeDigitCode(623).account(account1).build();
        logger.info("Created credit card {}.", creditCard1);
        CreditCard creditCard2 = CreditCard.builder().cardNumber(Long.valueOf("1234567852646543")).expirationDate("9/24").holderName("Holder2").threeDigitCode(123).account(account2).build();
        logger.info("Created credit card {}.", creditCard2);
        CreditCard creditCard3 = CreditCard.builder().cardNumber(Long.valueOf("9999967899876543")).expirationDate("5/24").holderName("Holder3").threeDigitCode(198).account(account3).build();
        logger.info("Created credit card {}.", creditCard3);
        CreditCard creditCard4 = CreditCard.builder().cardNumber(Long.valueOf("1234567444476543")).expirationDate("3/24").holderName("Holder4").threeDigitCode(523).account(account4).build();
        logger.info("Created credit card {}.", creditCard4);
        CreditCard creditCard5 = CreditCard.builder().cardNumber(Long.valueOf("1234333899876543")).expirationDate("2/24").holderName("Holder5").threeDigitCode(113).account(account5).build();
        logger.info("Created credit card {}.", creditCard5);
        CreditCard creditCard6 = CreditCard.builder().cardNumber(Long.valueOf("1234567111176543")).expirationDate("1/24").holderName("Holder6").threeDigitCode(053).account(account6).build();
        logger.info("Created credit card {}.", creditCard6);
        CreditCard creditCard7 = CreditCard.builder().cardNumber(Long.valueOf("1234500000006543")).expirationDate("11/24").holderName("Holder7").threeDigitCode(303).account(account7).build();
        logger.info("Created credit card {}.", creditCard7);
        CreditCard creditCard8 = CreditCard.builder().cardNumber(Long.valueOf("1234666666666643")).expirationDate("12/24").holderName("Holder8").threeDigitCode(993).account(account8).build();
        logger.info("Created credit card {}.", creditCard8);
        CreditCard creditCard9 = CreditCard.builder().cardNumber(Long.valueOf("1234544444444543")).expirationDate("10/24").holderName("Holder9").threeDigitCode(983).account(account9).build();
        logger.info("Created credit card {}.", creditCard9);
        CreditCard creditCard10 = CreditCard.builder().cardNumber(Long.valueOf("1234522222222243")).expirationDate("6/24").holderName("Holder10").threeDigitCode(723).account(account10).build();
        logger.info("Created credit card {}.", creditCard10);



    }

}
