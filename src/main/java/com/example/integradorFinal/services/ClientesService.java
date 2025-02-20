
package com.example.integradorFinal.services;

import com.example.integradorFinal.entity.Clientes;
import java.util.List;
import java.util.Optional;


public interface ClientesService {
    
    public List<Clientes> findAll();

    public List<Clientes> findCustom();

    public Optional<Clientes> findById(long id);

    public Clientes add(Clientes c);

    public Clientes update(Clientes c);

    public Clientes delete(Clientes c);

    public List<Clientes> findAllCustom();
}
