/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repositorio;

import co.usa.ciclo3.ciclo3.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author escal
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer>{
    
}
