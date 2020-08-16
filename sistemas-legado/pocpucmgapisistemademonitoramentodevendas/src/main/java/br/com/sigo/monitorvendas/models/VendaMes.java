package br.com.sigo.monitorvendas.models;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class VendaMes {
	
	private String mesAtual;
	
	private String tecidoSintetico;
	private String tecidoSemiSintetico;
	private String tecidoNatural;
	
	private String quantidadeVendaTecidoSintetico;
	private String quantidadeVendaTecidoSemiSintetico;
	private String quantidadeVendaTecidoNatural;
	
	private String valorVendaTecidoSintetico;
	private String valorVendaTecidoSemiSintetico;
	private String valorVendaTecidoNatural;

	
	public VendaMes() {
		super();
		DecimalFormat df = new DecimalFormat("#,###.00");
		Calendar mesAtualCal;
		mesAtualCal = GregorianCalendar.getInstance();
		int i = mesAtualCal.get(Calendar.MONTH);
		this.mesAtual = obterMesAtual(i);
		Random r = new Random();
		this.tecidoSintetico = "Tecido Sintetico";
		this.tecidoSemiSintetico = "Tecido Semi Sintetico";
		this.tecidoNatural = "Tecido Natural";
		Double quantidadeVendaTecidoSinteticoVal = 100 + (10000 - 100) * r.nextDouble();
		Double quantidadeVendaTecidoSemiSinteticoVal = 100 + (10000 - 100) * r.nextDouble();
		Double quantidadeVendaTecidoNaturalVal = 100 + (10000 - 100) * r.nextDouble();
		Double valorVendaTecidoSinteticoVal = 1000 + (100000 - 1000) * r.nextDouble();
		Double valorVendaTecidoSemiSinteticoVal = 1000 + (100000 - 1000) * r.nextDouble();
		Double valorVendaTecidoNaturalVal = 1000 + (100000 - 1000) * r.nextDouble();
		this.quantidadeVendaTecidoSintetico = df.format(quantidadeVendaTecidoSinteticoVal) + " metros quadrados";
		this.quantidadeVendaTecidoSemiSintetico = df.format(quantidadeVendaTecidoSemiSinteticoVal) + " metros quadrados";
		this.quantidadeVendaTecidoNatural = df.format(quantidadeVendaTecidoNaturalVal) + " metros quadrados";
		this.valorVendaTecidoSintetico = "R$ " + df.format(valorVendaTecidoSinteticoVal);
		this.valorVendaTecidoSemiSintetico = "R$ " + df.format(valorVendaTecidoSemiSinteticoVal);
		this.valorVendaTecidoNatural = "R$ " + df.format(valorVendaTecidoNaturalVal);
	}
	private String obterMesAtual(int i) {
		String retorno = "";
		if(i==0) {
			retorno = "Janeiro";
		}else if(i==1) {
			retorno = "Fevereiro";
		}else if(i==2) {
			retorno = "Marco";
		}else if(i==3) {
			retorno = "Abril";
		}else if(i==4) {
			retorno = "Maio";
		}else if(i==5) {
			retorno = "Junho";
		}else if(i==6) {
			retorno = "Julho";
		}else if(i==7) {
			retorno = "Agosto";
		}else if(i==8) {
			retorno = "Setembro";
		}else if(i==9) {
			retorno = "Outubro";
		}else if(i==10) {
			retorno = "Novembro";
		}else if(i==11) {
			retorno = "Dezembro";
		}
		return retorno;
	}

	public String getMesAtual() {
		return mesAtual;
	}
	public void setMesAtual(String mesAtual) {
		this.mesAtual = mesAtual;
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
