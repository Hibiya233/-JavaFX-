package com.parkingmanagesystem.parkingmanagesystem.sql;

import java.sql.*;

public class SQLExecutor {
    private Connection conn;

    public SQLExecutor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/停车场收费管理系统?useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 不带参数的查询请求
    public ResultSet query(String sql) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 不带参数的更新请求
    public void update(String sql) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 带参数的查询请求（用于调取存储过程）
    public void callable_query(String sql) {

    }

    // 带参数的更新请求（用于调取存储过程）
    public void callable_update(String sql) {

    }
}
