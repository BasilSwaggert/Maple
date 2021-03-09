package com.CaseStudy.Maple.dao.RegisterAndLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bcj.helpdesk.model.registerandlogin.Login;
import com.bcj.helpdesk.model.registerandlogin.UsStates;
import com.bcj.helpdesk.model.registerandlogin.User;
import com.bcj.helpdesk.model.registerandlogin.UserType;
import java.sql.Connection;
@Repository
public class UserDaoImpl {

    @Autowired
    JdbcTemlpate jdbctemplate;

    @Autowired
    JdbcOperations jdbcOperations;
    Connection connection = null;

    public String saveUser(User user) {

        String query = "insert into user (firstName, lastName, company, email, phone) values (?,?,?,?,?)";

        if (0 != jdbcOperations.update(query, new Object[] {user.getFirstName(), user.getLastName(), user.getCompany(),
            user.getClientEmail(), user.getPhoneNumber()})) {
                String query4 = "select userType from user where firstName = ? && lastName = ?";

        }
    }
}
