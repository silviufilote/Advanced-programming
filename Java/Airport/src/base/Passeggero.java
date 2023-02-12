package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passeggero extends Persona{
	
	private String idVolo;
	private boolean assicurazioneVolo;
	private int prezzoBiglietto;
	private int totaleVolo;
	private boolean checkIn;
	private LocalDate secondaData;
	
	private static List<Passeggero> listaPasseggeri = new ArrayList<>();
	
	
	public Passeggero(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI, String idPassaporto, Volo volo, boolean assicurazione, CompagnieVolo compagniaVolo) throws AirportException {
		super(nome, cognome, dataDiNascita, numeroTelefono, email, idCI, idPassaporto);
		
		if(volo == null)
			throw new AirportException("Errore inserimento dati passaggero");
		
		this.idVolo = volo.idVolo;
		this.assicurazioneVolo = assicurazione;
		this.prezzoBiglietto = compagniaVolo.getCostoBase();
		this.checkIn = false;
		
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
		
		this.idVolo = volo.idVolo;
		this.assicurazioneVolo = assicurazione;
		this.prezzoBiglietto = compagniaVolo.getCostoBase();
		this.checkIn = false;
		
		if(assicurazione == false)
			this.totaleVolo = compagniaVolo.getCostoBase();
		else
			this.totaleVolo = compagniaVolo.getCostoBase() + 120;
		
		listaPasseggeri.add(this);
		
	}


}
