/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repositorio;

import co.usa.ciclo3.ciclo3.modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository
public class RepositorioCategory {

    @Autowired
    private InterfaceCategory crud;

    public List<Category> getAll() {
        return (List<Category>) crud.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }

    public Category save(Category categoria) {
        return crud.save(categoria);
    }

    public void delete(Category categoria) {
        crud.delete(categoria);
    }

}
