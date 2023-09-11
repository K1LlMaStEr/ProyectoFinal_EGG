/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hplap
 */
@Entity
public class Calificacion {
    @Id
    @GeneratedValue( generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
      private String Id;
    private int idCalif;
    private int puntuacion;

    public Calificacion() {
    }

    public Calificacion(String Id, int idCalif, int puntuacion) {
        this.Id = Id;
        this.idCalif = idCalif;
        this.puntuacion = puntuacion;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getIdCalif() {
        return idCalif;
    }

    public void setIdCalif(int idCalif) {
        this.idCalif = idCalif;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
}
