package com.team3.fooddeliverybackend.bootstrap;

import com.team3.fooddeliverybackend.base.BaseComponent;
import com.team3.fooddeliverybackend.domain.*;
import com.team3.fooddeliverybackend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Profile("test")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {

    private final ProductService productService;
    private final AccountService accountService;
    private final StoreService storeService;
    private final CreditCardService creditCardService;
    private final AddressService addressService;
    private final OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

        Store store1 = storeService.create(Store.builder().email("store1@gmail.com").name("McDonald's").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234567891).imgURL("assets/storesImg/mc.png").build());
        Store store2 = storeService.create(Store.builder().email("store2@gmail.com").name("Goodys").storeCategory(StoreCategory.GROCERY).location("Athens").phoneNumber(1234980891).imgURL("assets/storesImg/goodys.png").build());
        Store store3 = storeService.create(Store.builder().email("store3@gmail.com").name("Cook&Grill").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234227891).imgURL("assets/storesImg/cook.png").build());
        Store store4 = storeService.create(Store.builder().email("store4@gmail.com").name("Pizza Fan").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234337891).imgURL("assets/storesImg/pizzaFan.png").build());
        Store store5 = storeService.create(Store.builder().email("store5@gmail.com").name("O Proedros").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234447891).imgURL("assets/storesImg/proedros.png").build());
        Store store6 = storeService.create(Store.builder().email("store6@gmail.com").name("Sklavenitis").storeCategory(StoreCategory.GROCERY).location("Athens").phoneNumber(1234667891).imgURL("assets/storesImg/sklavenitis.png").build());
        Store store7 = storeService.create(Store.builder().email("store7@gmail.com").name("Creperie").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234577891).imgURL("assets/storesImg/crep.png").build());
        Store store8 = storeService.create(Store.builder().email("store8@gmail.com").name("Gregorys").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234887891).imgURL("assets/storesImg/gregorys.png").build());
        Store store9 = storeService.create(Store.builder().email("store9@gmail.com").name("Simply Burgers").storeCategory(StoreCategory.FOOD).location("Athens").phoneNumber(1234997891).imgURL("assets/storesImg/simply.png").build());
        Store store10 = storeService.create(Store.builder().email("store10@gmail.com").name("Branch").storeCategory(StoreCategory.GROCERY).location("Athens").phoneNumber(1233367891).imgURL("assets/storesImg/branch.png").build());


        Product product1 = productService.create(Product.builder().name("Pizza Special").serial("asdasd").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).store(store1).build());
        Product product2 = productService.create(Product.builder().name("Coca Cola").serial("asdasdasd").price(BigDecimal.valueOf(1.50)).productCategory(ProductCategory.DRINK).store(store2).build());
        Product product3 = productService.create(Product.builder().name("Freddo Espresso").serial("asdasdasdasd").price(BigDecimal.valueOf(2.30)).productCategory(ProductCategory.COFFEE).store(store3).build());
        Product product4 = productService.create(Product.builder().name("Black Forest").serial("qweqwe").price(BigDecimal.valueOf(14.90)).productCategory(ProductCategory.DESERT).store(store4).build());
        Product product5 = productService.create(Product.builder().name("Souvlaki").serial("zxczxc").price(BigDecimal.valueOf(3.50)).productCategory(ProductCategory.FOOD).store(store5).build());
        Product product6 = productService.create(Product.builder().name("Xwriatikh").serial("qweasd").price(BigDecimal.valueOf(5.60)).productCategory(ProductCategory.FOOD).store(store6).build());
        Product product7 = productService.create(Product.builder().name("Burger").serial("asdfqwer").price(BigDecimal.valueOf(7.90)).productCategory(ProductCategory.FOOD).store(store7).build());
        Product product8 = productService.create(Product.builder().name("Ice Cream").serial("asdasda95d").price(BigDecimal.valueOf(2.80)).productCategory(ProductCategory.DESERT).store(store8).build());
        Product product9 = productService.create(Product.builder().name("Margarita").serial("asdasda963d").price(BigDecimal.valueOf(8)).productCategory(ProductCategory.DRINK).store(store9).build());
        Product product10 = productService.create(Product.builder().name("Spaghetti").serial("asdasda4521sd").price(BigDecimal.valueOf(6.30)).productCategory(ProductCategory.FOOD).store(store10).build());
        Product product11 = productService.create(Product.builder().name("Pizza Bacon").serial("asdasdfdew3r3").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).store(store1).build());
        Product product12 = productService.create(Product.builder().name("Napoliten Spaghetti").serial("asdasdfdew3r45533").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).store(store1).build());


        Account account1 = Account.builder().firstname("Spiros").lastname("Christodoulou").age(30).email("s.christodoulou@pmmretail.com").password("8frhev9").build();
        Address address1 = Address.builder().streetName("Athens").streetNumber(78).town("Pikermi").account(account1).build();
        Set<Address> addrs1 = new HashSet<>();
        addrs1.add(address1);
        account1.setAddresses(addrs1);

        CreditCard creditCard1 = CreditCard.builder().account(account1).cardNumber(Long.valueOf("1012111312141315")).expirationDate("5/24").holderName("Holder1").threeDigitCode(123).build();
        Set<CreditCard> ccs1 = new HashSet<>();
        ccs1.add(creditCard1);
        account1.setCreditCards(ccs1);

        account1 = accountService.create(account1);

        Account account2 = Account.builder().firstname("Vagelis").lastname("Vrailas").age(22).email("e.vrailas@pmmretail.com").password("kv904n4f").build();
        Address address2 = Address.builder().streetName("Peristeriou").streetNumber(78).town("Attiki").account(account2).build();
        Set<Address> addrs2 = new HashSet<>();
        addrs2.add(address2);
        account2.setAddresses(addrs2);

        CreditCard creditCard2 = CreditCard.builder().account(account2).cardNumber(Long.valueOf("1113121413151416")).expirationDate("5/24").holderName("Holder2").threeDigitCode(234).build();
        Set<CreditCard> ccs2 = new HashSet<>();
        ccs2.add(creditCard2);
        account2.setCreditCards(ccs2);

        account2 = accountService.create(account2);

        Account account3 = Account.builder().firstname("Vagelis").lastname("Iliadis").age(29).email("e.iliadis@pmmretail.com").password("84848A484frf").build();
        Address address3 = Address.builder().streetName("Athens").streetNumber(78).town("Attiki").account(account3).build();
        Set<Address> addrs3 = new HashSet<>();
        addrs3.add(address3);
        account3.setAddresses(addrs3);

        CreditCard creditCard3 = CreditCard.builder().account(account3).cardNumber(Long.valueOf("1234567899876543")).expirationDate("5/24").holderName("Holder3").threeDigitCode(345).build();
        Set<CreditCard> ccs3 = new HashSet<>();
        ccs3.add(creditCard3);
        account3.setCreditCards(ccs3);

        account3 = accountService.create(account3);

        Account account4 = Account.builder().firstname("John").lastname("Wick").age(45).email("j.wick@pmmretail.com").password("fs235g6").build();
        Address address4 = Address.builder().streetName("NY").streetNumber(78).town("Manhattan").account(account4).build();
        Set<Address> addrs4 = new HashSet<>();
        addrs4.add(address4);
        account4.setAddresses(addrs4);

        CreditCard creditCard4 = CreditCard.builder().account(account4).cardNumber(Long.valueOf("1214131514161517")).expirationDate("5/24").holderName("Holder4").threeDigitCode(456).build();
        Set<CreditCard> ccs4 = new HashSet<>();
        ccs4.add(creditCard4);
        account4.setCreditCards(ccs4);

        account4 = accountService.create(account4);

        Account account5 = Account.builder().firstname("Joey").lastname("Tribbiani").age(45).email("j.tribbiani@pmmretail.com").password("c68b54c9bn").build();
        Address address5 = Address.builder().streetName("NY").streetNumber(78).town("Brooklyn").account(account5).build();
        Set<Address> addrs5 = new HashSet<>();
        addrs5.add(address5);
        account5.setAddresses(addrs5);

        CreditCard creditCard5 = CreditCard.builder().account(account5).cardNumber(Long.valueOf("1315141615171618")).expirationDate("5/24").holderName("Holder5").threeDigitCode(567).build();
        Set<CreditCard> ccs5 = new HashSet<>();
        ccs5.add(creditCard5);
        account5.setCreditCards(ccs5);

        account5 = accountService.create(account5);


