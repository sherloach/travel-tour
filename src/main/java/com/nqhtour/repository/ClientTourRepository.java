package com.nqhtour.repository;

import com.nqhtour.entity.ClientEntity;
import com.nqhtour.entity.ClientTourEntity;
import com.nqhtour.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientTourRepository extends JpaRepository<ClientTourEntity, Long>{
    ClientTourEntity findOneByClientEntityAndTourEntity(ClientEntity client, TourEntity tour);
    List<ClientTourEntity> findAllByClientEntity(ClientEntity client);
}
