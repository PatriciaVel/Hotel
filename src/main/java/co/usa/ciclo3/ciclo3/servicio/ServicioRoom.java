package co.usa.ciclo3.ciclo3.servicio;

import java.util.List;
import java.util.Optional;
import co.usa.ciclo3.ciclo3.modelo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.ciclo3.ciclo3.repositorio.RepositorioRoom;

@Service
public class ServicioRoom {

    @Autowired
    private RepositorioRoom metodosCrud;

    public List<Room> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Room> getRoom(int id) {
        return metodosCrud.getRoom(id);
    }

    public Room save(Room room) {
        if (room.getId() == null) {
            return metodosCrud.save(room);
        } else {
            Optional<Room> evt = metodosCrud.getRoom(room.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(room);
            } else {
                return room;
            }
        }
    }

    public Room update(Room room) {
        if (room.getId() != null) {
            Optional<Room> optRoom = metodosCrud.getRoom(room.getId());
            if (!optRoom.isEmpty()) {
                if (room.getName() != null) {
                    optRoom.get().setName(room.getName());
                }
                if (room.getHotel() != null) {
                    optRoom.get().setHotel(room.getHotel());
                }
                if (room.getStars() != null) {
                    optRoom.get().setStars(room.getStars());
                }
                if (room.getDescription() != null) {
                    optRoom.get().setDescription(room.getDescription());
                }
                if (room.getCategory() != null) {
                    optRoom.get().setCategory(room.getCategory());
                }
                metodosCrud.save(optRoom.get());
                return optRoom.get();
            } else {
                return room;
            }
        } else {
            return room;
        }
    }

    public boolean deleteRoom(int roomId) {
        Boolean aBoolean = getRoom(roomId).map(room -> {
            metodosCrud.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
