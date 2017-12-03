
import baza.PolicemanRank.Rank;

public class Policeman {
	private final int ID;
	private String name;
	private String surname;
	private final String PESEL;
	private Rank rank;
	
	private static int PLID=1;
	
	public Policeman(String name,String surname,String PESEL, Rank rank){
		ID=PLID;
		PLID++;
		
		this.setName(name);
		this.setSurname(surname);
		this.PESEL=PESEL;
		this.setRank(rank);
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPESEL() {
		return PESEL;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank komisarz) {
		this.rank = komisarz;
	}
	
	public String toString(){
		return "ID: "+ID+"; imie: "+name+"; nazwisko: "+surname+"; PESEL: "+PESEL+"; ranga: "+rank+";";
	}
	
	
}
