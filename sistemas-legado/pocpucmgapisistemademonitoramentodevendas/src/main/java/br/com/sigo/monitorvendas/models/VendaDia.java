package br.com.sigo.monitorvendas.models;

import java.text.DecimalFormat;
import java.util.Random;

public class VendaDia {
	
	private String tecidoSintetico;
	private String tecidoSemiSintetico;
	private String tecidoNatural;
	
	
	private String quantidadeVendaTecidoSintetico;
	private String quantidadeVendaTecidoSemiSintetico;
	private String quantidadeVendaTecidoNatural;
	
	
	private String valorVendaTecidoSintetico;
	private String valorVendaTecidoSemiSintetico;
	private String valorVendaTecidoNatural;


	public VendaDia() {
		super();
		Random r = new Random();
		DecimalFormat df = new DecimalFormat("#,###.00");
		this.tecidoSintetico = "Tecido Sintetico";
		this.tecidoSemiSintetico = "Tecido Semi Sintetico";
		this.tecidoNatural = "Tecido Natural";
		Double quantidadeVendaTecidoSinteticoVal = 10 + (10000 - 10) * r.nextDouble();
		Double quantidadeVendaTecidoSemiSinteticoVal = 10 + (10000 - 10) * r.nextDouble();
		Double quantidadeVendaTecidoNaturalVal = 10 + (10000 - 10) * r.nextDouble();
		Double valorVendaTecidoSinteticoVal = 10 + (10000 - 10) * r.nextDouble();
		Double valorVendaTecidoSemiSinteticoVal = 10 + (10000 - 10) * r.nextDouble();
		Double valorVendaTecidoNaturalVal = 10 + (10000 - 10) * r.nextDouble();
		this.quantidadeVendaTecidoSintetico = df.format(quantidadeVendaTecidoSinteticoVal) + " metros quadrados";
		this.quantidadeVendaTecidoSemiSintetico = df.format(quantidadeVendaTecidoSemiSinteticoVal) + " metros quadrados";
		this.quantidadeVendaTecidoNatural = df.format(quantidadeVendaTecidoNaturalVal) + " metros quadrados";
		this.valorVendaTecidoSintetico = "R$ " + df.format(valorVendaTecidoSinteticoVal);
		this.valorVendaTecidoSemiSintetico = "R$ " + df.format(valorVendaTecidoSemiSinteticoVal);
		this.valorVendaTecidoNatural = "R$ " + df.format(valorVendaTecidoNaturalVal);
	}

	public String getTecidoSintetico() {
		return tecidoSintetico;
	}
	public void setTecidoSintetico(String tecidoSintetico) {
		this.tecidoSintetico = tecidoSintetico;
	}
	public String getTecidoSemiSintetico() {
		return tecidoSemiSintetico;
	}
	public void setTecidoSemiSintetico(String tecidoSemiSintetico) {
		this.tecidoSemiSintetico = tecidoSemiSintetico;
	}
	public String getTecidoNatural() {
		return tecidoNatural;
	}
	public void setTecidoNatural(String tecidoNatural) {
		this.tecidoNatural = tecidoNatural;
	}
	public String getQuantidadeVendaTecidoSintetico() {
		return quantidadeVendaTecidoSintetico;
	}
	public void setQuantidadeVendaTecidoSintetico(String quantidadeVendaTecidoSintetico) {
		this.quantidadeVendaTecidoSintetico = quantidadeVendaTecidoSintetico;
	}
	public String getQuantidadeVendaTecidoSemiSintetico() {
		return quantidadeVendaTecidoSemiSintetico;
	}
	public void setQuantidadeVendaTecidoSemiSintetico(String quantidadeVendaTecidoSemiSintetico) {
		this.quantidadeVendaTecidoSemiSintetico = quantidadeVendaTecidoSemiSintetico;
	}
	public String getQuantidadeVendaTecidoNatural() {
		return quantidadeVendaTecidoNatural;
	}
	public void setQuantidadeVendaTecidoNatural(String quantidadeVendaTecidoNatural) {
		this.quantidadeVendaTecidoNatural = quantidadeVendaTecidoNatural;
	}
	public String getValorVendaTecidoSintetico() {
		return valorVendaTecidoSintetico;
	}
	public void setValorVendaTecidoSintetico(String valorVendaTecidoSintetico) {
		this.valorVendaTecidoSintetico = valorVendaTecidoSintetico;
	}
	public String getValorVendaTecidoSemiSintetico() {
		return valorVendaTecidoSemiSintetico;
	}
	public void setValorVendaTecidoSemiSintetico(String valorVendaTecidoSemiSintetico) {
		this.valorVendaTecidoSemiSintetico = valorVendaTecidoSemiSintetico;
	}
	public String getValorVendaTecidoNatural() {
		return valorVendaTecidoNatural;
	}
	public void setValorVendaTecidoNatural(String valorVendaTecidoNatural) {
		this.valorVendaTecidoNatural = valorVendaTecidoNatural;
	}
}
