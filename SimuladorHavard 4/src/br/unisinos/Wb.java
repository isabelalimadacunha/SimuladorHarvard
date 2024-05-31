package br.unisinos;

public class Wb {
    private boolean liberado;

    public void writeBack(Instrucao x, LeRegistradores leRegistradores, BuscaInstrucao buscaInstrucao) {
        if (x != null) {
            if (x.getNome().equalsIgnoreCase("add") || x.getNome().equalsIgnoreCase("sub") || 
                x.getNome().equalsIgnoreCase("addi") || x.getNome().equalsIgnoreCase("subi")) {
                
                int destino = x.getOpcode1();
                int resultado = x.getResultado();
                leRegistradores.registradores[destino] = resultado;
            }
        }
    }
    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }
}
