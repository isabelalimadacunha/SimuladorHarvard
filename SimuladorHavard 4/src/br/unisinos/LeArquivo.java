package br.unisinos;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class LeArquivo {
 
	
	public List<Instrucao> lerInstrucoes(String nomeArquivo) throws IOException{
		List<Instrucao> instrucoes = new ArrayList<>();
		
		try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))){
			String linha;
			
			while ((linha = leitor.readLine()) != null) {
			    String[] componentes = linha.split(" ");
			    int opcode1 = 0;
			    int opcode2 = 0;
			    int opcode3 = 0;
			
			        String nome = componentes[0]; //Apenas adiciona o nome no caso do NOP
			       
			        if (componentes.length >= 2) { // Verifica se a linha tem pelo menos 2 elementos
			            opcode1 = Integer.parseInt(componentes[1]); // Salva o endereço
			        }
			        if(componentes.length >= 3) {// Verifica se a linha tem pelo menos 3 elementos
			        	opcode2 = Integer.parseInt(componentes[2]); // Salva o dado 1
			        }
			        if (componentes.length >= 4) { // Verifica se a linha tem pelo menos 4 elemento
			            opcode3 = Integer.parseInt(componentes[3]); // Salva o dado2
			        }
 
			            
			        
			        Instrucao novaInstrucao = new Instrucao(nome, opcode1, opcode2, opcode3);
			        instrucoes.add(novaInstrucao);
			    }
		
		
		
		
		return instrucoes;
	}
}
	
	public void imprimirInstrucoes(List<Instrucao> instrucoes) {
		
		for (Instrucao instrucao : instrucoes) {
		
                System.out.println("\nInstrução: " + instrucao.getNome());
                System.out.println("\nEndereço: " + instrucao.getOpcode1());
                System.out.println("\nDado1: " + instrucao.getOpcode2());
                System.out.println("\nDado2: " + instrucao.getOpcode3());
                System.out.println("\n");
                
            
            }
        
	}
	
}
