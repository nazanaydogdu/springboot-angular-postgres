package com.nazan.repository;

import com.nazan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nazan on 12.01.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
