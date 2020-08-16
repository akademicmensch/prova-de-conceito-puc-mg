package br.com.sigo.monitorvendas.models;

public class ModelRetorno {
	
	private VendaDia dia;
	private VendaMes mes;
	private VendaAno ano;
	
	public ModelRetorno() {
		super();
		this.dia = new VendaDia();
		this.mes = new VendaMes();
		this.ano = new VendaAno();
	}
	public VendaDia getDia() {
		return dia;
	}
	public void setDia(VendaDia dia) {
		this.dia = dia;
	}
	public VendaMes getMes() {
		return mes;
	}
	public void setMes(VendaMes mes) {
		this.mes = mes;
	}
	public VendaAno getAno() {
		return ano;
	}
	public void setAno(VendaAno ano) {
		this.ano = ano;
	}
	
	

}
