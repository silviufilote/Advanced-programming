package base;

import java.util.ArrayList;
import java.util.List;

public final class Aereoporto {

	public static List<Persona> listaPersone = new ArrayList<>();
	public static List<Volo> listaVoli = new ArrayList<>();
	private static Aereoporto a;
	
	public static Aereoporto getAereoporto(){
		if(a == null)
			a = new Aereoporto();
		return a;
	}
	
	
	public void getAllVoli(){
		listaVoli.forEach(System.out::println);
	}
	
	public void getAllPiloti() {
		listaPersone.stream().filter(x -> x instanceof Pilota).forEach(System.out::println);
	}
	
	public void getAllVoliPartiti() {
		listaVoli.stream().filter(x -> x.isPartenza()).forEach(System.out::println);
	}
	
	public void getAllVoliAttesa() {
		listaVoli.stream().filter(x -> x.isPartenza() == false).forEach(System.out::println);
	}
	
	
	public void getCompagnieDiVolo() {
		Volo.getAllCompagnieDiVolo();
	}

}
