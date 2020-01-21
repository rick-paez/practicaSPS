package com.rick.paez.util;

import java.util.ArrayList;

public class Constantes {
	public static final String RUTA_CSV_POKEMON = "/resources/pokemon.csv";
	
	//CATALOGO DE ERRORES
	public static final String CVE_ERROR_EXITO = "00";
	public static final String ERROR_DESC_EXITO = "EXITO";

	public static final String CVE_ERROR_PETICION = "01";
	public static final String ERROR_DESC_PETICION = "PETICION ERRONEA";

	public static final String[] TIPOS_EXISTENTES = {"ACERO","AGUA","BICHO","DRAGON",
													 "ELECTRICO","FANTASMA","FUEGO",
													 "HADA","HIELO","LUCHA","NORMAL",
													 "HIERBA","PSIQUICO","ROCA","SINIESTRO",
													 "TIERRA","VENENO","VOLADOR"};

	public static final String CVE_ERROR_TIPO = "02";

	public static final String ERROR_DESC_TIPO = "TIPO NO EXISTENTE EN LA TABLA";

	public static final String CVE_ERROR_NULO = "03";

	public static final String ERROR_DESC_NULO = "NO EXISTEN POKEMON CON ESAS CARACTERISTICAS";
}
