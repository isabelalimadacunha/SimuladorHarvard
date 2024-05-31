 package br.unisinos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Executa {
    private final Lock lock = new ReentrantLock();
    private boolean liberado = true;
    
    public void ExecutaInstrucao(Instrucao x) {
        lock.lock();
        try {
            if (x != null) { // Verifica se x is não é null
                if (!x.getNome().equalsIgnoreCase("NOP")) { // Verifica se a instrução não é um NOP
                	// Executa a operação correspondente à instrução
                	if (x.getNome().equalsIgnoreCase("add")) {
                        x.setResultado(x.getOpcode2Temporario() + x.getOpcode3Temporario());
                    } else if (x.getNome().equalsIgnoreCase("sub")) {
                        x.setResultado(x.getOpcode2Temporario() - x.getOpcode3Temporario());
                    } else if (x.getNome().equalsIgnoreCase("addi")) {
                        x.setResultado(x.getOpcode2() + x.getOpcode3());
                    } else if (x.getNome().equalsIgnoreCase("subi")) {
                        x.setResultado(x.getOpcode2() - x.getOpcode3());
                    } else if (x.getNome().equalsIgnoreCase("BeQ")) {
                        if (x.getOpcode2Temporario() == x.getOpcode3Temporario()) {
                            x.setCalcDesv(true);
                        }
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }
}

