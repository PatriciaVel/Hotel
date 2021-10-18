/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repositorio;

import co.usa.ciclo3.ciclo3.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient {

    @Autowired
    private InterfaceClient crud;

    public List<Client> getAll() {
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getClient(int id) {
        return crud.findById(id);
    }

    public Client save(Client client) {
        return crud.save(client);
    }

    public void delete(Client client) {
        crud.delete(client);
    }
}
