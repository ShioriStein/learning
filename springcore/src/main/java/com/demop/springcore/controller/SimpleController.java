package com.demop.springcore.controller;

import com.demop.springcore.beans.ExampleBean;
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

    final ExampleBean exampleBean;

    public SimpleController(SimpleService simpleService, ExampleBean exampleBean) {
        this.simpleService = simpleService; //construction injection
        this.exampleBean = exampleBean;
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
