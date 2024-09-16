package com.daza.api.servlet.tarealibreria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
    //TODO: Constantes de uso
    private static final String URL = "jdbc:mysql://localhost:3306/libroBD";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    public static Connection getConexion(){
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            return cn;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return cn;
    }

    public static void cerrarConexion(Connection cn) {
        try {
            if (cn!=null && !cn.isClosed()) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
