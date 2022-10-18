package com.wezaam.withdrawal.repository;

import com.wezaam.withdrawal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "userRepository")
public interface UsersRepository extends JpaRepository<User, Long> {
}
