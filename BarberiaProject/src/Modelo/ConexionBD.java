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
     private static Connection  conn;
 private static final String driver="com.mysql.jdbc.Driver";
   
    /* metodo para conectar a la base de datos*/

 public ConexionBD(){
   conn = null;
 
  try{
     Class.forName(driver);
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/babershop","root","");
     if(conn != null){
         System.out.println("Conexion Establecida..");
     }
     
   } catch (ClassNotFoundException | SQLException e){
       System.out.println("Error al conectar"+e);
   }
 }
 /*Metodo que retorna la coneccion*/
 public Connection getConnection(){
  return conn;
}
  /*Metodo para desconectarnos de la base de datos*/
public void desconectar(){
  conn = null;
  if(conn==null){
      System.out.println("Conexion Terminada");
  }
 }



    
}
