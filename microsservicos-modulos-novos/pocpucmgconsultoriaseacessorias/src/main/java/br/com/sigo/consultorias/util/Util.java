package br.com.sigo.consultorias.util;

public class Util {
	
	public static String[] validaStatusSeparado(String[] statusSeparado) {
		String[] retorno = new String[2];
		if(statusSeparado[0] != null) {
			if(statusSeparado[1] != null) {
				retorno = statusSeparado;
			}
		}
		return retorno;
	}

	public static boolean isThereStatus(String status) {
		boolean retorno = false;
		if(status!=null) {
			if(!status.isEmpty()) {
				retorno = true;
			}
		}
		return retorno;
	}

}
