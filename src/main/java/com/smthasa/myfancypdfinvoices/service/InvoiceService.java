package com.smthasa.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.inject.Inject;
import com.smthasa.myfancypdfinvoices.model.Invoice;
import com.smthasa.myfancypdfinvoices.model.User;

public class InvoiceService {
	private final UserService userService;

    private List<Invoice> invoices = new CopyOnWriteArrayList<Invoice>();

    @Inject
    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }


        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }
}
