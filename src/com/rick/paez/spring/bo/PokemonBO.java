package com.rick.paez.spring.bo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.rick.paez.spring.beans.MensajeEntrada;
import com.rick.paez.spring.beans.MensajeSalida;
import com.rick.paez.spring.dao.PokemonDAO;
import com.rick.paez.util.Constantes;
@Service("pokemonBO")
public class PokemonBO {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@Resource
	PokemonDAO pokemonDAO;
	public MensajeSalida procesaEntrada(MensajeEntrada entrada, HttpServletResponse response) {
		logger.info("Into procesaEntrada");
		MensajeSalida salida = new MensajeSalida();
		salida.setResultado(pokemonDAO.getAllPokemon());
		salida.setError(Constantes.CVE_ERROR_EXITO);
		salida.setDescripcionError(Constantes.ERROR_DESC_EXITO);
		
		return salida;
	}

}
