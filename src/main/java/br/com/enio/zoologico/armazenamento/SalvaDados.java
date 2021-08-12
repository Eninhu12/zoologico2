package br.com.enio.zoologico.armazenamento;

import java.util.ArrayList;
import java.util.List;

import br.com.enio.zoologico.model.AnimaisModel;
import br.com.enio.zoologico.model.PessoaModel;

public class SalvaDados {
	public SalvaDados() {
	}
	public static List<PessoaModel>pessoas = new ArrayList<>();
	public static List<AnimaisModel>animais = new ArrayList<>();
	public static List<AnimaisModel>mamiferos = new ArrayList<>();
	public static List<AnimaisModel>repteis = new ArrayList<>();
	public static List<AnimaisModel>aves = new ArrayList<>();
}
