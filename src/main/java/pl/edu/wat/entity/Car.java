package pl.edu.wat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import pl.edu.wat.enums.Brand;
import pl.edu.wat.enums.Model;

import javax.persistence.*;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableGenerator(name="tab", initialValue=10000)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    @Column
    String brand;
    @Column
    String model;
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
