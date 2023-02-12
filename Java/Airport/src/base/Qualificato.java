package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class Qualificato extends Persona {
	
	private List<Lingue> lingueList = new ArrayList<>();
	private boolean libero;
	private int stipendio;
	private int oreTotaliVolo;

	public Qualificato(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI, String idPassaporto, int stipendio, int oreTotaliVolo, Lingue...lingue) throws AirportException {
		super(nome, cognome, dataDiNascita, numeroTelefono, email, idCI, idPassaporto);
		
		if(stipendio < 0 || oreTotaliVolo < 0)
			throw new AirportException("Errore inserimento persona qualificata");
		
		this.libero = false;
		this.stipendio = stipendio;
		this.oreTotaliVolo = oreTotaliVolo;
		
		for (Lingue item : lingue) {
			lingueList.add(item);
		}
		
	}
	
	// Varargs
	public void addLingueParlate(Lingue...lingue) {
		for (Lingue item : lingue) {
			if(!lingueList.contains(item))
				lingueList.add(item);
		}
	}
	
	// Lambda expression
	public void removeLingueParlate(Lingue...lingue) {
		for (Lingue item : lingue) {
			lingueList.removeIf(x -> x == item);
		}
		
		lingueList.forEach(System.out::println);
	}
	
	
	// Iterator
	public void getLingueParlate() {
		for(Iterator<Lingue> it = lingueList.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	
	// Da provare
	public static void getMaxStipendio(List<? extends Qualificato> list) {
		System.out.println(list.stream().max(Comparator.comparing(Qualificato::getStipendio)).get().getStipendio());
	}

	
	public static void getPersonaConPiuOreDiVolo(List<? extends Qualificato> list) {
		Qualificato p = list.get(0);
		for (Qualificato item : list) {
			if(p.getOreTotaliVolo() < item.getOreTotaliVolo())
				p = item;
		}
		System.out.println("Persona con più ore: " + p.toString());
	}
	
	
	public static void getAll(List<? extends Qualificato> list) {
		list.forEach(System.out::println);
	}
	
	
	public String getIdHostess() {
		return "NULL";
	}
	
	
	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public int getOreTotaliVolo() {
		return oreTotaliVolo;
	}

	public void setOreTotaliVolo(int oreTotaliVolo) {
		this.oreTotaliVolo += oreTotaliVolo;
	}
}
