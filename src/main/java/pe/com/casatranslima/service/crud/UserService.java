package pe.com.casatranslima.service.crud;

import org.springframework.security.core.userdetails.UserDetailsService;

import pe.com.casatranslima.controller.dto.UserRegistrationDto;
import pe.com.casatranslima.model.entity.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}