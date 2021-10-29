package co.usa.ciclo3.ciclo3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que define los atributos de una habitacion
 * room
 * @version 1.0
 * @author Patricia Velandia
 */

@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo Integer id
     */
    private Integer id;
    /**
     * Atributo String name
     */
    private String name;
    /**
     * Atributo String hotel
     */
    private String hotel;
    /**
     * Atributo Integer stars
     */
    private Integer stars;
    /**
     * Atributo String description
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryroomfk")
    @JsonIgnoreProperties("rooms")
    /**
     * Atributo Category category
     */
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Atributo List messages
     */
    public List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties("room")
    /**
     * Atributo reservations
     */
    public List<Reservation> reservations;

    /**
     * Metodo getCategory
     * @return category
     */
    public Category getCategory() {
        return category;
    }
    
    /**
     * Metodo setCategory
     * @param category 
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    
    /**
     * Metodo getMessage
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }
    
    /**
     * Metodo setMessages
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    /**
     * Metodo getId
     * @return id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Metodo set
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Metodo getname
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Metodo set
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Metodo gethotel
     * @return hotel
     */
    public String getHotel() {
        return hotel;
    }
    
    /**
     * Metodo set
     * @param hotel 
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    /**
     * Metodo getstars
     * @return stars
     */
    public Integer getStars() {
        return stars;
    }
    
    /**
     * Metodo set
     * @param stars 
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * Metodo getdescription
     * @return description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Metodo set
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Metodo getreservations
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    
    /**
     * Metodo set
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
