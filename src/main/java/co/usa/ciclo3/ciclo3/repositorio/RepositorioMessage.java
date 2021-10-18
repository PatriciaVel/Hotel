/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repositorio;

import co.usa.ciclo3.ciclo3.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository
public class RepositorioMessage {

    @Autowired
    private InterfaceMessage crud;

    public List<Message> getAll() {
        return (List<Message>) crud.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return crud.findById(id);
    }

    public Message save(Message message) {
        return crud.save(message);
    }

    public void delete(Message message) {
        crud.delete(message);
    }

}
