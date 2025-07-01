package com.crud_cliente.crud.controller;

import com.crud_cliente.crud.entity.Cliente;
import com.crud_cliente.crud.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getClientes();
    }

    // Obtener un cliente por su ID (documento)
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getById(@PathVariable String clienteId) {
        return clienteService.getCliente(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<String> createCliente(@RequestBody Cliente cliente) {
        if (clienteService.getCliente(cliente.getDoc()).isPresent()) {
            return ResponseEntity.badRequest().body("El cliente ya existe.");
        }
        clienteService.saveOrUpdate(cliente);
        return ResponseEntity.ok("Cliente creado con éxito.");
    }

    // Actualizar cliente existente
    @PutMapping("/{clienteId}")
    public ResponseEntity<String> updateCliente(@PathVariable String clienteId, @RequestBody Cliente cliente) {
        if (clienteService.getCliente(clienteId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setDoc(clienteId); // Garantiza que el ID coincida
        clienteService.saveOrUpdate(cliente);
        return ResponseEntity.ok("Cliente actualizado con éxito.");
    }

    // Eliminar cliente por ID
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<String> delete(@PathVariable String clienteId) {
        if (clienteService.getCliente(clienteId).isPresent()) {
            clienteService.delete(clienteId);
            return ResponseEntity.ok("Cliente eliminado con éxito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
