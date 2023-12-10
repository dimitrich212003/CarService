package com.example.carservice2;

import com.example.carservice2.models.*;
import com.example.carservice2.services.*;
import com.example.carservice2.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandsService brandsService;
    private final ModelsService modelsService;
    private final OffersService offersService;
    private final UsersService usersService;
    private final RolesService rolesService;

    @Autowired
    public DataInitializer(BrandsService brandsService, ModelsService modelsService, OffersService offersService, UsersService usersService, RolesService rolesService) {
        this.brandsService = brandsService;
        this.modelsService = modelsService;
        this.offersService = offersService;
        this.usersService = usersService;
        this.rolesService = rolesService;
    }

@Override
public void run(String... args) {
    // Создание брендов
    BrandsDTO brand1 = new BrandsDTO();
    brand1.setName("BMW");
    brand1 = brandsService.createBrand(brand1);

    BrandsDTO brand2 = new BrandsDTO();
    brand2.setName("Mercedes");
    brand2 = brandsService.createBrand(brand2);

    BrandsDTO brand3 = new BrandsDTO();
    brand3.setName("Audi");
    brand3 = brandsService.createBrand(brand3);

    BrandsDTO brand4 = new BrandsDTO();
    brand4.setName("Haval");
    brand4 = brandsService.createBrand(brand4);

    BrandsDTO brand5 = new BrandsDTO();
    brand5.setName("Gelly");
    brand5 = brandsService.createBrand(brand5);

    // BMW
    ModelsDTO model1 = new ModelsDTO();
    model1.setName("m5");
    model1.setCategory(Models.CategoryType.CAR);
    model1.setImageUrl("https://stk-briket.ru/wp-content/uploads/4/5/b/45b6d4b6c6d1973b6dabaaab550171c2.jpeg");
    model1.setStartYear(2010);
    model1.setEndYear(2019);
    model1.setBrand(brand1.getId());
    model1 = modelsService.createModel(model1);

    ModelsDTO model3 = new ModelsDTO();
    model3.setName("x6");
    model3.setCategory(Models.CategoryType.BUSS);
    model3.setImageUrl("https://dima-sychev.ru/wp-content/uploads/f/0/3/f0393dd8b405ca96ffd8a73ea41ab18d.jpeg");
    model3.setStartYear(2013);
    model3.setEndYear(2023);
    model3.setBrand(brand1.getId());
    model3 = modelsService.createModel(model3);

    //Mercedes
    ModelsDTO model2 = new ModelsDTO();
    model2.setName("CLS G63 AMG");
    model2.setCategory(Models.CategoryType.CAR);
    model2.setImageUrl("https://i.ytimg.com/vi/TuvCjWJ6Sqs/maxresdefault.jpg");
    model2.setStartYear(2015);
    model2.setEndYear(2022);
    model2.setBrand(brand2.getId());
    model2 = modelsService.createModel(model2);

    //Audi
    ModelsDTO model4 = new ModelsDTO();
    model4.setName("RS7");
    model4.setCategory(Models.CategoryType.CAR);
    model4.setImageUrl("https://roadres.com/gallery/2019/10/foto-rs7-sp-ii_206.jpg");
    model4.setStartYear(2007);
    model4.setEndYear(2023);
    model4.setBrand(brand3.getId());
    model4 = modelsService.createModel(model4);

    ModelsDTO model5 = new ModelsDTO();
    model5.setName("A80");
    model5.setCategory(Models.CategoryType.CAR);
    model5.setImageUrl("https://dolmax.ru/auto/photos/7892652.jpg");
    model5.setStartYear(1980);
    model5.setEndYear(2000);
    model5.setBrand(brand3.getId());
    model5 = modelsService.createModel(model5);

    //Haval
    ModelsDTO model6 = new ModelsDTO();
    model6.setName("Jolyon Elite");
    model6.setCategory(Models.CategoryType.CAR);
    model6.setImageUrl("https://коврикиева.рф/assets/img/products/3807/jolion.jpg");
    model6.setStartYear(2020);
    model6.setEndYear(2023);
    model6.setBrand(brand4.getId());
    model6 = modelsService.createModel(model6);

    //Gelly
    ModelsDTO model7 = new ModelsDTO();
    model7.setName("Coolray");
    model7.setCategory(Models.CategoryType.CAR);
    model7.setImageUrl("https://carsweek.ru/upload/iblock/29e/nfr2f9emps4jpp2ukh4xc0hmprzx7swo.jpg");
    model7.setStartYear(2021);
    model7.setEndYear(2023);
    model7.setBrand(brand5.getId());
    model7 = modelsService.createModel(model7);

    // Создание ролей пользователей
    RolesDTO roleAdmin = new RolesDTO();
    roleAdmin.setRole(Roles.RoleType.ADMIN);
    roleAdmin = rolesService.createRole(roleAdmin);

    RolesDTO roleUser = new RolesDTO();
    roleUser.setRole(Roles.RoleType.USER);
    roleUser = rolesService.createRole(roleUser);

    // Создание пользователей
    UsersDTO user1 = new UsersDTO();
    user1.setUsername("userone");
    user1.setPassword("12345678");
    user1.setFirstName("User");
    user1.setLastName("One");
    user1.setIsActive(true);
    user1.setRole(roleAdmin.getId());
    user1 = usersService.createUser(user1);

    UsersDTO user2 = new UsersDTO();
    user2.setUsername("anagor03");
    user2.setPassword("89601010392Ar");
    user2.setFirstName("Артем");
    user2.setLastName("Нагорный");
    user2.setImageUrl("https://sun9-57.userapi.com/impg/YrQFphdjsTmozIUep7c1BSies0pr27YORJauew/FVlIK3P8zLw.jpg?size=1620x2160&quality=95&sign=0e9f538aac2f616d036b969c90a1060e&type=album");
    user2.setIsActive(true);
    user2.setRole(roleUser.getId());
    user2 = usersService.createUser(user2);

    UsersDTO user3 = new UsersDTO();
    user3.setUsername("temaSush27");
    user3.setPassword("270705sush");
    user3.setFirstName("Артем");
    user3.setLastName("Сушин");
    user3.setImageUrl("https://sun9-23.userapi.com/impg/P5y4BaK56KJ0iCI3jn8PPp5UHobhUx0KaJZDWw/Hh2qV0bI8NU.jpg?size=1280x960&quality=95&sign=5ea794ef5040e216e6aff3d6d8d5cf06&type=album");
    user3.setIsActive(true);
    user3.setRole(roleUser.getId());
    user3 = usersService.createUser(user3);

    UsersDTO user4 = new UsersDTO();
    user4.setUsername("dimi_trich");
    user4.setPassword("89525517029Di");
    user4.setFirstName("Дмитрий");
    user4.setLastName("Глущенко");
    user4.setImageUrl("https://sun9-78.userapi.com/impg/4KNZD6d8Wj7m4CaaxQHPTikKxPGMSGxgTkPGHA/7DWh9fVBKUQ.jpg?size=2560x1706&quality=95&sign=8adc2dd9d139c0788d3535d957bdcdfb&type=album");
    user4.setIsActive(true);
    user4.setRole(roleUser.getId());
    user4 = usersService.createUser(user4);

    // Создание предложений
    //BMW M5
    OffersDTO offer1 = new OffersDTO();
    offer1.setDescription("Представь, ты молодой пацан и ты покупаешь себе BMW M5 " +
            "черного цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи. ");
    offer1.setEngine(Offers.EngineType.GASOLINE);
    offer1.setMileage(25000);
    offer1.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/5177156/e7d921b5e761940384cbef5ebbb8fc4d/1200x900n");
    offer1.setPrice(new BigDecimal( 6550000));
    offer1.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer1.setYear(2018);
    offer1.setUser(user2.getId());
    offer1.setModel(model1.getId());
    offersService.createOffer(offer1);

    //BMW X6
    OffersDTO offer2 = new OffersDTO();
    offer2.setDescription("Представь, ты молодой пацан и ты покупаешь себе BMW X6 " +
            "черного цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи.");
    offer2.setEngine(Offers.EngineType.DIESEL);
    offer2.setMileage(150000);
    offer2.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/11038141/641c15883066aacd3ca4e432f0ef5879/1200x900n");
    offer2.setPrice(new BigDecimal( 1900000));
    offer2.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer2.setYear(2016);
    offer2.setUser(user2.getId());
    offer2.setModel(model3.getId());
    offersService.createOffer(offer2);

    // Mercedec CLS
    OffersDTO offer3 = new OffersDTO();
    offer3.setDescription("Представь, ты молодой пацан и ты покупаешь себе БАНАН " +
            "черного цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи.");
    offer3.setEngine(Offers.EngineType.GASOLINE);
    offer3.setMileage(15000);
    offer3.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/11025717/8382b48e4cae1d9732373d7d5f0d7757/1200x900n");
    offer3.setPrice(new BigDecimal( 15600000));
    offer3.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer3.setYear(2022);
    offer3.setUser(user2.getId());
    offer3.setModel(model2.getId());
    offersService.createOffer(offer3);

    //AUDI RS7
    OffersDTO offer4 = new OffersDTO();
    offer4.setDescription("Представь, ты молодой пацан и ты покупаешь себе AUDI RS7 " +
            "черного цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи.");
    offer4.setEngine(Offers.EngineType.GASOLINE);
    offer4.setMileage(10000);
    offer4.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/6147753/e3bebf9ec5e8000235cf8e2faa1f5675/1200x900n");
    offer4.setPrice(new BigDecimal( 17550000));
    offer4.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer4.setYear(2023);
    offer4.setUser(user3.getId());
    offer4.setModel(model4.getId());
    offersService.createOffer(offer4);

    //AUDI A80
    OffersDTO offer5 = new OffersDTO();
    offer5.setDescription("Представь, ты молодой пацан и ты покупаешь себе AUDI A80 " +
            "фиолетового цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи.");
    offer5.setEngine(Offers.EngineType.GASOLINE);
    offer5.setMileage(290000);
    offer5.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/5177156/f3ac1effe98c9554cfb8ba380c42d197/1200x900n");
    offer5.setPrice(new BigDecimal( 180000));
    offer5.setTransmission(Offers.TransmissionType.MANUAL);
    offer5.setYear(1998);
    offer5.setUser(user3.getId());
    offer5.setModel(model5.getId());
    offersService.createOffer(offer5);

    //Haval Jolyon Elite
    OffersDTO offer6 = new OffersDTO();
    offer6.setDescription("Представь, ты молодой пацан и ты покупаешь себе Haval Jolyon Elite " +
            "фиолетового цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи.");
    offer6.setEngine(Offers.EngineType.DIESEL);
    offer6.setMileage(7700);
    offer6.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/10900358/7ffa5452ecee582ff20fa8af3443b576/1200x900n");
    offer6.setPrice(new BigDecimal( 3300000));
    offer6.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer6.setYear(2022);
    offer6.setUser(user3.getId());
    offer6.setModel(model6.getId());
    offersService.createOffer(offer6);

    //Gelly Coolray
    OffersDTO offer7 = new OffersDTO();
    offer7.setDescription("Представь, ты молодой пацан и ты покупаешь себе Gelly Coolray " +
            "фиолетового цвета, из под деда, коробка не пинается, масло не течет, " +
            "ЛКП в отличном состоянии. Телефон: 88005553535. Звоните в любое " +
            "время дня и ночи.");
    offer7.setEngine(Offers.EngineType.GASOLINE);
    offer7.setMileage(55000);
    offer7.setImageUrl("https://avatars.mds.yandex.net/get-autoru-vos/4303191/c94ad6a47059f5c36de3bb25b745bcc5/1200x900n");
    offer7.setPrice(new BigDecimal( 2100000));
    offer7.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer7.setYear(2021);
    offer7.setUser(user3.getId());
    offer7.setModel(model7.getId());
    offersService.createOffer(offer7);
}
}
