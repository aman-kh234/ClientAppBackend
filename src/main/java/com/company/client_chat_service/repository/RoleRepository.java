package com.company.client_chat_service.repository;

import com.company.client_chat_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = "select * from roles u where u.name = :u",nativeQuery = true)
    Optional<Role> findByName(@Param("u") String name);
}
