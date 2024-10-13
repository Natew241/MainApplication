package com.joggingthoughts.repository;

import com.joggingthoughts.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);

    UserEntity findByEmail(String email);

}
