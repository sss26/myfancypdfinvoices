package com.smthasa.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smthasa.myfancypdfinvoices.service.InvoiceService;
import com.smthasa.myfancypdfinvoices.service.UserService;

public class Application {

    public static final UserService userService = new UserService();
    public static final InvoiceService invoiceService = new InvoiceService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();

}
