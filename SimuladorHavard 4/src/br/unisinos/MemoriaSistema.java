package br.unisinos;

public class MemoriaSistema {
	
	private boolean liberado = true;
	
	
	public Instrucao PassaInstruçãoWB(Instrucao x) {
		
		return x;
	}


	public boolean isLiberado() {
		return liberado;
	}


	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}

}
