package com.nqhtour.converter;

import com.nqhtour.dto.ClientTourDTO;
import com.nqhtour.entity.ClientTourEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientTourConverter {
    public ClientTourDTO toDTO(ClientTourEntity clientTourEntity) {
        ClientTourDTO result = new ClientTourDTO();
        result.setTourEntity(clientTourEntity.getTourEntity());
        result.setNuTickets(clientTourEntity.getNuTickets());

        return result;
    }
}
