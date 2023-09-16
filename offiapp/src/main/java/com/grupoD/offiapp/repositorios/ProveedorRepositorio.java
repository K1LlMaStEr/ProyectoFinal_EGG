/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupoD.offiapp.repositorios;

import com.grupoD.offiapp.Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, String>{
    
     @Query("SELECT p FROM Proveedor p WHERE p.servicio = :servicio")
    public Proveedor buscarPorServicio(@Param("servicio") String servicio);
    @Query("SELECT p FROM Proveedor p WHERE p.id = :id")
    public Proveedor buscarPorid(@Param("id") String id);
        @Query("SELECT p FROM Proveedor p WHERE p.email = :email")
    public Proveedor buscarPorEmail(@Param("email")String email);
    
}

/*@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, String> {
    
    @Query("SELECT n FROM Noticia n WHERE n.titulo = :titulo")
    public List<Noticia> buscarPorTitulo(@Param("titulo") String titulo);
    
    
}*/
