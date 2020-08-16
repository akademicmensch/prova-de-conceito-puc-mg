package br.com.sigo.consultorias.models;

public class Norma {
	
	private Long id;
	private String nome;
	private String descricao;
	private Long categoria;
	private Long status;
	private Long consultoria;
	private String processo;
	
	private String categoriaDesc;
	private String statusDesc;
	private String consultoriaDesc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getConsultoria() {
		return consultoria;
	}
	public void setConsultoria(Long consultoria) {
		this.consultoria = consultoria;
	}
	public String getCategoriaDesc() {
		return categoriaDesc;
	}
	public void setCategoriaDesc(String categoriaDesc) {
		this.categoriaDesc = categoriaDesc;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getConsultoriaDesc() {
		return consultoriaDesc;
	}
	public void setConsultoriaDesc(String consultoriaDesc) {
		this.consultoriaDesc = consultoriaDesc;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
}
