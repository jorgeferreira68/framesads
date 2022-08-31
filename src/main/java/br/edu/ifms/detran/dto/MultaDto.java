package br.edu.ifms.detran.dto;

import java.io.Serializable;

import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.model.Multa;

public class MultaDto implements Serializable {

private static final long serialVersionUID = 1l;
private Integer id;
private String cidade;
private Integer ano;
private Object nome;
private Object placa;
private Object marca;
private Infracao infracao;
private Carro carro;





public MultaDto (Multa obj ) {
	super ();
	this.id = obj.getId();
	this.setNome(obj.getNome());
	this.setMarca(obj.getMarca());
	this.setPlaca(obj.getPlaca());
	
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public int getAno() {
	return ano;
}

public void setAno(int ano) {
	this.ano = ano;
}

public Carro getCarro() {
	return carro;
}

public void setCarro(Carro carro) {
	this.carro = carro;
}

public Infracao getInfracao() {
	return infracao;
}

public void setInfracao(Infracao infracao) {
	this.infracao = infracao;
}

public Object getNome() {
	return nome;
}

public void setNome(Object nome) {
	this.nome = nome;
}

public Object getPlaca() {
	return placa;
}

public void setPlaca(Object placa) {
	this.placa = placa;
}

public Object getMarca() {
	return marca;
}

public void setMarca(Object marca) {
	this.marca = marca;
}

}