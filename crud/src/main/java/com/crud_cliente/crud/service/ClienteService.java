package com.crud_cliente.crud.service;

import com.crud_cliente.crud.entity.Cliente;
import com.crud_cliente.crud.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los clientes.
 * Se comunica con el repositorio para acceder y manipular los datos de la base de datos.
 */

@Service
public class ClienteService {

    private final ClienteRepositorio clienteRepositorio;

    /**
     * Constructor con inyección de dependencias.
     * @param clienteRepositorio Repositorio para acceso a datos de clientes.
     */
    @Autowired
    public ClienteService(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    /**
     * Obtiene la lista de todos los clientes registrados.
     * @return Lista de objetos Cliente.
     */
    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }

    /**
     * Obtiene un cliente específico por su ID (documento).
     * @param id ID del cliente (documento).
     * @return Optional con el Cliente si existe.
     */
    public Optional<Cliente> getCliente(String id) {
        return clienteRepositorio.findById(id);
    }

    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     * Si el cliente ya existe (según su ID), se actualiza.
     * Si no existe, se crea uno nuevo.
     * @param cliente Objeto Cliente a guardar o actualizar.
     */
    public void saveOrUpdate(Cliente cliente){
        clienteRepositorio.save(cliente);
    }

    /**
     * Elimina un cliente por su ID (documento).
     * @param id ID del cliente a eliminar.
     */
    public void delete (String id){
        clienteRepositorio.deleteById(id);
    }

}
