import lombok.Data;

/**
 * Created by Daniel Wojtkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */

@Entity
@Data
public class Policeman extends Driver {
	@Id
   	 @GeneratedValue
    	Long id;
	@Column
	String name;
	@Column
	String surname;
	@Column
	String PESEL;
	@OneToMany
	Rank rank;
	@ManyToOne
    	PoliceStation policeStation;
	@OneToMany
    	List<Ticket> tickets;
	
	private static int PLID=1;
	
	public String toString(){
		return "ID: "+id+"; imie: "+name+"; nazwisko: "+surname+"; PESEL: "+PESEL+"; ranga: "+rank+";";
	}
	
	
}
