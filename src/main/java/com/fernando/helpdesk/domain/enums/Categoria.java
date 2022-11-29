package com.fernando.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Categoria {

	ALIMENTOS(0, "ALIMENTOS"),
	INFORMATICA(1, "INFORMATICA"),
	ELETRODOMESTICO(2, "ELETRODOMESTICO"),
	MOVEIS(3, "MOVEIS"),
	ENTRETENIMENTO(4, "ENTRETENIMENTO"),
	AUTOMOVEIS(5, "AUTOMOVEIS");

	private  final Integer codigo;
	private final String descricao;

}
