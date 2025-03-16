package org.example.repository;

import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByName(String name);
    Optional<UserEntity> findByRoles(UserRoles role);
}
