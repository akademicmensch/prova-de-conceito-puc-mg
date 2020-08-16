package br.com.sigo.consultorias.contracts;

public class ContratarContract {
	
	private String cnpj;
	private String descricao;
	private String inicioContrato;
	private String fimContrato;
	private String processo;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getInicioContrato() {
		return inicioContrato;
	}
	public void setInicioContrato(String inicioContrato) {
		this.inicioContrato = inicioContrato;
	}
	public String getFimContrato() {
		return fimContrato;
	}
	public void setFimContrato(String fimContrato) {
		this.fimContrato = fimContrato;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	
}
