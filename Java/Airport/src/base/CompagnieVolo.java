package base;

public enum CompagnieVolo {
	WIZZAIR(100), RYANAIR(200), EASYJET(300), ALITALIA(100),LUFTHANSA(90);
	
	private int costoBase;
	private CompagnieVolo(int costoBase) {
		this.setCostoBase(costoBase);
	}
	
	
	public int getCostoBase() {
		return costoBase;
	}
	
	
	private void setCostoBase(int costoBase) {
		this.costoBase = costoBase;
	}
	

}
