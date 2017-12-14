package pl.edu.wat.entity;

import lombok.Data;
import pl.edu.wat.model.PolicemanRank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Daniel Wojtkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */

@Entity
@Data
public class Policeman extends Driver {
	@Column
	PolicemanRank.Rank rank;
	@ManyToOne
	PoliceStation policeStation;
	@OneToMany
	List<Ticket> tickets;
	
	private static int PLID=1;
	
	public String toString(){
		return "ID: "+id+"; imie: "+name+"; nazwisko: "+surname+"; PESEL: "+pesel+"; ranga: "+rank+";";
	}
	
	
}
