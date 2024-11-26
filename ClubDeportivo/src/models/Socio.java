/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author Cetecom
 */
public class Socio {
    private int rut;
    private String nombre;
    private String fechaNacmiento;
    private String direccion;
    private boolean membresia;

    public Socio() {
    }

    public Socio(int rut, String nombre, String fechaNacmiento, String direccion, boolean membresia) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacmiento = fechaNacmiento;
        this.direccion = direccion;
        this.membresia = membresia;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacmiento() {
        return fechaNacmiento;
    }

    public void setFechaNacmiento(String fechaNacmiento) {
        this.fechaNacmiento = fechaNacmiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isMembresia() {
        return membresia;
    }

    public void setMembresia(boolean membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Socio{" + "rut=" + rut + ", nombre=" + nombre + ", fechaNacmiento=" + fechaNacmiento + ", direccion=" + direccion + ", membresia=" + membresia + '}';
    }

    


} 
