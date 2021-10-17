package com.nqhtour.api.admin;

import com.nqhtour.dto.InvoiceDTO;
import com.nqhtour.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "InvoiceAPIOfAdmin")
public class InvoiceAPI {
    @Autowired
    IInvoiceService invoiceService;

    @GetMapping("/api/invoice")
    public InvoiceDTO readInvoice(@RequestParam("invoiceId") String invoiceId) {
        InvoiceDTO invoiceDTO = invoiceService.findById(invoiceId);
        return invoiceDTO;
    }

    @PostMapping("/api/invoice")
    public InvoiceDTO createInvoice(@RequestBody InvoiceDTO dto) {
        return invoiceService.save(dto);
    }
}
