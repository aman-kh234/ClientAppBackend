package com.company.client_chat_service.repository;

import com.company.client_chat_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     @Query(value = "select (count(u) > 0) from users u where u.username = :u",nativeQuery = true)
     boolean existsByUserName(@Param("u") String username);

    @Query(value = "select * from users u where u.username = :u",nativeQuery = true)
    Optional<User> findByUserName(@Param("u") String username);

    @Query(value = "select (count(u) > 0) from users u where u.email = :u",nativeQuery = true)
     boolean existsByEmail(@Param("u") String email);

}
