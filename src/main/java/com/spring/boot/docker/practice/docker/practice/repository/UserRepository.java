package com.spring.boot.docker.practice.docker.practice.repository;

import com.spring.boot.docker.practice.docker.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
