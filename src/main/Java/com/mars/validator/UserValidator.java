package com.mars.validator;


import com.mars.model.User;
import com.mars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.xml.bind.ValidationEventHandler;

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.field");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 12) {
            errors.rejectValue("username", "form.username.size");
        }
        if ( userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("username", "form.username.duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.field");
        if(user.getUserName().length() < 6 || user.getUserName().length() > 12) {
            errors.rejectValue("password", "form.password.size");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "form.password.match");
        }

    }
}
