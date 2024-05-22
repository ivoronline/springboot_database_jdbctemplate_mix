package com.ivoronline.springboot_database_jdbctemplate_mix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // MIXED STATEMENTS
  //=========================================================================================================
  public int mixedStatements(String name1, Integer age1, String nameNew, String nameOld) {
    return jdbcTemplate.update(
      " INSERT INTO PERSON (NAME, AGE) VALUES (? , ?) ; "+  //INSERT
      " UPDATE      PERSON SET NAME = ? WHERE name = ?; "   //UPDATE
      , new Object[] { name1, age1, nameNew, nameOld }
    );
  }

}
