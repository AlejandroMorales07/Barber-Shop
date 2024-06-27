/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jesus
 */
public class Cliente {
     private int nServicio;
    private int cedulaCliente;
    private String fechaCorte;
    private String descripcionCorte;
    private String costoServicio;

    // Constructores
    public Cliente() {}

    public Cliente(int cedulaCliente, String fechaCorte, String descripcionCorte, String costoServicio) {
        this.cedulaCliente = cedulaCliente;
        this.fechaCorte = fechaCorte;
        this.descripcionCorte = descripcionCorte;
        this.costoServicio = costoServicio;
    }

    // Getters y Setters
    public int getnServicio() {
        return nServicio;
    }

    public void setnServicio(int nServicio) {
        this.nServicio = nServicio;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public String getDescripcionCorte() {
        return descripcionCorte;
    }

    public void setDescripcionCorte(String descripcionCorte) {
        this.descripcionCorte = descripcionCorte;
    }

    public String getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(String costoServicio) {
        this.costoServicio = costoServicio;
}
}