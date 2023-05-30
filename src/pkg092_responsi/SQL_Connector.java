/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg092_responsi;
import com.mysql.cj.jdbc.MysqlDataSource;
import  java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Lab Informatika
 */
public class SQL_Connector {
    static Connection con;
    
    public static Connection connection(){
        if(con == null){
            MysqlDataSource db_data = new MysqlDataSource();
            db_data.setDatabaseName("perpustakaan");
            db_data.setUser("root");
            db_data.setPassword("");
            try {
                con = db_data.getConnection();
                System.out.println("Succes Connect");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    
}
