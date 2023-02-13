package base;

import java.util.ArrayList;
import java.util.List;

public final class Aereoporto {
	private String callCenter;
	

	public static List<Persona> listaPersone = new ArrayList<>();
	public static List<Volo> listaVoli = new ArrayList<>();
	private static Aereoporto a;
	
	public Aereoporto getAereoporto(){
		if(a == null)
			a = new Aereoporto();
		return a;
	}
	
	
	
	static {
		
	}
}
