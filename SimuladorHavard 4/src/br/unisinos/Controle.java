package br.unisinos;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Controle {
	
    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	// Inicialização dos Objetos
        LeRegistradores leRegistradores = new LeRegistradores();
        BuscaInstrucao buscaInstrucao = new BuscaInstrucao();
        Executa executa = new Executa();
        MemoriaSistema memoria = new MemoriaSistema();
        Wb wb = new Wb();
        LeArquivo le = new LeArquivo();
        //Leitura do arquivo txt
        List<Instrucao> instrucoes = le
                .lerInstrucoes("/Users/isabelacunha/eclipse-workspace/SimuladorHavard 4/src/br/unisinos/Codigo.txt");
        buscaInstrucao.ColocaNaMemoria(instrucoes);
       
        // Inicialização de Variáveis
        int i = 0;
        Instrucao estagio1 = null;
        Instrucao estagio2 = null;
        Instrucao estagio3 = null;
        Instrucao estagio4 = null;
        Instrucao estagio5 = null;
        Deque<Instrucao> invertedStack = new ArrayDeque<>();
        int cicloDeClock = 0;
      
        while (true) {
        	
        	//Clock
            cicloDeClock++;
            System.out.println("Ciclo de Clock: " + cicloDeClock);

            // Avançar estágios do pipeline
            estagio5 = estagio4;
            estagio4 = estagio3;
            estagio3 = estagio2;
            estagio2 = estagio1;
            estagio1 = null;

            // estagio1 - Busca Instrução
            if (i < buscaInstrucao.getMemoriaInstrucao().size()) {
                estagio1 = buscaInstrucao.AvancaInstrucao(i);
                i++;
            }

            // Adiciona a nova instrução ao stack invertido
            if (estagio1 != null) {
                invertedStack.addFirst(estagio1);
            }

            // Imprimir estágios
            ImprimeEstagios(estagio1, estagio2, estagio3, estagio4, estagio5);

            // estagio2 - Leitura de Registradores
            if (estagio2 != null) {
                leRegistradores.OrganizaInstrução(estagio2);
                if (estagio2.getNome().equalsIgnoreCase("J")) {
                    i = estagio2.getOpcode1();
                }
            }

            // estagio3 - Execução
            if (estagio3 != null) {
                executa.ExecutaInstrucao(estagio3);
                if (estagio3.isCalcDesv()) {
                    i = estagio3.getOpcode1();
                }
            }

            // estagio4 - Acesso à Memória
            if (estagio4 != null) {
                memoria.PassaInstruçãoWB(estagio4);
            }

         // estagio5 - Write Back
            if (estagio5 != null) {
                wb.writeBack(estagio5, leRegistradores, buscaInstrucao);
                Thread.sleep(600);
                
            }
           
            // Imprimir registradores
            leRegistradores.ImprimeRegistradores();
         

        }
    }
    
    //Impressão dos estágios
    private static void ImprimeEstagios(Instrucao estagio1, Instrucao estagio2, Instrucao estagio3, Instrucao estagio4,
            Instrucao estagio5) {
        System.out.println("ESTAGIO DE BUSCA: " + (estagio1 != null ? estagio1.getNome() : "N/A"));
        System.out.println("ESTAGIO DE LEITURA: " + (estagio2 != null ? estagio2.getNome() : "N/A"));
        System.out.println("ESTAGIO DE EXECUÇÃO: " + (estagio3 != null ? estagio3.getNome() : "N/A"));
        System.out.println("ESTAGIO DE MEMORIA: " + (estagio4 != null ? estagio4.getNome() : "N/A"));
        System.out.println("ESTAGIO DE WB: " + (estagio5 != null ? estagio5.getNome() : "N/A"));
    }
}


