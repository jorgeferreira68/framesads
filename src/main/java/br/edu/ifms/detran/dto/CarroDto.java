package br.edu.ifms.detran.dto;

import java.io.Serializable;

import br.edu.ifms.detran.model.Carro;

public class CarroDto implements Serializable {

private static final long serialVersionUID = 1l;
private String nome;
private Integer id;
private String marca;
private String placa;

public CarroDto (Carro obj ) {
	super ();
	this.id = obj.getId();
	this.nome = obj.getNome();
	this.marca = obj.getMarca();
	this.placa = obj.getPlaca();
	
}
public Integer getId() {
	return id;
}

public void setId (Integer id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome (String nome) {
	this.nome = nome;
}

public String getMarca() {
	return marca;
}

public void setmarca (String marca) {
	this.marca = marca;
}

public String getPlaca() {
	return placa;
}

public void setPlaca (String placa) {
	this.placa = placa;
}

}
