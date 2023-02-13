package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passeggero extends Persona{
	
	private String idVolo;
	private boolean assicurazioneVolo;
	private Volo volo;
	private int prezzoBiglietto;
	private int totaleVolo;
	private boolean checkIn;
	
	private static List<Passeggero> listaPasseggeri = new ArrayList<>();
	private boolean ritardo;
	
	
	public Passeggero(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI, String idPassaporto, Volo volo, boolean assicurazione, CompagnieVolo compagniaVolo) throws AirportException {
		super(nome, cognome, dataDiNascita, numeroTelefono, email, idCI, idPassaporto);
		
		if(volo == null)
			throw new AirportException("Errore inserimento dati passaggero");
		
		this.idVolo = volo.getIdVolo();
		this.volo = volo;
		this.assicurazioneVolo = assicurazione;
		this.prezzoBiglietto = compagniaVolo.getCostoBase();
		this.checkIn = false;
		this.ritardo = false;
		
		if(assicurazione == false)
			this.totaleVolo = compagniaVolo.getCostoBase();
		else
			this.totaleVolo = compagniaVolo.getCostoBase() + 120;
		
		listaPasseggeri.add(this);
		
	}

	public Passeggero(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI, Volo volo, boolean assicurazione, CompagnieVolo compagniaVolo) throws AirportException {
		
		super(nome, cognome, dataDiNascita, numeroTelefono, email, idCI);
		
		if(volo == null)
			throw new AirportException("Errore inserimento dati passaggero");
		
		this.idVolo = volo.getIdVolo();
		this.assicurazioneVolo = assicurazione;
		this.prezzoBiglietto = compagniaVolo.getCostoBase();
		this.ritardo = false;
		this.checkIn = false;
		
		if(assicurazione == false)
			this.totaleVolo = compagniaVolo.getCostoBase();
		else
			this.totaleVolo = compagniaVolo.getCostoBase() + 120;
		
		listaPasseggeri.add(this);
		
	}

	
	
	public void comunicazioneRitardo() {
		this.ritardo = true;
	}
	
	
	
	public void setAllCheckIn() {
		listaPasseggeri.forEach(x -> x.checkIn = true);
	}
	
	

	public String getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(String idVolo) {
		this.idVolo = idVolo;
	}

	public boolean isAssicurazioneVolo() {
		return assicurazioneVolo;
	}

	public boolean getRitardo() {
		return this.ritardo;
	}
	
	public void setAssicurazioneVolo(boolean assicurazioneVolo) {
		this.assicurazioneVolo = assicurazioneVolo;
	}

	public int getTotaleVolo() {
		return totaleVolo;
	}

	public void setTotaleVolo(int totaleVolo) {
		this.totaleVolo = totaleVolo;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}
	
	
}
