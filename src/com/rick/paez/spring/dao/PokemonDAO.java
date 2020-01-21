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
}
