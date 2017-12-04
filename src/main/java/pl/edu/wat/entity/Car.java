package pl.edu.wat.entity;

import lombok.Data;
import pl.edu.wat.enums.Brand;
import pl.edu.wat.enums.Model;

import javax.persistence.*;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Entity
@Data
public class Car {
    @Id
    @GeneratedValue
    Long id;
    @Column
    Brand brand;
    @Column
    Model model;
    @Column
    String vin;
    @Column
    String plateNumber;
    @Column
    String engineNumber;
    @Column
    String bodyNumber;
    @Column
    String insurance;
    @Column
    Boolean stolen;
    @Column
    String inspection;
    @ManyToOne
    Driver driver;
}
