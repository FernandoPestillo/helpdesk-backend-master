package com.fernando.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Categoria {

	ALIMENTOS("alimentos"),
	INFORMATICA("informática"),
	ELETRODOMESTICO("eletrodomésticos"),
	MOVEIS("móveis"),
	ENTRETENIMENTO("entretenimento"),
	AUTOMOVEIS( "automóveis");


	private final String descricao;


}
