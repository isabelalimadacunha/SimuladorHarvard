package br.unisinos;

public class Instrucao {

	private String nome;

	private int opcode1;
	private	int opcode2;
	private int opcode3;
	private int opcode2Temporario;
	private int opcode3Temporario;
	private int resultado;
	private boolean calcDesv;

	
	public Instrucao() {
		
	}
	
	//Construtores
	public Instrucao(String nome, int opcode1, int opcode2, int opcode3) {
		this.nome = nome;
		this.opcode1 = opcode1;
		this.opcode2 = opcode2;
		this.opcode3 = opcode3;
		this.calcDesv = false;
	}

	public Instrucao(String nome, int opcode1) {
		this.nome = nome;
		this.opcode1 = opcode1;
		this.calcDesv = false;
		this.resultado = 0;
	}
	
	public Instrucao(String nome) {
		
		this.nome = nome;
		
	}
	
	
	// Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOpcode2Temporario() {
        return opcode2Temporario;
    }

    public void setOpcode2Temporario(int opcode2Temporario) {
        this.opcode2Temporario = opcode2Temporario;
    }

    public int getOpcode3Temporario() {
        return opcode3Temporario;
    }

    public void setOpcode3Temporario(int opcode3Temporario) {
        this.opcode3Temporario = opcode3Temporario;
    }
    public int getOpcode1() {
        return opcode1;
    }

    public void setOpcode1(int opcode1) {
        this.opcode1 = opcode1;
    }
    public int getOpcode2() {
        return opcode2;
    }

    public void setOpcode2(int opcode2) {
        this.opcode2 = opcode2;
    }

    public int getOpcode3() {
        return opcode3;
    }

    public void setOpcode3(int opcode3) {
        this.opcode3 = opcode3;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public boolean isCalcDesv() {
        return calcDesv;
    }

    public void setCalcDesv(boolean calcDesv) {
        this.calcDesv = calcDesv;
    }

	
    //Invalida Instruç
	public void invalidaInstrucao() {
		this.opcode1 = 0;
		this.opcode2 = 0;
		this.opcode3 = 0;
	}

	@Override
	public String toString() {
		return "Instrucao [nome=" + nome + ", opcode1=" + opcode1 + ", opcode2=" + opcode2 + ", opcode3=" + opcode3
				+ "]";
	}

	
}