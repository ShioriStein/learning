package com.demop.springcore.controller;

import com.demop.springcore.service.SimpleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class SimpleController {

    final
    SimpleService simpleService;

    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping("/")
    public void simpleExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        simpleService.exportCSV(request, response);
    }

    @GetMapping("/whole")
    public void simpleExportWhjole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        simpleService.exportWholeCSV(request, response);
    }


}
