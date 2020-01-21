package com.rick.paez.spring.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MensajeEntrada implements Serializable{
	
	private static final long serialVersionUID = -7935537346571795166L;
	@XmlElement(name="numero")
	private Integer numero;
	@XmlElement(name="tipoPrimario")
	private String  tipoPrimario;
	@XmlElement(name="tipoSecundario")
	private String  tipoSecundario;
	public MensajeEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	@Override
	public String toString() {
		return "MensajeEntrada [numero=" + numero + ", tipoPrimario=" + tipoPrimario + ", tipoSecundario="
				+ tipoSecundario + "]";
	}
	
}
