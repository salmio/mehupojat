package fi.c5msiren.validator;

import fi.c5msiren.model.User;
import fi.c5msiren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Class for validating user registeration object
 *
 * @author Miika
 * @version 2017.5.09
 * @since 1.8
 */
@Component
public class UserValidator implements Validator {

    /**
     * Attribute containing reference to userService
     */   
    @Autowired
    private UserService userService;

    /**
     * Method for checking if its a user class
     *
     * @param aClass Somekind of class
     * @return boolean value if the parameter class is a user class
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    /**
     * Method for validating user input
     *
     * @param o Object to be validated
     * @param errors Error messages
     */
    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (!user.getUsername().contains("@")) {
            errors.rejectValue("username", "At.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}