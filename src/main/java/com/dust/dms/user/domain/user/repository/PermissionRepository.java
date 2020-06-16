package com.dust.dms.user.domain.user.repository;

import com.dust.dms.user.domain.user.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
