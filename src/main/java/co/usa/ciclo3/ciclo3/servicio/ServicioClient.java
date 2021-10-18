/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package co.usa.ciclo3.ciclo3.servicio;

import co.usa.ciclo3.ciclo3.modelo.Client;
import co.usa.ciclo3.ciclo3.repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioClient {

    @Autowired
    private RepositorioClient metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int id) {
        return metodosCrud.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Client> evt = metodosCrud.getClient(client.getIdClient());
            if (evt.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> optClient = metodosCrud.getClient(client.getIdClient());
            if (!optClient.isEmpty()) {
                if (client.getName() != null) {
                    optClient.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    optClient.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    optClient.get().setPassword(client.getPassword());
                }
                if (client.getEmail() != null) {
                    optClient.get().setEmail(client.getEmail());
                }
                metodosCrud.save(optClient.get());
                return optClient.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
