package co.usa.ciclo3.ciclo3.servicio;

import co.usa.ciclo3.ciclo3.modelo.ContadorClients;
import co.usa.ciclo3.ciclo3.modelo.Reservation;
import co.usa.ciclo3.ciclo3.modelo.StatusReservas;
import co.usa.ciclo3.ciclo3.repositorio.RepositorioReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que define ServicioReservation
 * room
 * @version 1.0
 * @author Patricia Velandia
 */
@Service
public class ServicioReservation {

    @Autowired
    /**
     * Atributo metodosCrud
     */
    private RepositorioReservation metodosCrud;
    /**
     * Metodo list resevation
     * @return metodosCrud
     */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }
    /**
     * Metodo Optional
     * @param id
     * @return reservation
     */
    public Optional<Reservation> getReservation(int id) {
        return metodosCrud.getReservation(id);
    }
    /**
     * Metodo save
     * @param reservation
     * @return reservation
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> evt = metodosCrud.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    /**
     * metodo update
     * @param reservation
     * @return reservation
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> optReservation = metodosCrud.getReservation(reservation.getIdReservation());
            if (!optReservation.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    optReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    optReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    optReservation.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(optReservation.get());
                return optReservation.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    /**
     * metodo delete
     * @param reservationId
     * @return aBoolean
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     public StatusReservas getRepStatusRes(){
        List<Reservation>completed = metodosCrud.ReservationStatus("completed");
        List<Reservation>cancelled = metodosCrud.ReservationStatus("cancelled");        
        return new StatusReservas(completed.size(),cancelled.size());
    }
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        } 
    }
    
    public List<ContadorClients> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        }
    
    

}
