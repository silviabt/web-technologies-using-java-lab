package com.uni.lab9.repository;

import com.uni.lab9.domain.User;
import com.uni.lab9.domain.UserDetails;
import com.uni.lab9.domain.UserType;
import com.uni.lab9.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User save(User user) {
        String saveUsersSql = "INSERT INTO users (username, full_name, user_type, account_created) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(saveUsersSql, user.getUsername(), user.getFullName(), user.getUserType().name(), LocalDateTime.now());

        User savedUser = getUserWith(user.getUsername());
        UserDetails userDetails = user.getUserDetails();

        if (null != userDetails) {
            String saveUserDetailsSql = "INSERT INTO user_details (cnp, age, other_information) VALUES (?, ?, ?)";
            jdbcTemplate.update(saveUserDetailsSql, userDetails.getCnp(), userDetails.getAge(), userDetails.getOtherInformation());

            UserDetails savedUserDetails = getUserDetailsWith(userDetails.getCnp());
            savedUser.setUserDetails(savedUserDetails);

            String saveUserUserDetailsSql = "INSERT INTO users_user_details (users, user_details) VALUES (?, ?)";
            jdbcTemplate.update(saveUserUserDetailsSql, savedUser.getId(), savedUserDetails.getId());
        }
        return savedUser;
    }

    public List<User> getAll() {
        String selectSql = "SELECT * from users";

        RowMapper<User> rowMapper = (resultSet, rowNo) -> User.builder()
                .id(resultSet.getLong("id"))
                .username(resultSet.getString("username"))
                .fullName(resultSet.getString("full_name"))
                .userType(UserType.valueOf(resultSet.getString("user_type")))
                .build();

        return jdbcTemplate.query(selectSql, rowMapper);
    }

    public User get(String username) {
        return getUserWith(username);
    }

    private User getUserWith(String username) {
        String selectSql = "SELECT * from users WHERE users.username = ?";

        RowMapper<User> rowMapper = (resultSet, rowNo) -> User.builder()
                .id(resultSet.getLong("id"))
                .username(resultSet.getString("username"))
                .fullName(resultSet.getString("full_name"))
                .userType(UserType.valueOf(resultSet.getString("user_type")))
                .build();

        List<User> users = jdbcTemplate.query(selectSql, rowMapper, username);

        if (null != users && !users.isEmpty()) {
            return users.get(0);
        }
        throw new EntityNotFoundException(username);
    }

    private UserDetails getUserDetailsWith(String cnp) {
        String selectSql = "SELECT * from user_details WHERE user_details.cnp = ?";

        RowMapper<UserDetails> rowMapper = (resultSet, rowNo) -> UserDetails.builder()
                .id(resultSet.getLong("id"))
                .build();

        List<UserDetails> userDetails = jdbcTemplate.query(selectSql, rowMapper, cnp);

        if (null != userDetails && !userDetails.isEmpty()) {
            return userDetails.get(0);
        }
        throw new EntityNotFoundException(cnp);
    }

}
