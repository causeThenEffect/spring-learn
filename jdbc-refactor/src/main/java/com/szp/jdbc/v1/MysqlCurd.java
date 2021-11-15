package com.szp.jdbc.v1;

import java.sql.*;

/**
 * @Author cause
 * @create 2021/10/26
 */
public class MysqlCurd {

  public static void list() {
    String sql = "SELECT * FROM user_detail";
    Connection conn = null;
//    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    try {
      // 1. 加载注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 2. 获取数据库连接
      conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/page", "root", "root");
      // 3. 创建语句对象
      ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      ps.setFetchSize(Integer.MIN_VALUE);
      // 4. 执行SQL语句
      rs = ps.executeQuery();
      while (rs.next()) {
        long id = rs.getLong("mobile");
        String name = rs.getString("nickname");
        System.out.println(id + "=======>" + name);
      }
      // 5. 释放资源
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (ps != null) {
          ps.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          if (conn != null) {
            conn.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    list();
  }

}
