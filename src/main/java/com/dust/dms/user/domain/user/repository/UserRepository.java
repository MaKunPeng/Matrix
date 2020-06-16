package com.dust.dms.user.domain.user.repository;

import com.dust.dms.user.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    List<User> findByUsername(String username);
}
