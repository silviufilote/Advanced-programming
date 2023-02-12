package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestionale {

	public static void main(String[] args) throws AirportException {
		LocalDate h1D = LocalDate.of(1988,10,23);
		List<Qualificato> lista = new ArrayList<>();
		List<Pilota> listaP = new ArrayList<>();
		
		try {
			Qualificato h1 = new Hostess("Olivia", "Bernulli", h1D, "3423183489", "o.bernulli@gmail.com", "I0345", "AX70786", 1450, 200, Lingue.FRANCESE, Lingue.ITALIANO, Lingue.TEDESCO);
			Qualificato h2 = new Hostess("Olivia", "Bernulli", h1D, "3406196489", "o.bernulli@gmail.com", "I0488", "AX70346", 2000, 100, Lingue.FRANCESE, Lingue.ITALIANO, Lingue.TEDESCO);
			lista.add(h1);
			lista.add(h2);
			System.out.println(h1.getIdHostess());
			h1.addLingueParlate(Lingue.SPAGNOLO);
			h1.addLingueParlate(Lingue.SPAGNOLO);
			h1.removeLingueParlate(Lingue.TEDESCO);
			Qualificato.getMaxStipendio(lista);
			Qualificato.getAll(lista);

			System.out.println("");
			
			System.out.println(h1.getEta());
			System.out.println(h1.linguaMadre());
			Qualificato.getPersonaConPiuOreDiVolo(lista);
			
			System.out.println("");
			System.out.println("");
			Qualificato p1 = new Pilota("Luciano", "Gabrieli", h1D, "3406142489", "l.gabrieli@gmail.com", "T098", "GE70786", 2750, 1500, true, false, Lingue.INGLESE, Lingue.TEDESCO);
			Qualificato p2 = new Pilota("Giuseppe", "Verga", h1D, "3406552489", "g.verga@gmail.com", "F444", "FR799", 2050, 750, false, true, Lingue.INGLESE, Lingue.FRANCESE);
			lista.add(p1);
			lista.add(p2);
			listaP.add((Pilota) p1);
			listaP.add((Pilota) p2);
			System.out.println(Pilota.getPilotaEsperto(listaP));
			Pilota.pilotiConIncidenti(listaP);
			Pilota.getCopiloti(listaP);
				
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

}
