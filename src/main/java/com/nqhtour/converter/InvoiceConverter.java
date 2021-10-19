package com.nqhtour.converter;

import com.nqhtour.dto.InvoiceDTO;
import com.nqhtour.entity.InvoiceEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceConverter {
    public InvoiceDTO toDTO(InvoiceEntity entity) {
        InvoiceDTO result = new InvoiceDTO();
        result.setInvoiceId(entity.getInvoiceId());
        result.setCreatedDate(entity.getCreatedDate());
        result.setTaxId(entity.getTaxId());
        result.setTotalPrice(entity.getTotalPrice());
        result.setBookingId(entity.getBooking().getId());
        result.setEmployeeId(entity.getEmployee().getId());
        result.setEmployeeName(entity.getEmployee().getName());

        return result;
    }

    public InvoiceEntity toEntity(InvoiceDTO dto) {
        InvoiceEntity result = new InvoiceEntity();
        result.setInvoiceId(dto.getInvoiceId());
        result.setCreatedDate(dto.getCreatedDate());
        result.setTaxId(dto.getTaxId());
        result.setTotalPrice(dto.getTotalPrice());

        return result;
    }
}
