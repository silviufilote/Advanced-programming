package base;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Pilota extends Qualificato {
	
	private final String idPilota;
	private static int count = 1;
	private boolean capitano;
	private boolean incidenti;

	public Pilota(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI, String idPassaporto, int stipendio, int oreTotaliVolo, boolean capitano, boolean incidenti, Lingue...lingue)
			throws AirportException {
		super(nome, cognome, dataDiNascita, numeroTelefono, email, idCI, idPassaporto, stipendio, oreTotaliVolo, lingue);
		

		this.idPilota = "Pilota:" + count;
		this.capitano = capitano;
		this.incidenti = incidenti;
		count++;
	}
	
	
	
	public static Pilota getPilotaEsperto(List<Pilota> lista) {
		return lista.stream().filter(x -> x.isCapitano()).max(Comparator.comparing(Pilota::getStipendio)).get();
	}
	
	
	public static void pilotiConIncidenti(List<Pilota> lista) {
		System.out.println("Piloti con incidenti:");
		for (Pilota item : lista) {
			if(item.isIncidenti())
				System.out.println(item);
		}
	}
	
	
	public static void getCopiloti(List<Pilota> lista) {
		System.out.println("Copiloti:");
		for (Pilota item : lista) {
			if(!item.isCapitano())
				System.out.println(item);
		}
	}
	
	
	
	public boolean isCapitano() {
		return capitano;
	}

	

	public void setCapitano(boolean capitano) {
		this.capitano = capitano;
	}



	public boolean isIncidenti() {
		return incidenti;
	}



	public void setIncidenti(boolean incidenti) {
		this.incidenti = incidenti;
	}



	public String getIdPilota() {
		return idPilota;
	}



	@Override
	public String toString() {
		return getNome() + " " + getCognome() + " " + getIdPilota();
	}
	
}
