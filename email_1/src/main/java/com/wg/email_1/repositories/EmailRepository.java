package com.wg.email_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wg.email_1.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, String> {

}
