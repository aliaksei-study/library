package com.beliakaliaksei.library.repository;

import com.beliakaliaksei.library.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
