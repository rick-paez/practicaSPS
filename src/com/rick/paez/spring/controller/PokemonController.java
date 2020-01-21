package com.rick.paez.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rick.paez.spring.beans.MensajeEntrada;
import com.rick.paez.spring.beans.MensajeSalida;
import com.rick.paez.spring.bo.PokemonBO;

@RestController
/**
 * Clase principal del controlador de 
 * Servicios
 * @author Ricardo Paez
 *
 */
public class PokemonController {
	private Logger logger = Logger.getLogger(PokemonController.class);
	@Resource
	PokemonBO pokemonBO;
	/**
	 * Metodo que expone el servicio de busqueda de pokemon 
	 * en la URL /api/sps/helloworld/v1
	 * @param entrada
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/api/sps/helloworld/v1",
            method = RequestMethod.POST, 
            consumes = {
            		MediaType.APPLICATION_JSON_VALUE,
            		MediaType.APPLICATION_XML_VALUE
            },
            produces = {
            		MediaType.APPLICATION_JSON_VALUE,
            		MediaType.APPLICATION_XML_VALUE
                     })
	public MensajeSalida filtroPokemon(
			@RequestBody MensajeEntrada entrada, 
			HttpServletRequest request, HttpServletResponse response) {
		MensajeSalida salida = null;
		logger.info("Into filtroPokemon");
		salida = pokemonBO.procesaEntrada(entrada,response);
		
		return salida;
	}
}