////        Address address1 = Address.builder().streetName("Athens").streetNumber(78).town("Attiki").account(account1).build();
////        logger.info("Created Address {}.", address1);
//        Address address2 = addressService.create(Address.builder().streetName("Peristeriou").streetNumber(15).town("Attiki").account(account2).build());
//        logger.info("Created Address {}.", address2);
//        Address address3 = addressService.create(Address.builder().streetName("Agiou Ioannou").streetNumber(32).town("Philadelfia").account(account3).build());
//        logger.info("Created Address {}.", address3);
//        Address address4 = addressService.create(Address.builder().streetName("Koloktroni").streetNumber(150).town("Petroupoli").account(account4).build());
//        logger.info("Created Address {}.", address4);
//        Address address5 = addressService.create(Address.builder().streetName("Thrakis").streetNumber(7).town("Chalandri").account(account5).build());
//        logger.info("Created Address {}.", address5);
//        Address address6 = addressService.create(Address.builder().streetName("Athinon").streetNumber(3).town("Attiki").account(account6).build());
//        logger.info("Created Address {}.", address6);
//        Address address7 = addressService.create(Address.builder().streetName("Liosion").streetNumber(1).town("Attiki").account(account7).build());
//        logger.info("Created Address {}.", address7);
//        Address address8 = addressService.create(Address.builder().streetName("Thrakomakedonon").streetNumber(65).town("Patisia").account(account8).build());
//        logger.info("Created Address {}.", address8);
//        Address address9 = addressService.create(Address.builder().streetName("Agion Theodoron").streetNumber(15).town("Attiki").account(account9).build());
//        logger.info("Created Address {}.", address9);
//        Address address10 = addressService.create(Address.builder().streetName("Ermou").streetNumber(36).town("Monastiraki").account(account10).build());
//        logger.info("Created Address {}.", address10);
//
////        CreditCard creditCard1 = creditCardService.create(CreditCard.builder().account(account1).cardNumber(Long.valueOf("1234567899876543")).expirationDate("5/24").holderName("Holder1").threeDigitCode(623).build());
////        logger.info("Created credit card {}.", creditCard1);
//        CreditCard creditCard2 = creditCardService.create(CreditCard.builder().account(account2).cardNumber(Long.valueOf("12368494952646543")).expirationDate("9/24").holderName("Holder2").threeDigitCode(123).build());
//        logger.info("Created credit card {}.", creditCard2);
//        CreditCard creditCard3 = creditCardService.create(CreditCard.builder().account(account3).cardNumber(Long.valueOf("9999967899876543")).expirationDate("5/24").holderName("Holder3").threeDigitCode(198).build());
//        logger.info("Created credit card {}.", creditCard3);
//        CreditCard creditCard4 = creditCardService.create(CreditCard.builder().account(account4).cardNumber(Long.valueOf("1234567444476543")).expirationDate("3/24").holderName("Holder4").threeDigitCode(523).build());
//        logger.info("Created credit card {}.", creditCard4);
//        CreditCard creditCard5 = creditCardService.create(CreditCard.builder().account(account5).cardNumber(Long.valueOf("1234333899876543")).expirationDate("2/24").holderName("Holder5").threeDigitCode(113).build());
//        logger.info("Created credit card {}.", creditCard5);
//        CreditCard creditCard6 = creditCardService.create(CreditCard.builder().account(account6).cardNumber(Long.valueOf("1234567111176543")).expirationDate("1/24").holderName("Holder6").threeDigitCode(053).build());
//        logger.info("Created credit card {}.", creditCard6);
//        CreditCard creditCard7 = creditCardService.create(CreditCard.builder().account(account7).cardNumber(Long.valueOf("1234500000006543")).expirationDate("11/24").holderName("Holder7").threeDigitCode(303).build());
//        logger.info("Created credit card {}.", creditCard7);
//        CreditCard creditCard8 = creditCardService.create(CreditCard.builder().account(account8).cardNumber(Long.valueOf("1234666666666643")).expirationDate("12/24").holderName("Holder8").threeDigitCode(993).build());
//        logger.info("Created credit card {}.", creditCard8);
//        CreditCard creditCard9 = creditCardService.create(CreditCard.builder().account(account9).cardNumber(Long.valueOf("1234544444444543")).expirationDate("10/24").holderName("Holder9").threeDigitCode(983).build());
//        logger.info("Created credit card {}.", creditCard9);
//        CreditCard creditCard10 = creditCardService.create(CreditCard.builder().account(account10).cardNumber(Long.valueOf("1234522222222243")).expirationDate("6/24").holderName("Holder10").threeDigitCode(723).build());
//        logger.info("Created credit card {}.", creditCard10);
//
////        storeService.addProducts(store1, product1);
//
//        Order order1 = orderService.initiateOrder(account1);
//        Order order2 = orderService.initiateOrder(account2);
//        Order order3 = orderService.initiateOrder(account3);
//        Order order4 = orderService.initiateOrder(account4);
//        Order order5 = orderService.initiateOrder(account5);
//        Order order6 = orderService.initiateOrder(account6);
//        Order order7 = orderService.initiateOrder(account7);
//        Order order8 = orderService.initiateOrder(account8);
//        Order order9 = orderService.initiateOrder(account9);
//        Order order10 = orderService.initiateOrder(account10);
//
//        Order order11 = orderService.create(Order.builder().account(account1).payAmount(BigDecimal.valueOf(15)).paymentMethod(PaymentMethod.CREDITCARD)
//                .store(store1).submitDate(Date.valueOf(LocalDate.now())).build());
//        Order order12 = orderService.create(Order.builder().account(account2).payAmount(BigDecimal.valueOf(50)).paymentMethod(PaymentMethod.CASH)
//                .store(store2).submitDate(Date.valueOf(LocalDate.now())).build());
//        Order order13 = orderService.create(Order.builder().account(account5).payAmount(BigDecimal.valueOf(151)).paymentMethod(PaymentMethod.CREDITCARD)
//                .store(store9).submitDate(Date.valueOf(LocalDate.now())).build());

    }
}
