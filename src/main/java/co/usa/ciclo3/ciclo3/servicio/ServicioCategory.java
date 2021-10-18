/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.servicio;

import co.usa.ciclo3.ciclo3.modelo.Category;
import co.usa.ciclo3.ciclo3.repositorio.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class ServicioCategory {

    @Autowired
    private RepositorioCategory metodosCrud;

    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return metodosCrud.getCategory(id);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Category> evt = metodosCrud.getCategory(categoria.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Category update(Category categoria) {
        if (categoria.getId() != null) {
            Optional<Category> optCategory = metodosCrud.getCategory(categoria.getId());
            if (!optCategory.isEmpty()) {
                if (categoria.getDescription() != null) {
                    optCategory.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName() != null) {
                    optCategory.get().setName(categoria.getName());
                }
                return metodosCrud.save(optCategory.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategory(int categoriaId) {
        Boolean aBoolean = getCategory(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
