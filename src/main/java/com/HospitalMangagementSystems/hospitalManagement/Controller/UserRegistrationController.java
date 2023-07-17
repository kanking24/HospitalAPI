package com.HospitalMangagementSystems.hospitalManagement.Controller;

import com.HospitalMangagementSystems.hospitalManagement.Service.UserService;
import com.HospitalMangagementSystems.hospitalManagement.web.Dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}

//@RequestMapping(value = "/registration")
//public class UserRegistrationController {
//
//    private UserService userService;
//
//    public UserRegistrationController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @ModelAttribute("user")
//    public UserRegistrationDto userRegistrationDto(){
//        return new UserRegistrationDto();
//    }
//
//    @GetMapping
//    public String showRegistrationForm(){
//        return "registration";
//    }
//
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto) {
//        userService.save(registrationDto);
//        return "redirect:/registration?Sucess";
//    }
//}
