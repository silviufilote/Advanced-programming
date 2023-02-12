package base;

import java.time.LocalDate;

public class Hostess extends Qualificato {
	
	private final String idHostess;
	private static int count = 1;

	public Hostess(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email, String idCI,
			String idPassaporto, int stipendio, int oreTotaliVolo, Lingue...lingue) throws AirportException {
		super(nome, cognome, dataDiNascita, numeroTelefono, email, idCI, idPassaporto, stipendio, oreTotaliVolo, lingue);
		
		
		this.idHostess = "Hostess:" + count;
		count++;
	}

	public String getIdHostess() {
		return idHostess;
	}
	
	
	@Override
	public String toString() {
		return getNome() + " " + getCognome() + " " + getIdHostess();
	}
	
	
	
	
}
