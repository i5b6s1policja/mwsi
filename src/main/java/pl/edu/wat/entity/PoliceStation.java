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
public class PoliceStation {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String address;
    @Column
    String name;
    @Column
    String nip;
    @OneToMany
    List<Policeman> policemen;
    @OneToMany
    List<PoliceCar> policeCars;
}
