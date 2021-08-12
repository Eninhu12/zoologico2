package br.com.enio.zoologico.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.enio.zoologico.armazenamento.SalvaDados;
import br.com.enio.zoologico.model.EnumTipoIngressoModel;
import br.com.enio.zoologico.model.FuncionariosModel;
import br.com.enio.zoologico.model.PessoaModel;
import br.com.enio.zoologico.model.VisitantesModel;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@GetMapping("/cadastra-funcionario")
	public PessoaModel cadastraPessoa(
		@RequestParam String nome,
		@RequestParam String data,
		@RequestParam String funcao,
		@RequestParam char turno
	) {
		int tipo = 2;
		
		FuncionariosModel funcionario = new FuncionariosModel(nome, LocalDate.parse(data), tipo, funcao, turno);
		SalvaDados.pessoas.add(funcionario);
		
		return funcionario;
	}
	
	@GetMapping("/cadastra-visitante")
	public PessoaModel cadastraVisita(
		@RequestParam String nome,
		@RequestParam String data,
		@RequestParam int ingresso
	) {
		int tipo = 1;
		EnumTipoIngressoModel tipoIngresso;
		
		if(ingresso == 1) {
			tipoIngresso = EnumTipoIngressoModel.NORMAL;
		} else {
			tipoIngresso = EnumTipoIngressoModel.PREMIUM;
		}
		
		VisitantesModel visitante = new VisitantesModel(nome, LocalDate.parse(data), tipo,  tipoIngresso);
		SalvaDados.pessoas.add(visitante);
		
		return visitante;
	}
	
	@GetMapping("/listar")
	public List<PessoaModel> listaPessoa() {
		return SalvaDados.pessoas;
	}
	
	@GetMapping("/excluir")
	public PessoaModel excluirPessoa(
		@RequestParam Long id
	) {
		
		PessoaModel pessoa = SalvaDados.pessoas.stream().filter(p -> id.equals(p.getId())).findFirst().orElse(null);
		if(Objects.nonNull(pessoa)) {
			SalvaDados.pessoas.remove(pessoa);
			return pessoa;
		}
		
		return null;
	}
	
}
