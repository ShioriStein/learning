package com.demop.springcore.dao.impl;

import com.demop.springcore.dao.SimpleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SimpleDAOImpl implements SimpleDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
}
