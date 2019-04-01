package com.project.picktoon.repository;

import com.project.picktoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u left join fetch u.roles WHERE u.id = :id")
    public User findUserById(@Param("id")Long id);

    @Query("SElECT u from User u left join fetch u.roles WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    public boolean existsByEmail(String email);
}

//update Passwd
//    @Modifying
//    @Query("UPDATE User u SET u.passwd =:passwd WHERE u.id = :id")
//    public void updatePasswd(@Param("passwd") String passwd, @Param("id") Long id);

