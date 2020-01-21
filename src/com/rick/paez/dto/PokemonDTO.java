package com.rick.paez.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"numero","nombre","tipoPrimario","tipoSecundario","total","salud","ataque",
					"defensa","ataqueEspecial","defensaEspecial","velocidad"})

public class PokemonDTO implements Serializable{
	
	private static final long serialVersionUID = -5414312993909780515L;
	@XmlElement(name="numero")
	private Integer numero;
	@XmlElement(name="nombre")
	private String  nombre;
	@XmlElement(name="tipoPrimario")
	private String  tipoPrimario;
	@XmlElement(name="tipoSecundario")
	private String  tipoSecundario;
	@XmlElement(name="total")
	private Integer total;
	@XmlElement(name="salud")
	private Integer salud;
	@XmlElement(name="ataque")
	private Integer ataque;
	@XmlElement(name="defensa")
	private Integer defensa;
	@XmlElement(name="ataqueEspecial")
	private Integer ataqueEspecial;
	@XmlElement(name="defensaEspecial")
	private Integer defensaEspecial;
	@XmlElement(name="velocidad")
	private Integer velocidad;
	
	public PokemonDTO() {
		super();
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoPrimario() {
		return tipoPrimario;
	}
	public void setTipoPrimario(String tipoPrimario) {
		this.tipoPrimario = tipoPrimario;
	}
	public String getTipoSecundario() {
		return tipoSecundario;
	}
	public void setTipoSecundario(String tipoSecundario) {
		this.tipoSecundario = tipoSecundario;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSalud() {
		return salud;
	}
	public void setSalud(Integer salud) {
		this.salud = salud;
	}
	public Integer getAtaque() {
		return ataque;
	}
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	public Integer getDefensa() {
		return defensa;
	}
	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}
	public Integer getAtaqueEspecial() {
		return ataqueEspecial;
	}
	public void setAtaqueEspecial(Integer ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}
	public Integer getDefensaEspecial() {
		return defensaEspecial;
	}
	public void setDefensaEspecial(Integer defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}
	public Integer getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}
	@Override
	public String toString() {
		return "PokemonDTO [numero=" + numero + ", nombre=" + nombre + ", tipoPrimario=" + tipoPrimario
				+ ", tipoSecundario=" + tipoSecundario + ", total=" + total + ", salud=" + salud + ", ataque=" + ataque
				+ ", defensa=" + defensa + ", ataqueEspecial=" + ataqueEspecial + ", defensaEspecial=" + defensaEspecial
				+ ", velocidad=" + velocidad + "]";
	}
	
	
}
