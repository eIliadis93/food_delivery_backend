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


        productService.create(Product.builder().name("Deluxe Burger").serial("asdasd").price(BigDecimal.valueOf(4.40)).productCategory(ProductCategory.BURGER).imgURL("assets/productsImg/Deluxe3.jpg").store(store1).build());
        productService.create(Product.builder().name("Crispy McBacon™ McMenu™").serial("asdasdasd").price(BigDecimal.valueOf(7.60)).productCategory(ProductCategory.MENU).imgURL("assets/productsImg/McBacon.jpg").store(store1).build());
        productService.create(Product.builder().name("Triple Cheeseburger").serial("asdasdasdasd").price(BigDecimal.valueOf(3.50)).productCategory(ProductCategory.BURGER).imgURL("assets/productsImg/Triple-Cheeseburger.jpg").store(store1).build());
        productService.create(Product.builder().name("Caesar`s ").serial("qweqwe").price(BigDecimal.valueOf(6.4)).productCategory(ProductCategory.SALAD).store(store1).imgURL("assets/productsImg/crispy-chicken-salad.jpg").build());
        productService.create(Product.builder().name("Μεγάλη Coca - Cola 500ml").serial("zxczxc").price(BigDecimal.valueOf(2.75)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/coca-cola-1024x693.jpg").store(store1).build());

        productService.create(Product.builder().name("Hamburger").serial("qwe1asd").price(BigDecimal.valueOf(2.95)).productCategory(ProductCategory.BURGER).imgURL("assets/productsImg/Extreme_Ham.jpg").store(store2).build());
        productService.create(Product.builder().name("Bao Buns crispy chicken").serial("asdfq23wer").price(BigDecimal.valueOf(5.90)).productCategory(ProductCategory.BAO).imgURL("assets/productsImg/BAO_SITE_CHICKEN_DOUBLE_FINAL.jpg").store(store2).build());
        productService.create(Product.builder().name("Chicken Wings").serial("asdasd414a95d").price(BigDecimal.valueOf(5.40)).productCategory(ProductCategory.FOOD).store(store2).imgURL("assets/productsImg/2007_Shadow_Chicken_Wings.jpg").build());
        productService.create(Product.builder().name("Πατάτες Country Style").serial("asda53sda963d").price(BigDecimal.valueOf(3.40)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/country_no_shadow.jpg").store(store2).build());
        productService.create(Product.builder().name("Mama`s").serial("asdasd43a4521sd").price(BigDecimal.valueOf(5.85)).productCategory(ProductCategory.SALAD).store(store2).imgURL("assets/productsImg/43_Shadow_Mamas_Medium.jpg").build());

        productService.create(Product.builder().name("Γύρος χοιρινός σε πίτα παραδοσιακή").serial("asdas55dfdew3r3").price(BigDecimal.valueOf(3.50)).productCategory(ProductCategory.TYLIXTA).imgURL("assets/productsImg/9962afd4d7801adbe96e49a2f2eab69f_L.jpg").store(store3).build());
        productService.create(Product.builder().name("Καλαμάκι χοιρινό σε πίτα παραδοσιακή").serial("asdasdfdew3r415533").price(BigDecimal.valueOf(3.4)).productCategory(ProductCategory.TYLIXTA).imgURL("assets/productsImg/bbw-souvlakia-19.09.1921622.jpg").store(store3).build());
        productService.create(Product.builder().name("Club φιλέτο κοτόπουλο").serial("asd0asda4521sd").price(BigDecimal.valueOf(9.50)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/club-sandwich-1-1024x683.jpg").store(store3).build());
        productService.create(Product.builder().name("Χωριάτικη").serial("asdasdfdew3r03").price(BigDecimal.valueOf(6.25)).productCategory(ProductCategory.SALAD).store(store3).imgURL("assets/productsImg/xoriatiki-salata--ep.63---9-5-22---ver.jpg").build());
        productService.create(Product.builder().name("Μπριζολάκια χοιρινά").serial("asd00asdfdew3r45533").price(BigDecimal.valueOf(12.50)).productCategory(ProductCategory.FOOD).store(store3).imgURL("assets/productsImg/bbw-17.10.1924346_new.jpg").build());

        productService.create(Product.builder().name("Bianca Piccante Πεπερονάτη (Italian Fan)").serial("asdasd00fdew3r3").price(BigDecimal.valueOf(8.20)).productCategory(ProductCategory.PIZZA).imgURL("assets/productsImg/bianca.jpg").store(store4).build());
        productService.create(Product.builder().name("Πίτσα Crosscut Cheeseburger").serial("asdasdfde00w3r45533").price(BigDecimal.valueOf(10.50)).productCategory(ProductCategory.PIZZA).imgURL("assets/productsImg/crosscut.jpg").store(store4).build());
        productService.create(Product.builder().name("Μαργαρίτα").serial("asdasd000a4521sd").price(BigDecimal.valueOf(7.40)).productCategory(ProductCategory.PIZZA).store(store4).imgURL("assets/productsImg/margarita.jpg").build());
        productService.create(Product.builder().name("Pizza Bacon").serial("00asdasdfdew3r3").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.PIZZA).store(store4).imgURL("assets/productsImg/baconpizza.jpg").build());
        productService.create(Product.builder().name("BBQ Chicken").serial("asdasdfdew003r45533").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.PIZZA).store(store4).imgURL("assets/productsImg/bbqchicken.jpg").build());

         productService.create(Product.builder().name("Μερ. Κεμπάπ").serial("asdasdfdew3r003").price(BigDecimal.valueOf(8.90)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/kempam.jpg").store(store5).build());
         productService.create(Product.builder().name("Tυροπιτάρι με φέτα").serial("asdasdfd00ew3r45533").price(BigDecimal.valueOf(5.80)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/tyropitari.jpg").store(store5).build());
         productService.create(Product.builder().name("Παραδοσιακό Φαλάφελ").serial("as00dasda4521sd").price(BigDecimal.valueOf(5.85)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/falafel.jpg").store(store5).build());
         productService.create(Product.builder().name("Πατάτες τηγανητές").serial("asd000asdfdew3r3").price(BigDecimal.valueOf(3.80)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/patates.jpg").store(store5).build());
         productService.create(Product.builder().name("Αυθεντικό Λαχματζούν").serial("asdasdf00dew3r45533").price(BigDecimal.valueOf(5.90)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/laxmatzoun.jpg").store(store5).build());

         productService.create(Product.builder().name("Μπανάνες").serial("asda6s00dfdew3r3").price(BigDecimal.valueOf(2.09)).productCategory(ProductCategory.FRUITS).imgURL("assets/productsImg/banana.jpg").store(store6).build());
         productService.create(Product.builder().name("Λεμόνια Βιολογικά").serial("asdasdf6dew3r0045533").price(BigDecimal.valueOf(3.58)).productCategory(ProductCategory.FRUITS).store(store6).imgURL("assets/productsImg/lemonia.jpg").build());
        productService.create(Product.builder().name("Ρόκα Βιολογική").serial("asda67sda4521sd").price(BigDecimal.valueOf(1.89)).productCategory(ProductCategory.VEGETABLES).store(store6).imgURL("assets/productsImg/roka.jpg").build());
         productService.create(Product.builder().name("Μύρτιλλα").serial("asdasd87fdew3r3").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FRUITS).store(store6).imgURL("assets/productsImg/murtila.jpg").build());
         productService.create(Product.builder().name("Φρουτοσαλάτα").serial("asdasdfd97ew3r45533").price(BigDecimal.valueOf(3.48)).productCategory(ProductCategory.FRUITS).imgURL("assets/productsImg/ananas.jpg").store(store6).build());

        productService.create(Product.builder().name("Cheese n` ham").serial("asdasd46fdew3r3").price(BigDecimal.valueOf(4.80)).productCategory(ProductCategory.CREPE).store(store7).imgURL("assets/productsImg/krepaalmiri.jpg").build());
       productService.create(Product.builder().name("Four cheeses").serial("asdasd689fdew3r45533").price(BigDecimal.valueOf(6.80)).productCategory(ProductCategory.CREPE).imgURL("assets/productsImg/krepaalmiri.jpg").store(store7).build());
        productService.create(Product.builder().name("Black & white").serial("asdasd075a4521sd").price(BigDecimal.valueOf(5.80)).productCategory(ProductCategory.CREPE).store(store7).imgURL("assets/productsImg/krepaglikia.jpg").build());
       productService.create(Product.builder().name("White oreo").serial("asdasdfde467w3r3").price(BigDecimal.valueOf(5.30)).productCategory(ProductCategory.CREPE).store(store7).imgURL("assets/productsImg/krepaglikia.jpg").build());
        productService.create(Product.builder().name("Choco μπανάνα").serial("asdasdf846dew3r45533").price(BigDecimal.valueOf(5.10)).productCategory(ProductCategory.CREPE).imgURL("assets/productsImg/krepaglikia.jpg").store(store7).build());

        productService.create(Product.builder().name("Cappuccino Freddo").serial("4768asdasdfdew3r3").price(BigDecimal.valueOf(2.20)).productCategory(ProductCategory.COFFEE).imgURL("assets/productsImg/freddo.jpg").store(store8).build());
        productService.create(Product.builder().name("Κουλούρι Θεσσαλονίκης").serial("asdas875dfdew3r45533").price(BigDecimal.valueOf(0.80)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/koulouri.jpg").store(store8).build());
        productService.create(Product.builder().name("Ζαμπονοτυρόπιτα").serial("asdasd858956a4521sd").price(BigDecimal.valueOf(2.30)).productCategory(ProductCategory.SALAD).store(store8).imgURL("assets/productsImg/zampon.jpg").build());
        productService.create(Product.builder().name("Πίτσα Special").serial("asdasdfd86585ew3r3").price(BigDecimal.valueOf(3.80)).productCategory(ProductCategory.FOOD).store(store8).imgURL("assets/productsImg/pizzaspecial.jpg").build());
        productService.create(Product.builder().name("Σπανακοτυρόπιτα").serial("asdasdfd5665ew3r45533").price(BigDecimal.valueOf(2.50)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/spanakopita.jpg").store(store8).build());

       productService.create(Product.builder().name("WINGS & RINGS").serial("asdasd368fdew3r3").price(BigDecimal.valueOf(7.50)).productCategory(ProductCategory.FOOD).store(store9).imgURL("assets/productsImg/wingring.jpg").build());
        productService.create(Product.builder().name("The Philly").serial("asdas6368dfdew3r45533").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.BURGER).store(store9).imgURL("assets/productsImg/philly.jpg").build());
        productService.create(Product.builder().name("The CLassic").serial("asdas63698da4521sd").price(BigDecimal.valueOf(7.70)).productCategory(ProductCategory.BURGER).store(store9).imgURL("assets/productsImg/classic.jpg").build());
       productService.create(Product.builder().name("Swiss Mushroom").serial("asdasd0789fdew3r3").price(BigDecimal.valueOf(9.20)).productCategory(ProductCategory.BURGER).store(store9).imgURL("assets/productsImg/swiss.jpg").build());
       productService.create(Product.builder().name("The Beefeater").serial("asd089asdfdew3r45533").price(BigDecimal.valueOf(10.90)).productCategory(ProductCategory.FOOD).store(store9).imgURL("assets/productsImg/beefeater.jpg").build());

       productService.create(Product.builder().name("Espresso").serial("asdasd0898fdew3r3").price(BigDecimal.valueOf(1.50)).productCategory(ProductCategory.COFFEE).store(store10).imgURL("assets/productsImg/Espresso_shot.jpg").build());
       productService.create(Product.builder().name("Choco Pancakes").serial("asda0875sdfdew3r45533").price(BigDecimal.valueOf(7.60)).productCategory(ProductCategory.FOOD).store(store10).imgURL("assets/productsImg/mqdefault.jpg").build());
       productService.create(Product.builder().name("English Breakfast").serial("asdasd56790a4521sd").price(BigDecimal.valueOf(10.65)).productCategory(ProductCategory.FOOD).store(store10).imgURL("assets/productsImg/istockphoto-641845826-612x612.jpg").build());
       productService.create(Product.builder().name("Strawberry Pancakes").serial("asdasdfd08068ew3r3").price(BigDecimal.valueOf(9.90)).productCategory(ProductCategory.FOOD).store(store10).imgURL("assets/productsImg/PXL_20220901_114646765.jpg").build());
       productService.create(Product.builder().name("Crepe").serial("asdasdfd58890ew3r45533").price(BigDecimal.valueOf(5.50)).productCategory(ProductCategory.FOOD).imgURL("assets/productsImg/download.jpg").store(store10).build());


        Account account1 = Account.builder().firstname("Spiros").lastname("Christodoulou").age(30).email("s.christodoulou@pmmretail.com").password("8frhev9").build();
        CreditCard creditCard1 = CreditCard.builder().cardNumber(Long.valueOf("1012111312141315")).expirationDate("5/24").holderName("Holder1").threeDigitCode(123).build();
        Set<CreditCard> ccs1 = new HashSet<>();
        account1 = accountService.create(account1);

        Account account2 = Account.builder().firstname("Vagelis").lastname("Vrailas").age(22).email("e.vrailas@pmmretail.com").password("kv904n4f").build();
        CreditCard creditCard2 = CreditCard.builder().cardNumber(Long.valueOf("1113121413151416")).expirationDate("5/24").holderName("Holder2").threeDigitCode(234).build();
        account2 = accountService.create(account2);

        Account account3 = Account.builder().firstname("Vagelis").lastname("Iliadis").age(29).email("e.iliadis@pmmretail.com").password("84848A484frf").build();
        Address address3 = Address.builder().streetName("Athens").streetNumber(78).town("Attiki").build();

        CreditCard creditCard3 = CreditCard.builder().cardNumber(Long.valueOf("1234567899876543")).expirationDate("5/24").holderName("Holder3").threeDigitCode(345).build();
        Set<CreditCard> ccs3 = new HashSet<>();

        account3 = accountService.create(account3);

        Account account4 = Account.builder().firstname("John").lastname("Wick").age(45).email("j.wick@pmmretail.com").password("fs235g6").build();
        CreditCard creditCard4 = CreditCard.builder().cardNumber(Long.valueOf("1214131514161517")).expirationDate("5/24").holderName("Holder4").threeDigitCode(456).build();
        Set<CreditCard> ccs4 = new HashSet<>();
        account4 = accountService.create(account4);

        Account account5 = Account.builder().firstname("Joey").lastname("Tribbiani").age(45).email("j.tribbiani@pmmretail.com").password("c68b54c9bn").build();
        Address address5 = Address.builder().streetName("NY").streetNumber(78).town("Brooklyn").build();
        CreditCard creditCard5 = CreditCard.builder().cardNumber(Long.valueOf("1315141615171618")).expirationDate("5/24").holderName("Holder5").threeDigitCode(567).build();
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
