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
    brand1.setName("Brand One");
    brand1 = brandsService.createBrand(brand1);

    BrandsDTO brand2 = new BrandsDTO();
    brand2.setName("Brand Two");
    brand2 = brandsService.createBrand(brand2);

    // Создание ролей пользователей
    RolesDTO roleAdmin = new RolesDTO();
    roleAdmin.setRole(Roles.RoleType.ADMIN);

    RolesDTO roleUser = new RolesDTO();
    roleUser.setRole(Roles.RoleType.USER);

    // Создание пользователей
    UsersDTO user1 = new UsersDTO();
    user1.setUsername("userone");
    user1.setFirstName("User");
    user1.setLastName("One");
    user1.setActive(true);
    user1.setRole((roleAdmin.getRole()).toString());
    user1 = usersService.createUser(user1);

    UsersDTO user2 = new UsersDTO();
    user2.setUsername("usertwo");
    user2.setFirstName("User");
    user2.setLastName("Two");
    user2.setActive(false);
    user2.setRole((roleUser.getRole()).toString());
    user2 = usersService.createUser(user2);

    // Создание моделей автомобилей
    ModelsDTO model1 = new ModelsDTO();
    model1.setName("Model One");
    model1.setCategory(Models.CategoryType.CAR);
    model1.setImageUrl("https://fikiwiki.com/uploads/posts/2022-02/mashin-53.jpg");
    model1.setBrand(brand1.getName());
    model1 = modelsService.createModel(model1);

    ModelsDTO model2 = new ModelsDTO();
    model2.setName("Model Two");
    model2.setCategory(Models.CategoryType.TRUCK);
    model2.setImageUrl("https://fikiwiki.com/uploads/posts/2022-02/mashin-54.jpg");
    model2.setBrand(brand2.getName());
    model2 = modelsService.createModel(model2);

    // Создание предложений
    OffersDTO offer1 = new OffersDTO();
    offer1.setDescription("This is a description for offer one.");
    offer1.setEngine(Offers.EngineType.GASOLINE);
    offer1.setMileage(25000);
    offer1.setPrice(new BigDecimal( 30000.00));
    offer1.setTransmission(Offers.TransmissionType.AUTOMATIC);
    offer1.setYear(2010);
    offer1.setUserFirstName(user1.getFirstName());
    offer1.setUserLastName(user1.getLastName());
    offer1.setModelName(model1.getName());
    offersService.createOffer(offer1);

    OffersDTO offer2 = new OffersDTO();
    offer2.setDescription("This is a description for offer two.");
    offer2.setEngine(Offers.EngineType.DIESEL);
    offer2.setMileage(10000);
    offer2.setPrice(new BigDecimal( 45000.00));
    offer2.setTransmission(Offers.TransmissionType.MANUAL);
    offer2.setYear(2015);
    offer2.setUserFirstName(user2.getFirstName());
    offer2.setUserLastName(user2.getLastName());
    offer2.setModelName(model2.getName());
    offersService.createOffer(offer2);
}
}
