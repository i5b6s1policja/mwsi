package pl.edu.wat.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
@Entity
@Data
public class PoliceCar extends Car{
    @ManyToOne
    PoliceStation policeStation;
}
