package br.com.enio.zoologico.model;

import java.math.BigDecimal;

public class AnimaisModel {
	private String especie;
	private BigDecimal peso;
	private BigDecimal tamanho;
	private char sexo;
	private int qtd;
	private Long id;
	private static Long gerador = Long.valueOf(0);
	
	public Long getId() {
		return id;
	}

	public String getEspecie() {
		return especie;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public BigDecimal getTamanho() {
		return tamanho;
	}

	public char getSexo() {
		return sexo;
	}

	public int getQtd() {
		return qtd;
	}

	public AnimaisModel(String especie,BigDecimal peso,BigDecimal tamanho,char sexo,int qtd) {
		this.id=++gerador;
		this.especie=especie;
		this.peso=peso;
		this.tamanho=tamanho;
		this.sexo=sexo;
		this.qtd=qtd;
	}

	public void Alterar(String especie, BigDecimal peso, BigDecimal tamanho, char sexo, int qtd) {
		this.especie=especie;
		this.peso=peso;
		this.tamanho=tamanho;
		this.sexo=sexo;
		this.qtd=qtd;
		
	}

}
