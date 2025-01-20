/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author admin
 */
public class Profesion {
    private int idProfesion;
    private String nombreProfesion;

    // Constructor vacío
    public Profesion() {
    }

    // Constructor con parámetros
    public Profesion(int idProfesion, String nombreProfesion) {
        this.idProfesion = idProfesion;
        this.nombreProfesion = nombreProfesion;
    }

    // Getters y Setters
    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getNombreProfesion() {
        return nombreProfesion;
    }

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }
}
