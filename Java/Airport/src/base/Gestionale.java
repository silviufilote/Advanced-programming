package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;





public class Gestionale {
	

	static void stampa(Object...list) {
		for (Object item : list) {
			System.out.println(item);
		}
	}

//	public static void main(String[] args) throws AirportException {
//		LocalDate h1D = LocalDate.of(1988,10,23);
//		List<Qualificato> lista = new ArrayList<>();
//		List<Pilota> listaP = new ArrayList<>();
//		
//		try {
//			Qualificato h1 = new Hostess("Olivia", "Bernulli", h1D, "3423183489", "o.bernulli@gmail.com", "I0345", "AX70786", 1450, 200, Lingue.FRANCESE, Lingue.ITALIANO, Lingue.TEDESCO);
//			Qualificato h2 = new Hostess("Olivia", "Bernulli", h1D, "3406196489", "o.bernulli@gmail.com", "I0488", "AX70346", 2000, 100, Lingue.FRANCESE, Lingue.ITALIANO, Lingue.TEDESCO);
//			lista.add(h1);
//			lista.add(h2);
//			System.out.println(h1.getIdHostess());
//			h1.addLingueParlate(Lingue.SPAGNOLO);
//			h1.addLingueParlate(Lingue.SPAGNOLO);
//			h1.removeLingueParlate(Lingue.TEDESCO);
//			Qualificato.getMaxStipendio(lista);
//			Qualificato.getAll(lista);
//
//			System.out.println("");
//			
//			System.out.println(h1.getEta());
//			System.out.println(h1.linguaMadre());
//			Qualificato.getPersonaConPiuOreDiVolo(lista);
//			
//			System.out.println("");
//			System.out.println("");
//			Qualificato p1 = new Pilota("Luciano", "Gabrieli", h1D, "3406142489", "l.gabrieli@gmail.com", "T098", "GE70786", 2750, 1500, true, false, Lingue.INGLESE, Lingue.TEDESCO);
//			Qualificato p2 = new Pilota("Giuseppe", "Verga", h1D, "3406552489", "g.verga@gmail.com", "F444", "FR799", 2050, 750, false, true, Lingue.INGLESE, Lingue.FRANCESE);
//			lista.add(p1);
//			lista.add(p2);
//			listaP.add((Pilota) p1);
//			listaP.add((Pilota) p2);
//			System.out.println(Pilota.getPilotaEsperto(listaP));
//			Pilota.pilotiConIncidenti(listaP);
//			Pilota.getCopiloti(listaP);
//				
//			
//		}catch(Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//		
//	}
	
	public static void main(String[] args) {
		
		try {
			LocalDate h1D = LocalDate.of(1988,10,23);
			LocalDate p1D = LocalDate.of(1988,10,23);
			LocalDate future = LocalDate.of(2024,10,23);
			LocalDate now = LocalDate.now();
			
			List<Pilota> listaPiloti = new ArrayList<>();
			Qualificato p1 = new Pilota("Luciano", "Gabrieli", h1D, "3406142489", "l.gabrieli@gmail.com", "T098", "GE70786", 2750, 1500, true, false, Lingue.INGLESE, Lingue.TEDESCO);
			Qualificato p2 = new Pilota("Giuseppe", "Verga", h1D, "3406552489", "g.verga@gmail.com", "F444", "FR799", 2050, 750, false, true, Lingue.INGLESE, Lingue.FRANCESE);
			listaPiloti.add((Pilota) p1);
			listaPiloti.add((Pilota) p2);
			
			List<Hostess> listaHostess = new ArrayList<>();
			Qualificato h1 = new Hostess("Olivia", "Bernulli", h1D, "3423183489", "o.bernulli@gmail.com", "I0345", "AX70786", 1450, 200, Lingue.FRANCESE, Lingue.ITALIANO, Lingue.TEDESCO);
			Qualificato h2 = new Hostess("Olivia", "Bernulli", h1D, "3406196489", "o.bernulli@gmail.com", "I0488", "AX70346", 2000, 100, Lingue.FRANCESE, Lingue.ITALIANO, Lingue.TEDESCO);
			listaHostess.add((Hostess) h1);
			listaHostess.add((Hostess) h2);
			
			Aereo a1 = new Aereo("ACX", h1D, 2, false, 20);
			a1.revisoneConclusa();
			System.out.println(a1.getVoliCompletati());
			
			Volo v1 = new Volo(CompagnieVolo.ALITALIA, 2, now, 1 , a1, listaPiloti, listaHostess);
			System.out.println(v1.toString());
			
			Passeggero pas2 = new Passeggero("Martina", "Francia", p1D, "3338973409", "m.fracia@yahoo.it", "F8900", v1, true);	
			pas2.comunicazioneRitardo();
			pas2.comunicazioneRitardo(false);
			List<Passeggero> listP = new ArrayList<>();
			listP.add(pas2);
			v1.addPasseggeri(listP);
			v1.addPasseggeri(pas2);
			v1.addPasseggeri(pas2);
			
			v1.PartenzaVolo();
			
			v1.setAllCheckIn();
			v1.annullamentoVolo(future);
			System.out.println(v1.toString());
			v1.setAllCheckIn();
			v1.PartenzaVolo();
			
			System.out.println(a1.toString() + " ha completato = " + a1.getVoliCompletati());
			System.out.println(p1.getOreTotaliVolo());
			
			Volo.getAllCompagnieDiVolo();
			stampa(pas2.getTotaleVolo());
			// stampa(p1);
			// stampa(h1);
			
			
			Aereoporto.getAereoporto().getAllPiloti();
			// Aereoporto.getAereoporto().getAllVoli();
			// Aereoporto.getAereoporto().getAllVoliPartiti();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
