package br.com.enio.zoologico.model;

import java.time.LocalDate;

public class VisitantesModel extends PessoaModel {
	private EnumTipoIngressoModel tipoIngresso;
	
	public EnumTipoIngressoModel getTipoIngresso() {
		return tipoIngresso;
	}
	
	public VisitantesModel(String nome,LocalDate nasc, int tipo, EnumTipoIngressoModel tipoIngresso) {
		super(nome,nasc, tipo);
		this.tipoIngresso=tipoIngresso;
	}
}

