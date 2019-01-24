package com.spring.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int insert(User user) {
        String sql = "insert into T_Users(id,name,age) values(null,?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getAge());
    }
    public User selectById(Long id) {
        String sql = "select * from T_Users where id=?";
        Object[] params = { id };
        List<User> userList = jdbcTemplate.query(sql, params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        if (userList!=null&&userList.size() > 0) {
            return userList.get(0);//有多个对象的时候取出第一个对象
        } 
        return null;
    }

}
