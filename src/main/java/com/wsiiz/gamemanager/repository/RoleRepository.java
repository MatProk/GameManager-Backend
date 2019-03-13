package com.wsiiz.gamemanager.repository;

import com.wsiiz.gamemanager.domain.Role;
import com.wsiiz.gamemanager.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}