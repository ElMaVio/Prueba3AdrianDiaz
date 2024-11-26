/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Bd.Conexion;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Socio;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SocioController {
    Conexion cx;
    
    public SocioController(){
        cx = new Conexion();
        cx.conectar();
    }
    
    public List<Socio> obtenerSocio(){
        List<Socio> socio = new ArrayList<>();
        try{
            ResultSet rs = cx.EjecutarQuery("SELECT * FROM Socio");
            while (rs.next()) {
                socio.add(new Socio(
                rs.getInt("rut"),
                rs.getString("nombre"),
                rs.getString("fechaNacimiento"),
                rs.getString("direccion"),
                rs.getBoolean("membresia")
                ));
            }
        } catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return socio;
    }
    
    public void AgregarSocio(int rut, String nombre, String fechaNacimiento, String direccion, boolean membresia){
        String query = "INSERT INTO 'Socio'(rut,nombe,fechaNacimiento,direccion,membresia) VALUES (?,?)";
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            st.setInt(1,rut);
            st.setString(2,nombre);
            st.setString(3, fechaNacimiento);
            st.setString(4,direccion);
            st.setBoolean(5,membresia);
            
        } catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
    }
    
    public Socio BuscarSocio (int rut){
        Socio socio = null;
        String query = "SELECT * FROM Libro WHERE rut = " + rut;
        try{
            ResultSet rs = cx.EjecutarQuery(query);
            if (rs.next()) {
                socio = new Socio();
                socio.setRut(rs.getInt("rut"));
                socio.setNombre(rs.getString("nombre"));
                socio.setFechaNacmiento(rs.getString("fechaNacimiento"));
                socio.setDireccion(rs.getString("direccion"));
                socio.setMembresia(rs.getBoolean("membresia"));
            }
        } catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return socio;
    }
    
    public boolean EditarSocio(int rut, String nombre, String fechaNacimiento, String direccion, boolean membresia){
        String query = "UPDATE Socio = '" + nombre +"', fechaNacimiento= " + fechaNacimiento + ", direccion= " + direccion + ", membresia" + membresia + " WHERE rut = " + rut;
        System.out.println(query);
        try{
            Socio socioEncontrado = BuscarSocio(rut);
            if (socioEncontrado != null) {
                Statement st = cx.getConnection().createStatement();
                int filasAfectadas = st.executeUpdate(query);
                System.out.println("Socio modificado");
                
            } else {
                return false;
            }
            
        }catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
    }
    
    public boolean EliminarSocio(int rut, String nombre, String fechaNacimiento, String direccion, boolean membresia){
        String query = "DELETE FROM libro WHERE rut = " + rut;
        try{
            Socio socioEncontrado = BuscarSocio(rut);
            if (socioEncontrado != null) {
                Statement st = cx.getConnection().createStatement();
                int filasAfectadas = st.executeUpdate(query);
                System.out.println("Socio Eliminado");
                
                return filasAfectadas > 0;
            } else {
                return false;
            }
            
        }catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
    }
}
