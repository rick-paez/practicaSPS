package com.rick.paez.spring.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rick.paez.dto.PokemonDTO;

@Repository("pokemonDAO")
public class PokemonDAO extends AbstractDAO {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public ArrayList<PokemonDTO> getAllPokemon() {
		logger.info("Into getAllPokemon");
		return inicializaLista();
	}

	public ArrayList<PokemonDTO> getPokemonByNumber(Integer numero) {
		logger.info("Into getPokemonByNumber");
		ArrayList<PokemonDTO> origen = inicializaLista();
		ArrayList<PokemonDTO> resultado = new ArrayList<PokemonDTO>();
		
		for(PokemonDTO dto: origen) {
			if(dto.getNumero().equals(numero)) {
				resultado.add(dto);
			}
		}
		if(resultado.size()==0) {
			resultado = null;
		}
		return resultado;
	}

	public ArrayList<PokemonDTO> getPokemonByTypes(String tipoPrimario, String tipoSecundario) {
		logger.info("Into getPokemonByNumber");
		ArrayList<PokemonDTO> origen = inicializaLista();
		ArrayList<PokemonDTO> resultado = new ArrayList<PokemonDTO>();
		
		for(PokemonDTO dto: origen) {
			logger.info(dto);
			logger.info(tipoPrimario);
			logger.info(tipoSecundario);
			if(tipoSecundario==null) {
				if(dto.getTipoPrimario().equals(tipoPrimario)) {
					logger.info("coincide el primario");
					resultado.add(dto);
				}
			}else if(tipoPrimario==null) {
				if(dto.getTipoSecundario() != null && dto.getTipoSecundario().equals(tipoSecundario)) {
					logger.info("coincide el secundario");
					resultado.add(dto);
				}
			}else if(dto.getTipoPrimario().equals(tipoPrimario)) {
				if(dto.getTipoSecundario() != null && dto.getTipoSecundario().equals(tipoSecundario)) {
					logger.info("coincide el primario y secundario");
					resultado.add(dto);
				}
			}
		}
		if(resultado.size()==0) {
			resultado = null;
		}
		
		return resultado;
	}
}
