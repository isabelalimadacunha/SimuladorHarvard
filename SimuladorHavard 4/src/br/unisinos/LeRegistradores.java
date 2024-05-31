package br.unisinos;

public class LeRegistradores {

	private boolean liberado = true;
	public int registradores[] = new int[32];

	public LeRegistradores() {
	}

	// Organiza os valores das instruções com base na Instrução requerida
	public void OrganizaInstrução(Instrucao x) {
	    if (x != null) {
	        if (x.getNome().equalsIgnoreCase("add") || x.getNome().equalsIgnoreCase("sub")) {
	            x.setOpcode2Temporario(registradores[x.getOpcode2()]);
	            x.setOpcode3Temporario(registradores[x.getOpcode3()]);
	        } else if (x.getNome().equalsIgnoreCase("addi") || x.getNome().equalsIgnoreCase("subi")) {
	            x.setOpcode2Temporario(registradores[x.getOpcode2()]);
	        } else if (x.getNome().equalsIgnoreCase("BeQ")) {
	            x.setOpcode2Temporario(registradores[x.getOpcode2()]);
	            x.setOpcode3Temporario(registradores[x.getOpcode3()]);
	        } 
	    }
	}


	public void ImprimeRegistradores() {
		for (int i = 0; i < registradores.length; i++) {
			System.out.println("R" + i + ": " + registradores[i]);
		}
	}
	
	public boolean isLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}
}