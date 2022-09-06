package com.team3.fooddeliverybackend.bootstrap;

import com.team3.fooddeliverybackend.base.BaseComponent;
import com.team3.fooddeliverybackend.domain.*;
import com.team3.fooddeliverybackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
//@Profile("populate data")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {

    private final ProductService productService;
    private final AccountService accountService;
    private final StoreService storeService;

    private final CreditCardService creditCardService;

    private final AddressService addressService;

    @Override
    public void run(String... args) throws Exception {

        productService.createAll(Product.builder().name("Pizza Special").serial("asdasd").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Coca Cola").serial("asdasdasd").price(BigDecimal.valueOf(1.50)).productCategory(ProductCategory.DRINK).build(),
                Product.builder().name("Freddo Espresso").serial("asdasdasdasd").price(BigDecimal.valueOf(2.30)).productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Black Forest").serial("qweqwe").price(BigDecimal.valueOf(14.90)).productCategory(ProductCategory.DESERT).build(),
                Product.builder().name("Souvlaki").serial("zxczxc").price(BigDecimal.valueOf(3.50)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Xwriatikh").serial("qweasd").price(BigDecimal.valueOf(5.60)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Burger").serial("asdfqwer").price(BigDecimal.valueOf(7.90)).productCategory(ProductCategory.FOOD).build(),
                Product.builder().name("Ice Cream").serial("asdasda95d").price(BigDecimal.valueOf(2.80)).productCategory(ProductCategory.DESERT).build(),
                Product.builder().name("Margarita").serial("asdasda963d").price(BigDecimal.valueOf(8)).productCategory(ProductCategory.DRINK).build(),
                Product.builder().name("Spaghetti").serial("asdasda4521sd").price(BigDecimal.valueOf(6.30)).productCategory(ProductCategory.FOOD).build());


        Account account1 = accountService.create(Account.builder().firstname("Vagelis").lastname("Iliadis").age(29).email("e.iliadis@pmmretail.com").password("84848A484frf").build());
        Account account2 = accountService.create(Account.builder().firstname("Spiros").lastname("Christodoulou").age(30).email("s.christodoulou@pmmretail.com").password("495849853grhgue").build());
        Account account3 = accountService.create(Account.builder().firstname("Vagelis").lastname("Vrailas").age(22).email("e.vrailas@pmmretail.com").password("66818gfb8b9").build());
        Account account4 = accountService.create(Account.builder().firstname("John").lastname("Boom").age(65).email("j.boom@pmmretail.com").password("84848A48fww4gb4frf").build());
        Account account5 = accountService.create(Account.builder().firstname("Linda").lastname("Twist").age(29).email("l.twist@pmmretail.com").password("84848A484fr==dg4f").build());
        Account account6 = accountService.create(Account.builder().firstname("Tom").lastname("Hanks").age(65).email("t.hanks@pmmretail.com").password("84fjie3424!848A484frf").build());
        Account account7 = accountService.create(Account.builder().firstname("Tobias").lastname("Jenkins").age(34).email("t.jenkins@pmmretail.com").password("!@#$84848A484frf").build());
        Account account8 = accountService.create(Account.builder().firstname("Luna").lastname("Moon").age(80).email("l.moon@pmmretail.com").password("lunamoon84848A484frf").build());
        Account account9 = accountService.create(Account.builder().firstname("Erebos").lastname("Black").age(46).email("e.black@pmmretail.com").password("ereboskgnf84848A484frf").build());
        Account account10 = accountService.create(Account.builder().firstname("Grey").lastname("Smith").age(18).email("g.smith@pmmretail.com").password("848fttg!*48A484frf").build());

        storeService.create(Store.builder().email("store1@gmail.com").name("Mc Ronald's").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234567891).build());
        storeService.create(Store.builder().email("store2@gmail.com").name("Moodys").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234980891).build());
        storeService.create(Store.builder().email("store3@gmail.com").name("Soublaki").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234227891).build());
        storeService.create(Store.builder().email("store4@gmail.com").name("Pizza").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234337891).build());
        storeService.create(Store.builder().email("store5@gmail.com").name("Kebab").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234447891).build());
        storeService.create(Store.builder().email("store6@gmail.com").name("Sklavenitis").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234667891).build());
        storeService.create(Store.builder().email("store7@gmail.com").name("Creperie").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234577891).build());
        storeService.create(Store.builder().email("store8@gmail.com").name("Coffee").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234887891).build());
        storeService.create(Store.builder().email("store9@gmail.com").name("Burgertown").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234997891).build());
        storeService.create(Store.builder().email("store10@gmail.com").name("Branch").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1233367891).build());

        Address address1 = addressService.create(Address.builder().streetName("Athens").streetNumber(78).town("Attiki").build());
        logger.info("Created Address {}.", address1);
        Address address2 = addressService.create(Address.builder().streetName("Peristeriou").streetNumber(15).town("Attiki").build());
        logger.info("Created Address {}.", address2);
        Address address3 = addressService.create(Address.builder().streetName("Agiou Ioannou").streetNumber(32).town("Philadelfia").build());
        logger.info("Created Address {}.", address3);
        Address address4 = addressService.create(Address.builder().streetName("Koloktroni").streetNumber(150).town("Petroupoli").build());
        logger.info("Created Address {}.", address4);
        Address address5 = addressService.create(Address.builder().streetName("Thrakis").streetNumber(7).town("Chalandri").build());
        logger.info("Created Address {}.", address5);
        Address address6 = addressService.create(Address.builder().streetName("Athinon").streetNumber(3).town("Attiki").build());
        logger.info("Created Address {}.", address6);
        Address address7 = addressService.create(Address.builder().streetName("Liosion").streetNumber(1).town("Attiki").build());
        logger.info("Created Address {}.", address7);
        Address address8 = addressService.create(Address.builder().streetName("Thrakomakedonon").streetNumber(65).town("Patisia").build());
        logger.info("Created Address {}.", address8);
        Address address9 = addressService.create(Address.builder().streetName("Agion Theodoron").streetNumber(15).town("Attiki").build());
        logger.info("Created Address {}.", address9);
        Address address10 = addressService.create(Address.builder().streetName("Ermou").streetNumber(36).town("Monastiraki").build());
        logger.info("Created Address {}.", address10);

        CreditCard creditCard1 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234567899876543")).expirationDate("5/24").holderName("Holder1").threeDigitCode(623).build());
        logger.info("Created credit card {}.", creditCard1);
        CreditCard creditCard2 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("12368494952646543")).expirationDate("9/24").holderName("Holder2").threeDigitCode(123).build());
        logger.info("Created credit card {}.", creditCard2);
        CreditCard creditCard3 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("9999967899876543")).expirationDate("5/24").holderName("Holder3").threeDigitCode(198).build());
        logger.info("Created credit card {}.", creditCard3);
        CreditCard creditCard4 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234567444476543")).expirationDate("3/24").holderName("Holder4").threeDigitCode(523).build());
        logger.info("Created credit card {}.", creditCard4);
        CreditCard creditCard5 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234333899876543")).expirationDate("2/24").holderName("Holder5").threeDigitCode(113).build());
        logger.info("Created credit card {}.", creditCard5);
        CreditCard creditCard6 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234567111176543")).expirationDate("1/24").holderName("Holder6").threeDigitCode(053).build());
        logger.info("Created credit card {}.", creditCard6);
        CreditCard creditCard7 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234500000006543")).expirationDate("11/24").holderName("Holder7").threeDigitCode(303).build());
        logger.info("Created credit card {}.", creditCard7);
        CreditCard creditCard8 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234666666666643")).expirationDate("12/24").holderName("Holder8").threeDigitCode(993).build());
        logger.info("Created credit card {}.", creditCard8);
        CreditCard creditCard9 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234544444444543")).expirationDate("10/24").holderName("Holder9").threeDigitCode(983).build());
        logger.info("Created credit card {}.", creditCard9);
        CreditCard creditCard10 = creditCardService.create(CreditCard.builder().cardNumber(Long.valueOf("1234522222222243")).expirationDate("6/24").holderName("Holder10").threeDigitCode(723).build());
        logger.info("Created credit card {}.", creditCard10);

        accountService.addCreditCards(creditCard1, account1);

    }

}
