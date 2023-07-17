package com.HospitalMangagementSystems.hospitalManagement.Repository;

import com.HospitalMangagementSystems.hospitalManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
