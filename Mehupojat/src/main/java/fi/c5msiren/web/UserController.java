package fi.c5msiren.web;

import fi.c5msiren.service.UserService;
import fi.c5msiren.service.SecurityService;
import fi.c5msiren.validator.UserValidator;
import fi.c5msiren.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class acts as a controller for user
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Controller
public class UserController {

    /**
     * Reference to UserService class
     */  
    @Autowired
    private UserService userService;

    /**
     * Reference to SecurityService class
     */
    @Autowired
    private SecurityService securityService;

    /**
     * Reference to UserValidator class
     */
    @Autowired
    private UserValidator userValidator;

    /**
     * Method to get registration data
     * 
     * @param model Holds the registration data
     * @return identification String
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    /**
     * Method to post registration data
     * 
     * @param userForm Holds the registration data
     * @param bindingResult errors
     * @return redirecting String
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/index.jsp";
    }

    /**
     * Method for checking the login data
     * 
     * @param model Holds the login data
     * @param error String for error message
     * @param logout String to see if logged out
     * @return identification String
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    /*@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }*/
}