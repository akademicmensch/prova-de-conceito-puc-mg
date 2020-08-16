package br.com.sigo.processos.industriais.models;

public class ProcessoIndustrial {
	private String id;
	private String nome;
	private String quantidadePessoas;
	private String provisorio;
	private Detalhe detalhe;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQuantidadePessoas() {
		return quantidadePessoas;
	}
	public void setQuantidadePessoas(String quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	public String getProvisorio() {
		return provisorio;
	}
	public void setProvisorio(String provisorio) {
		this.provisorio = provisorio;
	}
	public Detalhe getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(Detalhe detalhe) {
		this.detalhe = detalhe;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
