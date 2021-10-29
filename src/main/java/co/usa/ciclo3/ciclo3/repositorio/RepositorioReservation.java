/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repositorio;

import co.usa.ciclo3.ciclo3.modelo.Client;
import co.usa.ciclo3.ciclo3.modelo.ContadorClients;
import co.usa.ciclo3.ciclo3.modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {

    @Autowired
    private InterfaceReservation crud;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return crud.save(reservation);
    }

    public void delete(Reservation reservation) {
        crud.delete(reservation);
    }
    public List<Reservation> ReservationStatus(String status){
        return crud.findAllByStatus(status);
    }
    
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
     
     public List<ContadorClients> getClientesRepositorio(){
         List<ContadorClients> res = new ArrayList<>();
         List<Object[]> report = crud.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClients((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
    
    
    
}
