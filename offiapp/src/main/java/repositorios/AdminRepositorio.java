
package repositorios;

import Entidades.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gonza
 */
public interface AdminRepositorio extends JpaRepository {
     
    @Query("SELECT a FROM Admin p WHERE a.id = :id")
    public Admin buscarPorid(@Param("id") String id);
        @Query("SELECT a FROM Admin a WHERE a.email = :email")
    public Admin buscarPorEmail(@Param("email")String email);
    
}