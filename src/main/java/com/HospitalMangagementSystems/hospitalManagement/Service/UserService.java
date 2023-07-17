package com.HospitalMangagementSystems.hospitalManagement.Service;

import com.HospitalMangagementSystems.hospitalManagement.Model.User;
import com.HospitalMangagementSystems.hospitalManagement.web.Dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
