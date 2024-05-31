package br.unisinos;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaInstrucao{
	
	private final Lock lock = new ReentrantLock();
	private boolean liberado = true;
	
	List<Instrucao> memoriaInstrucao = new ArrayList<>();
	

	public void ColocaNaMemoria(List<Instrucao> memoria) {
		
		
		memoriaInstrucao = memoria;	
		
		
	}
	

	public Instrucao AvancaInstrucao(int i) { 
		lock.lock();
		try {
	        return memoriaInstrucao.get(i);
	    } finally {
	        lock.unlock();
	    }
	}
	
	public void ImprimeMemoria() {
		
		for (Instrucao instrucao : memoriaInstrucao) {
			System.out.println(instrucao.toString());
		}
		
	}


	public List<Instrucao> getMemoriaInstrucao() {
		return memoriaInstrucao;
	}


	public boolean isLiberado() {
		return liberado;
	}


	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}
	
	 
}


