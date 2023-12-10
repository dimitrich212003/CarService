package com.example.carservice2.web;

import com.example.carservice2.services.BrandsService;
import com.example.carservice2.services.ModelsService;
import com.example.carservice2.services.OffersService;
import com.example.carservice2.services.UsersService;
import com.example.carservice2.services.dto.OffersDTO;
import com.example.carservice2.services.dto.UsersDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class OffersWebController {

    private BrandsService brandsService;
    private ModelsService modelsService;
    private OffersService offersService;
    private UsersService usersService;

    @Autowired
    public void setBrandsService(BrandsService brandsService) {
        this.brandsService = brandsService;
    }
    @Autowired
    public void setModelsService(ModelsService modelsService) {
        this.modelsService = modelsService;
    }
    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/offer/add")
    public String addOfferPage(@RequestParam(name = "brandId", required = false) UUID brandId, Model model) {
        model.addAttribute("brands", brandsService.getAllBrands());
        if (brandId != null) {
            model.addAttribute("models", modelsService.getModelsByBrandId(brandId));
        }
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "addOffer";
    }

    @ModelAttribute("offerModel")
    public OffersDTO initOffer() {
        return new OffersDTO();
    }

    @PostMapping("/offer/add")
    public String addOffer(@Valid OffersDTO offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        // bindingResult хранит в себе результаты валидации, полученные после отправки формы
        // Если bindingResult имеет ошибки, значит пользователь не правильно заполнил форму
        // а после ее отправил. И чтобы пользователю не заполнять все заного, используем
        // redirectAttributes.addFlashAttribute(), чтобы при обновлении страницы в input тегах
        // сохранились данные, выбранные пользователем, которые он должен исправить
        if (bindingResult.hasErrors()) {

            // здесь хранятся неправильные данные, отправленные пользователем
            redirectAttributes.addFlashAttribute("offerModel", offerModel);

            // а здесь мы сохраняем ошибки, которые были в bindingResults, чтобы
            // при обновлении страницы мы могли "Подсветить" Неправильные поля
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);

            return "redirect:/offer/add";
        }
        UsersDTO user = usersService.getUsersByUsername("dimi_trich");
        offerModel.setUser(user.getId());
        offersService.createOffer(offerModel);

        return "redirect:/offers";
    }

    @GetMapping("/offer/update/{offerId}")
    public String changeOfferPage(@PathVariable("offerId") String offerId, Model model) {
        model.addAttribute("offer", offersService.getOfferById(UUID.fromString(offerId)));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "changeOffer";
    }

    @ModelAttribute("offer")
    public OffersDTO initOfferUpdate() {
        return new OffersDTO();
    }

    @PostMapping("/offer/update/{offerId}")
    public String changeOffer(@PathVariable("offerId") String offerId, @Valid
    OffersDTO offer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offer", offer);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer", bindingResult);

            return "redirect:/offer/update/{offerId}";
        }
        offersService.updateOffer(UUID.fromString(offerId), offer);
        return "redirect:/offer/{offerId}";

    }

    @GetMapping("/offers/{modelId}") // офферы конкретной модели
    public String modelOffersPage(@PathVariable("modelId") String modelId, Model model) {
        model.addAttribute("brand", brandsService.findByModelId(UUID.fromString(modelId)));
        model.addAttribute("model", modelsService.getModelById(UUID.fromString(modelId)));
        model.addAttribute("offers", offersService.getOffersByModelId(UUID.fromString(modelId)));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "modelOffers";
    }

    @GetMapping("/person/offer/{offerId}") //оффер другого конкретного пользователя
    public String offerPage(@PathVariable("offerId") String offerId, Model model) {
        model.addAttribute("brand", brandsService.getBrandByModel(modelsService.findByOfferId(UUID.fromString(offerId))));
        model.addAttribute("model", modelsService.findByOfferId(UUID.fromString(offerId)));
        model.addAttribute("offer", offersService.getOfferById(UUID.fromString(offerId)));
        model.addAttribute("user", usersService.findByOfferId(UUID.fromString(offerId)));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "offer";
    }

    @GetMapping("/offers/user/{userId}") //офферы другого конкретного пользователя
    public String offersPage(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("user", usersService.getUserById(UUID.fromString(userId)));
        model.addAttribute("offers", offersService.getOffersByUserId(UUID.fromString(userId)));
        model.addAttribute("models", modelsService.getModelsByOffers(offersService.getOffersByUserId(UUID.fromString(userId))));
        model.addAttribute("brands", brandsService.getBrandsByModels(modelsService.getModelsByOffers(offersService.getOffersByUserId(UUID.fromString(userId)))));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "userOffers";
    }

    @GetMapping("/offer/{offerId}") // мой оффер
    public String myOfferPage(@PathVariable("offerId") String offerId, Model model) {
        model.addAttribute("brand", brandsService.getBrandByModel(modelsService.findByOfferId(UUID.fromString(offerId))));
        model.addAttribute("model", modelsService.findByOfferId(UUID.fromString(offerId)));
        model.addAttribute("offer", offersService.getOfferById(UUID.fromString(offerId)));
        model.addAttribute("user", usersService.findByOfferId(UUID.fromString(offerId)));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "myOffer";
    }

    @GetMapping("/offers") //Мои офферы
    public String myOffersPage(Model model) {
        model.addAttribute("offers", offersService.getOffersByUserId(usersService.getUsersByUsername("dimi_trich").getId()));
        model.addAttribute("models", modelsService.getModelsByOffers(offersService.getOffersByUserId(usersService.getUsersByUsername("dimi_trich").getId())));
        model.addAttribute("brands", brandsService.getBrandsByModels(modelsService.getModelsByOffers(offersService.getOffersByUserId(usersService.getUsersByUsername("dimi_trich").getId()))));
        model.addAttribute("headerUser", usersService.getUsersByUsername("dimi_trich"));
        return "myOffers";
    }

    @GetMapping("/offer/delete/{offerId}")
    public String deleteOffer(@PathVariable("offerId") String offerId) {
        offersService.deleteOffer(UUID.fromString(offerId));

        return "redirect:/offers";
    }
}
