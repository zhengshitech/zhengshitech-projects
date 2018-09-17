package com.acme.code.gen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.acme.code.gen.config.DataBaseConfig.*;

/**
 * 数据库连接
 *
 * @author H
 */
public class DataBaseUtil {


    public static Connection getConnection() {

        try {
            //添加一个驱动类
            Class.forName(MYSQL_JDBC_DRIVER).newInstance();
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectioin(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
