package br.com.lojaonline.util;

public class ConversaoUtil {

	public static Integer extrairApenasNumeroInteiro(String numero){
		String retorno=numero.replaceAll("[^0-9]", "");
		return  Integer.parseInt(retorno);
	}
	
	public static Long extrairApenasNumeroLong(String numero){
		String retorno=numero.replaceAll("[^0-9]", "");
		return  Long.parseLong(retorno);
	}
	
}
