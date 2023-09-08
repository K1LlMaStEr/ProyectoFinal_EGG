/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProveedorRepositorio extends JpaRepository<Proveedor, String>{
    
     @Query("SELECT p FROM Proveedor p WHERE p.servicioOfrecido = :servicioOfrecido")
    public Proveedor buscarPorServicioOfrecido(@Param("servicioOfrecido") String servicioOfrecido);
    @Query("SELECT p FROM Proveedor p WHERE p.id = :id")
    public Proveedor buscarPorid(@Param("id") String id);
        @Query("SELECT p FROM Proveedor p WHERE p.email = :email")
    public Proveedor buscarPorEmail(@Param("email")String email);
    
}
