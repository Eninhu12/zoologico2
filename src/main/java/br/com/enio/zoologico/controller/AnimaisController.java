package br.com.enio.zoologico.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.enio.zoologico.armazenamento.SalvaDados;
import br.com.enio.zoologico.model.AnimaisModel;
import br.com.enio.zoologico.model.AvesModel;
import br.com.enio.zoologico.model.MamiferosModel;
import br.com.enio.zoologico.model.RepteisModel;
@RestController
@RequestMapping("/animal")
public class AnimaisController {
	@GetMapping("/cadastrar-mamiferos")
	public AnimaisModel CadastrarMamiferos(
			@RequestParam String especie,
			@RequestParam BigDecimal peso,
			@RequestParam BigDecimal tamanho,
			@RequestParam int qtd,
			@RequestParam char sexo
			) {
		MamiferosModel animal = new MamiferosModel(especie,peso,tamanho,sexo,qtd);
		SalvaDados.animais.add(animal);
		SalvaDados.mamiferos.add(animal);
		return animal;
	}
	@GetMapping("/cadastrar-aves")
	public AnimaisModel CadastrarAves(
			@RequestParam String especie,
			@RequestParam BigDecimal peso,
			@RequestParam BigDecimal tamanho,
			@RequestParam int qtd,
			@RequestParam char sexo
			) {
		AvesModel animal = new AvesModel(especie,peso,tamanho,sexo,qtd);
		SalvaDados.animais.add(animal);
		SalvaDados.aves.add(animal);
		return animal;
	}
	@GetMapping("/cadastrar-repteis")
	public AnimaisModel CadastrarRepteis(
			@RequestParam String especie,
			@RequestParam BigDecimal peso,
			@RequestParam BigDecimal tamanho,
			@RequestParam int qtd,
			@RequestParam char sexo
			) {
		RepteisModel animal = new RepteisModel(especie,peso,tamanho,sexo,qtd);
		SalvaDados.animais.add(animal);
		SalvaDados.repteis.add(animal);
		return animal;
	}
	@GetMapping("/listar")
	public List<AnimaisModel> Listar(
			@RequestParam String classe) {
		if("animais".equals(classe)) {
			return SalvaDados.animais;
		}
		else if ("mamiferos".equals(classe)) {
			return SalvaDados.mamiferos;
		}
		else if ("repteis".equals(classe)) {
			return SalvaDados.repteis;
		}
		else if ("aves".equals(classe)) {
			return SalvaDados.aves;
		}
		return null;
	}
	@GetMapping("/excluir")
	public AnimaisModel Excluir(
			@RequestParam Long id
			) {
		AnimaisModel animal = SalvaDados.animais.stream()
				.filter(p -> id.equals(p.getId()))
				.findFirst()
				.orElse(null);

		if (Objects.nonNull(animal)) {
			SalvaDados.animais.remove(animal);
			return animal;
		}
		return null;
	}
	@GetMapping("/alterar")
	public AnimaisModel AlterarProduto(
			@RequestParam Long id,
			@RequestParam String especie,
			@RequestParam BigDecimal peso,
			@RequestParam BigDecimal tamanho,
			@RequestParam char sexo,
			@RequestParam int qtd
			) 
	{
		for (AnimaisModel animal : SalvaDados.animais) {
			if (id.equals(animal.getId())) {
				animal.Alterar(especie, peso,tamanho,sexo,qtd);
				return animal;
			}
		}
    	return null;
    }
}
