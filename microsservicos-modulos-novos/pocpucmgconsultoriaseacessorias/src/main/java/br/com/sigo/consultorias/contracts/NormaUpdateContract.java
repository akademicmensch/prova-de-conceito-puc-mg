package br.com.sigo.consultorias.contracts;

public class NormaUpdateContract {
	
	private String nome;
	private String descricao;
	private Long categoria;
	private Long consultoria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public Long getConsultoria() {
		return consultoria;
	}
	public void setConsultoria(Long consultoria) {
		this.consultoria = consultoria;
	}
	
}
