package com.rick.paez.spring.bo;

import java.util.Arrays;
import java.util.List;

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
		logger.info(entrada);
		MensajeSalida salida = new MensajeSalida();
		//Sin filtros, envia la lista completa
		if(entrada.getNumero() == null && 
		   entrada.getTipoPrimario() == null && 
		   entrada.getTipoSecundario() == null) {
			logger.info("Sin filtros");
			salida.setResultado(pokemonDAO.getAllPokemon());
			validaSalidaNula(salida,response);
			
		}
		//filtro por numero de pokemon
		else if(entrada.getNumero() != null &&
				 entrada.getTipoPrimario() == null && 
				 entrada.getTipoSecundario() == null) {
			logger.info("Filtro por numero");
			salida.setResultado(pokemonDAO.getPokemonByNumber(entrada.getNumero()));
			validaSalidaNula(salida,response);
			
		}
		//filtro por tipos de pokemon
		else if(entrada.getNumero() == null &&
				 (entrada.getTipoPrimario() != null || entrada.getTipoSecundario() != null )) {
			logger.info("Filtro por tipo");
			if(validaTipos(entrada.getTipoPrimario(),entrada.getTipoSecundario())) {
				salida.setResultado(pokemonDAO.getPokemonByTypes(entrada.getTipoPrimario(),entrada.getTipoSecundario()));
				validaSalidaNula(salida,response);
			}else {
				salidaErrorTipo(salida,response);
				
			}
		}else {
			logger.info("entrada invalida");
			salida.setResultado(null);
			salidaErrorPeticion(salida,response);
			
		}
		
		return salida;
	}
	private void salidaErrorPeticion(MensajeSalida salida, HttpServletResponse response) {
		salida.setError(Constantes.CVE_ERROR_PETICION);
		salida.setDescripcionError(Constantes.ERROR_DESC_PETICION);
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}
	private void salidaErrorTipo(MensajeSalida salida, HttpServletResponse response) {
		salida.setError(Constantes.CVE_ERROR_TIPO);
		salida.setDescripcionError(Constantes.ERROR_DESC_TIPO);
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}
	private void salidaExitosa(MensajeSalida salida, HttpServletResponse response) {
		salida.setError(Constantes.CVE_ERROR_EXITO);
		salida.setDescripcionError(Constantes.ERROR_DESC_EXITO);
		response.setStatus(HttpServletResponse.SC_OK);
	}
	private void validaSalidaNula(MensajeSalida salida, HttpServletResponse response) {
		if(salida.getResultado() != null) {
			salidaExitosa( salida,  response) ;
		}else {
			salidaNula( salida,  response) ;
		}
		
	}
	private void salidaNula(MensajeSalida salida, HttpServletResponse response) {
		salida.setError(Constantes.CVE_ERROR_NULO);
		salida.setDescripcionError(Constantes.ERROR_DESC_NULO);
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
	private boolean validaTipos(String tipoPrimario, String tipoSecundario) {
		logger.info("into validaTipos");
		List<String> tiposExistentes = Arrays.asList(Constantes.TIPOS_EXISTENTES);
		if(tiposExistentes.contains(tipoPrimario) && tipoSecundario == null) {
			logger.info("Tipo primario valido");
			return true;
		}if(tiposExistentes.contains(tipoSecundario) && tipoPrimario == null) {
			logger.info("Tipo secundario valido");
			return true;
		}else if(tiposExistentes.contains(tipoPrimario) && tiposExistentes.contains(tipoSecundario)) {
			logger.info("Tipo primario y secundario validos");
			return true;
		}
		logger.info("Tipos no validos");
		return false;
	}

}
