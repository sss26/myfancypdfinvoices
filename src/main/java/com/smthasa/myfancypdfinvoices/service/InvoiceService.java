package com.smthasa.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.smthasa.myfancypdfinvoices.model.Invoice;
import com.smthasa.myfancypdfinvoices.model.User;

@Component
public class InvoiceService {
    private final UserService userService;

    private List<Invoice> invoices = new CopyOnWriteArrayList<Invoice>();

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }

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
