package br.com.books.util

import br.com.books.data.service.UserService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class LoginAvailableValidator(private var userService: UserService) : ConstraintValidator<LoginAvailable, String> {

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        if(value.isEmpty()) {
            return false
        }
        return userService.loginAvailable(value)
    }

}
