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
public class Admin {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombreAdm;
    private int idAdm;
    private String email;

    public Admin() {
    }

    public Admin(String id, String nombreAdm, int idAdm, String email) {
        this.id = id;
        this.nombreAdm = nombreAdm;
        this.idAdm = idAdm;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreAdm() {
        return nombreAdm;
    }

    public void setNombreAdm(String nombreAdm) {
        this.nombreAdm = nombreAdm;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", nombreAdm=" + nombreAdm + ", idAdm=" + idAdm + ", email=" + email + '}';
    }

  
    

}

