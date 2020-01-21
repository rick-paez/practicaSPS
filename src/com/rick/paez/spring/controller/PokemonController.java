package com.rick.paez.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rick.paez.spring.beans.MensajeEntrada;
import com.rick.paez.spring.beans.MensajeSalida;
import com.rick.paez.spring.bo.PokemonBO;

@RestController
public class PokemonController {
	private Logger logger = Logger.getLogger(PokemonController.class);
	@Resource
	PokemonBO pokemonBO;
	
	@RequestMapping(value = "/testXMLJSON",
            method = RequestMethod.GET, produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
	public MensajeSalida filtroPokemon(MensajeEntrada entrada, 
			HttpServletRequest request, HttpServletResponse response) {
		MensajeSalida salida = null;
		logger.info("Into filtroPokemon");
		salida = pokemonBO.procesaEntrada(entrada,response);
		
		return salida;
	}
}
