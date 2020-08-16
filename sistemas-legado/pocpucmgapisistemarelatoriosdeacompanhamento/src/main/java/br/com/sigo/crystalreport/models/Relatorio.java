package br.com.sigo.crystalreport.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Relatorio {
	private String id;
	private String titulo;
	private String data;
	private String conteudo;
	
	public Relatorio() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date a = new Date();
		String format = sdf.format(a);
		this.data = format;
	}
	
	
	public Relatorio(String id) {
		if(id.equalsIgnoreCase("1")) {
			this.titulo = "Relatorio de vendas semestral";this.id = "1";
		}else if(id.equalsIgnoreCase("2")) {
			this.titulo = "Relatorio de vendas bimestral";this.id = "2";
		}else if(id.equalsIgnoreCase("3")) {
			this.titulo = "Relatorio de venda por material anual";this.id = "3";
		}else if(id.equalsIgnoreCase("4")) {
			this.titulo = "Relatorio de compra de insumos trimestral";this.id = "4";
		}else if(id.equalsIgnoreCase("5")) {
			this.titulo = "Relatorio de compra de equipamentos anual";this.id = "5";
		}else if(id.equalsIgnoreCase("6")) {
			this.titulo = "Relatorio gerencial consolidado semanal";this.id = "6";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date a = new Date();
		String format = sdf.format(a);
		this.data = format;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
