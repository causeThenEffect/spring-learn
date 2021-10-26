package com.szp.jdbc.v1;

import java.sql.*;

/**
 * @Author songzhipeng
 * @create 2021/10/26
 */
public class MysqlCurd {

  public static void list() {
    String sql = "SELECT * FROM user_detail limit 100 ";
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    try {
      // 1. 加载注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 2. 获取数据库连接
      conn = DriverManager.getConnection("jdbc:mysql://172.16.9.66:3306/yzc_sit", "visva", "WmaiVisva2018");
      // 3. 创建语句对象
      ps = conn.prepareStatement(sql);
      // 4. 执行SQL语句
      rs = ps.executeQuery();
      while (rs.next()) {
        long id = rs.getLong("user_id");
        String name = rs.getString("nickname");
        System.out.println(id + "=======>" + name);
      }
      // 5. 释放资源
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (st != null) {
          st.close();
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
