package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aereo {
	private String idAereo;
	private String modello;
	private LocalDate dataAcquisto;
	private int voliCompletati;
	private boolean revisione;
	private int numPosti;
	
	
	private static List<Aereo> listaA = new ArrayList<>();
	private static int count = 1;
	
	
	public Aereo(String modello, LocalDate dataAcquisto, int voliCompletati, boolean revisione,
			int numPosti) throws AirportException {
		super();
		
		if(modello.isEmpty() || dataAcquisto == null || voliCompletati < 0 || numPosti < 0)
			throw new AirportException("Errore inserimento dati Aereo");
		
		this.idAereo = "AXZ" + count;
		this.modello = modello;
		this.dataAcquisto = dataAcquisto;
		this.voliCompletati = voliCompletati;
		this.revisione = revisione;
		this.numPosti = numPosti;
		
		count++;
		listaA.add(this);
	}
	
	
	public void revisoneConclusa() {
		this.revisione = true;
	}
	
	
	
	
	public String getIdAereo() {
		return idAereo;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public LocalDate getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(LocalDate dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	public int getVoliCompletati() {
		return voliCompletati;
	}
	public boolean isRevisione() {
		return revisione;
	}
	public int getNumPosti() {
		return numPosti;
	}
	public boolean setNumPosti(int num) {
		if(this.numPosti - num < 0)
			return false;
		this.numPosti -= num;
		return true;
	}
	
	
	@Override
	public String toString() {
		return this.idAereo + " " + this.modello;
	}
	
}
