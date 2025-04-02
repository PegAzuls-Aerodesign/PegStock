package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowingController {

    @Autowired
    private BorrowingService service;


}
