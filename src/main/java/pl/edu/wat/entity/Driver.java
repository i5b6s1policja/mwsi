package pl.edu.wat.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    @Column
    String name;
    @Column
    String surname;
    @Column
    String pesel;
    @Column
    String address;
    @Column
    String phoneNumber;
    @Column
    Integer penaltyPoints;
    @Column
    String drivingLicense;
    @OneToMany
    List<Ticket> tickets;
}
