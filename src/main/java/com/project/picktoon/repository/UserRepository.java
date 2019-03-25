package com.project.picktoon.repository;

import com.project.picktoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SElECT u from User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    public boolean existsByEmail(String email);
}
