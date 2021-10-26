package com.szp.jdbc.v2;

import java.sql.*;
import java.util.List;

/**
 * @Author songzhipeng
 * @create 2021/10/26
 */
public class MysqlCurdV2 {

  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM user_detail limit 100 ";
    try {
      conn = getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      List<UserDetail> list = new UserDetailMapperImpl().query(rs);
      list.stream().forEach(userDetail -> System.out.println(userDetail.getUserId() + "====12312312312===>" + userDetail.getNickname()));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(rs, ps, conn);
    }
  }

  public static Connection getConnection() {
    try {
      // 2. 获取数据库连接
      return DriverManager.getConnection("jdbc:mysql://172.16.9.66:3306/yzc_sit", "visva", "WmaiVisva2018");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  //释放资源
  public static void close(ResultSet rs, Statement st, Connection conn) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
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

}
