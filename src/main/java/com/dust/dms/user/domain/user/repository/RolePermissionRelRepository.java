package com.dust.dms.user.domain.user.repository;

import com.dust.dms.user.domain.user.entity.RolePermissionRel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRelRepository extends JpaRepository<RolePermissionRel, Long> {
}
