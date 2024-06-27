/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
   
    Connection con = null;
 //private static final String driver="com.mysql.jdbc.Driver";
   
    /* metodo para conectar a la base de datos*/

 public Connection getConexion(){
   
 
  try{
     Class.forName("com.mysql.jdbc.Driver");
     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/barber","root","");
     if(con != null){
         System.out.println("Conexion Establecida..");
     }
     
   } catch (ClassNotFoundException | SQLException e){
       System.out.println("Error al conectar"+e);
   }
 
  return con;
 
 }  
}

