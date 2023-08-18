
package com.mycompany.systemusuario;

import java.awt.*;
import java.sql.*;

/**
 *
 * @author cf911
 */
public class Conectar {
    static Connection conexion = null;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/sistemaadea";
    
    public Connection conectar(){
        try{
            if (conexion == null){
                Class.forName(driver);
                conexion = DriverManager.getConnection(url,"root", "");
                System.out.println("Conexion exitosa");
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
    
}
