/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author usuario
 */
public class DAO{
    
    //private Connection conexion;
    ConexionBD conectar =new ConexionBD();
    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;
    // Métodos CRUD para la tabla persona

    public boolean agregarPersona(Persona persona) {
        String sql = "INSERT INTO persona (cedula_persona, Nombre, Apellido, Telefono, Email) VALUES (?, ?, ?, ?, ?)";
        try {
            conexion = conectar.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, persona.getCedulaPersona());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getTelefono());
            ps.setString(5, persona.getEmail());
            ps.executeUpdate();
            System.out.println("agg");
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return true;
    }

    public List<Persona> Listar() {
        List<Persona> personas = new ArrayList<>();
        System.out.println("pass");
        String sql = "SELECT * FROM persona";
        try {
            conexion = conectar.getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setCedulaPersona(rs.getInt("cedula_persona"));
                persona.setNombre(rs.getString("Nombre"));
                persona.setApellido(rs.getString("Apellido"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setEmail(rs.getString("Email"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        return personas;
    } 

    public boolean actualizarPersona(Persona persona) {
        String sql = "UPDATE persona SET Nombre = ?, Apellido = ?, Telefono = ?, Email = ? WHERE cedula_persona = ?";
        try {
            conexion= conectar.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getTelefono());
            ps.setString(4, persona.getEmail());
            ps.setInt(5, persona.getCedulaPersona());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    public boolean eliminarPersona(int cedulaPersona) {
        String sql = "DELETE FROM persona WHERE cedula_persona = ?";
        try {
            conexion= conectar.getConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cedulaPersona);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }

    // Métodos CRUD para la tabla cliente


    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (cedula_cliente, fechaCorte, descripcionCorte, costoServicio) VALUES (?, ?, ?, ?)";
        try {
            conexion= conectar.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getCedulaCliente());
            ps.setString(2, cliente.getFechaCorte());
            ps.setString(3, cliente.getDescripcionCorte());
            ps.setString(4, cliente.getCostoServicio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
/*
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setCedulaCliente(rs.getInt("cedula_cliente"));
                cliente.setFechaCorte(rs.getString("fechaCorte"));
                cliente.setDescripcionCorte(rs.getString("descripcionCorte"));
                cliente.setCostoServicio(rs.getString("costoServicio"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
*/
    
    public List<Cliente> obtenerHistorialCliente(int cedulaCliente) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE cedula_cliente = ?";
        try {
            conexion= conectar.getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, cedulaCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setnServicio(rs.getInt("n_servicio"));
                cliente.setCedulaCliente(rs.getInt("cedula_cliente"));
                cliente.setFechaCorte(rs.getString("fechaCorte"));
                cliente.setDescripcionCorte(rs.getString("descripcionCorte"));
                cliente.setCostoServicio(rs.getString("costoServicio"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
/*
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET cedula_cliente = ?, fechaCorte = ?, descripcionCorte = ?, costoServicio = ? WHERE id_cliente = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getCedulaCliente());
            ps.setString(2, cliente.getFechaCorte());
            ps.setString(3, cliente.getDescripcionCorte());
            ps.setString(4, cliente.getCostoServicio());
            ps.setInt(5, cliente.getIdCliente());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
*/
    public boolean eliminarCliente(int cedulaCliente) {
        String sqlPersona = "DELETE FROM persona WHERE cedula_persona = ?";
        String sqlCliente = "DELETE FROM cliente WHERE cedula_cliente = ?";
        try {
            conexion= conectar.getConexion();
            conexion.setAutoCommit(false);

            
            PreparedStatement psPersona = conexion.prepareStatement(sqlPersona);
            psPersona.setInt(1, cedulaCliente);
            psPersona.executeUpdate();

            PreparedStatement psCliente = conexion.prepareStatement(sqlCliente);
            psCliente.setInt(1, cedulaCliente);
            psCliente.executeUpdate();

            conexion.commit();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                conexion.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}


