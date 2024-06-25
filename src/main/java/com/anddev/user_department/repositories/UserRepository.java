package com.anddev.user_department.repositories;

import com.anddev.user_department.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
