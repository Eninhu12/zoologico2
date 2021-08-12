package br.com.enio.zoologico.model;

import java.time.LocalDate;

public class PessoaModel {
	private String nome;
	private LocalDate nasc;
	private Long id;
	private EnumTipoPessoaModel tipo;
	private static Long gerador = Long.valueOf(0);
	
	public String getNome() {
		return nome;
	}
	public LocalDate getNasc() {
		return nasc;
	}
	public PessoaModel(String nome,LocalDate nasc, int tipo) {
		this.id=++gerador;
		this.nome=nome;
		this.nasc=nasc;
		this.tipo= retornaTipo(tipo);
	}
	
	public EnumTipoPessoaModel getTipo() {
		return tipo;
	}
	
	public Long getId() {
		return id;
	}
	
	private EnumTipoPessoaModel retornaTipo(int tipo) {
		if(tipo == 1) {
			return EnumTipoPessoaModel.VISITANTE;
		} else {
			return EnumTipoPessoaModel.FUNCIONARIO;
		}
	}
}
