package com.rick.paez.spring.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.rick.paez.dto.PokemonDTO;
import com.rick.paez.util.Constantes;

public class AbstractDAO {
	private static Logger logger = Logger.getLogger(AbstractDAO.class);
	protected ArrayList<PokemonDTO> inicializaLista(){
		logger.info("Into inicializaLista");
		FileReader fileReader;
		BufferedReader bufferedReader;
		String linea;
		ArrayList<PokemonDTO> listaPokemon = new ArrayList<PokemonDTO>();
		StringTokenizer tokenizer;
		Resource resource = new ClassPathResource(Constantes.RUTA_CSV_POKEMON);
		//String filePath =Thread.currentThread().getContextClassLoader().getResource(Constantes.RUTA_CSV_POKEMON).getFile();
		try {
			fileReader = new FileReader(resource.getFile());
			bufferedReader = new BufferedReader(fileReader);
			
			while((linea = bufferedReader.readLine()) != null) {
				tokenizer = new StringTokenizer(linea,",");
				
				
				if(tokenizer.countTokens() == 11) {
					PokemonDTO pokemon = new PokemonDTO();
					try {
						pokemon.setNumero(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setNombre(tokenizer.nextToken());
						pokemon.setTipoPrimario(tokenizer.nextToken());
						String secundario = tokenizer.nextToken();
						pokemon.setTipoSecundario(secundario.equals(" ")?null:secundario);
						pokemon.setTotal(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setSalud(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setAtaque(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setDefensa(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setAtaqueEspecial(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setDefensaEspecial(Integer.parseInt(tokenizer.nextToken()));
						pokemon.setVelocidad(Integer.parseInt(tokenizer.nextToken()));
						listaPokemon.add(pokemon);
					} catch(NumberFormatException e){
						logger.error("Pokemon Invalido!!! ");
					} catch(Exception e) {
						e.printStackTrace();
						logger.error(e.getMessage());
					}
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			listaPokemon = null;
		}
		return listaPokemon;
	}
	
	public static void main(String[] args) {
		System.out.println("PruebaParser");
		AbstractDAO dao = new AbstractDAO();
		
		System.out.println(Arrays.deepToString(dao.inicializaLista().toArray()));
	}
}
