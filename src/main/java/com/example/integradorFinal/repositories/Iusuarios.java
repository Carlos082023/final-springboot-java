package com.example.integradorFinal.repositories;

import com.example.integradorFinal.entity.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author carlo
 */
public interface Iusuarios extends JpaRepository<Usuarios, Long> {

    @Query("Select u from Usuarios u where u.estado = true")
    List<Usuarios> findAllCustom();

    //Usuarios findByUsuarios(String Usuarios);
    Usuarios getById(long id);
    
    Usuarios findByUser(String user);

    Usuarios findByCorreo(String correo);

}
