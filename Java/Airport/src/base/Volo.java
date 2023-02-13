package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Volo {
	private final String idVolo;
	private CompagnieVolo cVolo;
	private int durataVolo;
	private boolean partenza;
	private LocalDate dataPartenza;
	private int maxDurataritardo;  // implmentazione non effettuata
	private String idAereo;
	private Aereo aereo;
	
	
	private List<Passeggero> listPas = new ArrayList<>();
	private List<Pilota> listPilota = new ArrayList<>();
	private List<Hostess> listaH = new ArrayList<>();
	
	private static int count = 1;
	
	public Volo(CompagnieVolo cVolo, int durataVolo, LocalDate dataPartenza, int maxDurataritardo, Aereo aereo, List<Pilota> listPiloti, List<Hostess> listHostess) throws AirportException {
		super();
		
		if(cVolo == null || durataVolo < 0 || dataPartenza == null || maxDurataritardo < 0 || aereo == null  || listPiloti == null || listHostess == null)
			throw new AirportException("Errore inserimento dati Volo");
		
		this.idVolo = "BG0F"+ count;
		this.cVolo = cVolo;
		this.durataVolo = durataVolo;
		this.partenza = false;
		this.dataPartenza = dataPartenza;
		this.maxDurataritardo = maxDurataritardo;
		this.aereo = aereo;
		this.idAereo = aereo.getIdAereo();
		
		this.listPilota = listPiloti;
		this.listaH = listHostess;
		
		Volo.count++;
		Aereoporto.listaVoli.add(this);
	}
	
	
	public void addPasseggeri(Passeggero...lista) {
		for (Passeggero passeggero : lista) {
			if(!listPas.contains(passeggero) && this.aereo.setNumPosti(1)) {
				System.out.println("Passeggero aggiunto");
				listPas.add(passeggero);
			}
				
		}
	}
	
	
	public void addPasseggeri(List<Passeggero> lista) {
		for (Passeggero passeggero : lista) {
			if(!listPas.contains(passeggero) && this.aereo.setNumPosti(1)) {
				System.out.println("Passeggero aggiunto");
				listPas.add(passeggero);
			}	
		}
	}
	
	
	
	public void removePasseggero(Passeggero p) {
		if(listPas.contains(p))
			System.out.println("Passeggero rimosso");
			listPas.remove(p);
	}
	
	
	public void annullamentoVolo(LocalDate nuovaData) {
		this.dataPartenza = nuovaData;
		this.partenza = false;
		
//		for (Passeggero passeggero : listPas) {
//			if(!passeggero.isAssicurazioneVolo())
//				listPas.remove(passeggero);
//		}
		
		for(Iterator<Passeggero> i = listPas.iterator(); i.hasNext(); ) {
			if(!i.next().isAssicurazioneVolo())
				i.remove();
		}
		
		listPas.forEach(x -> x.setCheckIn(false));
	}
	
	
	public void PartenzaVolo() {
		boolean flag = true;
		for (Passeggero item : listPas) {
			if(item.isCheckIn() == false)
				flag = false;
				break;
		}
		
		boolean flag2 = false;
		for (Passeggero item : listPas) {
			if(item.getRitardo() == true)
				flag2 = true;
				break;
		}
		
		
		if(flag && this.aereo.isRevisione() && flag2 == false) {
			this.partenza = true;
			rettificaOrePQualificati();
			this.aereo.voloCompletato();
			System.out.println("Volo partito");
		}else {
			this.partenza = false;
			System.out.println("Volo fermo, revisione aereo scaduta o passeggero/i senza checkin");
		}
			
		
		
	}
	
	
	private void rettificaOrePQualificati() {
		for (Pilota item : listPilota) {
			item.setOreTotaliVolo(this.durataVolo);
		}
		
		for (Hostess item : listaH) {
			item.setOreTotaliVolo(this.durataVolo);
		}
	}
	
	
	public static void getAllCompagnieDiVolo() {
		for (CompagnieVolo item : CompagnieVolo.values()) {
			System.out.println(item);
		}
	}



	
	public CompagnieVolo getcVolo() {
		return cVolo;
	}

	public int getDurataVolo() {
		return durataVolo;
	}

	public void setDurataVolo(int durataVolo) {
		this.durataVolo = durataVolo;
	}

	public boolean isPartenza() {
		return partenza;
	}

	public LocalDate getDataPartenza() {
		return dataPartenza;
	}

	public String getIdAereo() {
		return idAereo;
	}

	public Aereo getAereo() {
		return aereo;
	}

	public String getIdVolo() {
		return idVolo;
	}
	

	
	
	public void getAllPasseggeri() {
		listPas.forEach(System.out::println);
	}
	
	public void getAllPiloti() {
		listPilota.forEach(System.out::println);
	}
	
	public void getAllHostess() {
		listaH.forEach(System.out::println);
	}
	
	
	public void setAllCheckIn() {
		System.out.println("Check-in effettuato a tutti i passeggeri");
		listPas.forEach(x -> x.setCheckIn(true));
	}
	
	
	@Override
	public String toString() {
		return "Id volo: " + this.idVolo + "Id aereo: " + this.idAereo + "N passeggeri: " + this.listPas.size() + " partenza: " + this.dataPartenza;
	}
}
