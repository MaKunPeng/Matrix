package com.dust.dms.user.domain.user.repository;

import com.dust.dms.user.domain.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
