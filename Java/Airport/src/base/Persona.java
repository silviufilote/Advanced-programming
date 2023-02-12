package base;



import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public abstract class Persona {
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String numeroTelefono;
	private String email;
	private final String idCI;
	private final String idPassaporto;
	
		
	public Lingue linguaMadre;
	private static List<String> listaPassaporti = new ArrayList<>();
	private static List<String> listaCartaId = new ArrayList<>();
	private static int countNullPass = 1;
	
	public Persona(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI) throws AirportException {
		
		this(nome, cognome, dataDiNascita, numeroTelefono, email, idCI, "NULL"+countNullPass);
		countNullPass++;
	}
	
	
	public Persona(String nome, String cognome, LocalDate dataDiNascita, String numeroTelefono, String email,
			String idCI, String idPassaporto ) throws AirportException {
		super();
		
		if(nome.isEmpty() || cognome.isEmpty() || dataDiNascita.toString().isEmpty() || numeroTelefono.length() != 10 ||
				email.isEmpty() || idCI.isEmpty() || idPassaporto.isEmpty()) 
			throw new AirportException("Problemi registrazione");
		
		
		if(!checkIdCI(idCI))
			throw new AirportException("Problemi codice carta d'identità");
		
		if(listaCartaId.contains(idCI))
			throw new AirportException("Carta d'identità già presente nei nostri sistemi");
		
		if(listaPassaporti.contains(idPassaporto))
			throw new AirportException("Passaporto già presente nei nostri sistemi");
		
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroTelefono = numeroTelefono;
		this.email = email;
		this.idCI = idCI;
		this.idPassaporto = idPassaporto;
		
		getLingueMadre();
		
		listaPassaporti.add(idPassaporto);
		listaCartaId.add(idCI);
	}
	
	
	public int getEta() {
		return Period.between(
				this.dataDiNascita,
                LocalDate.now()
            ).getYears();
	}
	
	private void getLingueMadre() {
		switch (this.idCI.charAt(0)){
		case 'E':
			this.linguaMadre = Lingue.INGLESE;
		    break;
		case 'S':
			this.linguaMadre = Lingue.SPAGNOLO;
		    break;
		case 'F':
			this.linguaMadre = Lingue.FRANCESE;
		    break;    
		case 'T':
			this.linguaMadre = Lingue.TEDESCO;
		    break;
		case 'I':
			this.linguaMadre = Lingue.ITALIANO;
		    break; 
		
		default:
			throw new IllegalArgumentException("Errore valore inziale carta identità: " + this.idCI.charAt(0));
		}
	}
	
	
	private static boolean checkIdCI(String idCI) {
		boolean flag = false;
		for(Lingue l : Lingue.values())
			if(idCI.startsWith(l.getIniziale()))
				flag = true;
		return flag;
	}
	
	
	// Getter and Setter

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	public String getNumeroTelefono() {
		return numeroTelefono;
	}


	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIdPassaporto() {
		return idPassaporto;
	}
	
	public String linguaMadre() {
		return linguaMadre.toString();
	}
	
}
