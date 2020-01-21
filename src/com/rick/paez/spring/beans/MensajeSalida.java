package com.rick.paez.spring.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.rick.paez.dto.PokemonDTO;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"resultado","error","descripcionError"})
public class MensajeSalida implements Serializable {
	
	private static final long serialVersionUID = -2238900148189672621L;
	@XmlElementWrapper(name="resultado")
	@XmlElement(name="pokemon")
	private ArrayList<PokemonDTO> resultado;
	@XmlElement(name="error")
	private String error;
	@XmlElement(name="descripcionError")
	private String descripcionError;
	public MensajeSalida() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<PokemonDTO> getResultado() {
		return resultado;
	}
	public void setResultado(ArrayList<PokemonDTO> resultado) {
		this.resultado = resultado;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	@Override
	public String toString() {
		return "MensajeSalida [resultado=" + resultado + ", error=" + error + ", descripcionError=" + descripcionError
				+ "]";
	}
}
