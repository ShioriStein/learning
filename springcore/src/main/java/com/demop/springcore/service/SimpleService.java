package com.demop.springcore.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface SimpleService {
    public void exportCSV(HttpServletRequest req, HttpServletResponse res) throws IOException;
    public void exportWholeCSV(HttpServletRequest req, HttpServletResponse res) throws IOException;
}
