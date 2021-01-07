package com.nqhtour.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nqhtour.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
	ClientEntity findOneByEmail(String email);
}
