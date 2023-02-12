package base;

public enum Lingue {
	INGLESE("E"), SPAGNOLO("S"), FRANCESE("F"), TEDESCO("T"), ITALIANO("I");
	
	private String iniziale;  
	private Lingue(String iniziale){  
		this.setIniziale(iniziale);  
	}
	
	
	public String getIniziale() {
		return iniziale;
	}
	
	
	private void setIniziale(String iniziale) {
		this.iniziale = iniziale;
	}
	
	
}
