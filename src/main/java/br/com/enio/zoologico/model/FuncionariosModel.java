package br.com.enio.zoologico.model;

import java.time.LocalDate;

public class FuncionariosModel extends PessoaModel{
	private String funcao;
	private char turno;
	public FuncionariosModel(String nome,LocalDate nasc, int tipo, String funcao,char turno) {
		super(nome,nasc, tipo);
		this.funcao=funcao;
		this.turno=turno;
	}
	public char getTurno() {
		return turno;
	}
	public String getFuncao() {
		return funcao;
	}

}
