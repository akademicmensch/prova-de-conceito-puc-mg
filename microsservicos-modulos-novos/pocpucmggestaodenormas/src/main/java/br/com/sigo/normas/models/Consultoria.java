package br.com.sigo.normas.models;

import java.util.Date;

public class Consultoria {

	private Long id;
	private String descricao;
	private Long status;
	private String cnpj;
	private Date inicioContrato;
	private Date fimContrato;
	private String statusDesc;
	private String processo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Date getInicioContrato() {
		return inicioContrato;
	}
	public void setInicioContrato(Date inicioContrato) {
		this.inicioContrato = inicioContrato;
	}
	public Date getFimContrato() {
		return fimContrato;
	}
	public void setFimContrato(Date fimContrato) {
		this.fimContrato = fimContrato;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	
}
