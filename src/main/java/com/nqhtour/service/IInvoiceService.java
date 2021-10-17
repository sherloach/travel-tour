package com.nqhtour.service;

import com.nqhtour.dto.InvoiceDTO;

public interface IInvoiceService {
    InvoiceDTO findById(String invoiceId);
    InvoiceDTO save(InvoiceDTO dto);
}
