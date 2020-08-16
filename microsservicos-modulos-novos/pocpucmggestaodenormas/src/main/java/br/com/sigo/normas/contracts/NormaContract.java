package br.com.sigo.normas.contracts;

public class NormaContract {
	
	private String nome;
	private String descricao;
	private Long categoria;
	private Long consultoria;
	private String processo;
	//private byte[] documento;
	
	/*You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'insercao, Norma teste, 0, 1, 0)*/
	//insercao, Norma teste, 0, 1, 0
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
	/*public byte[] getDocumento() {
		return documento;
	}
	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}*/
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
}
