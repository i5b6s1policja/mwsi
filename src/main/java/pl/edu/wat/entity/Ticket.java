package pl.edu.wat.entity;

import lombok.Data;
import pl.edu.wat.enums.Offense;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue
    Long id;
    @Column
    Integer penaltyPoints;
    @Column
    Integer amount;
    @Column
    Date date;
    @Column
    Offense offense;
    @ManyToOne
    Driver driver;
    @ManyToOne
    Policeman policeman;
}
