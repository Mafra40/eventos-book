package br.com.eventosbook.util;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class BibliotecaFuncao {

	public static Calendar getDataAtual() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		return cal;
	}
	
	/**Retorna data e hora.
	 * 
	 * @return
	 */
	public static Date getDataHoraAtual() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		
		return cal.getTime();
	}

	public static Calendar inserirData(int pDia, int pMes, int pAno){
		Calendar retorno = Calendar.getInstance();
		retorno.set(pAno, pMes, pDia);
		return retorno;
	}
	
	/**Retorna uma String de data do tipo dd/MM/yyyy para yyyy/MM/dd
	 * 
	 * @param pData
	 * @return
	 */
	public static Calendar getStringComoData(String pData){
		SimpleDateFormat formatador = null;
		Calendar novaData = Calendar.getInstance();
		
		
		formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			novaData.setTime(formatador.parse(pData));
			
		} catch (Exception e) {
		}
		return novaData;
		
	}
	
	/**
	 * Inserir a data no formato: dd/MM/yyyyy
	 * 
	 * @param pData
	 * @return
	 * @throws ParseException 
	 */
	public static Calendar formatarData(String pData, String pCampoFormatador) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat(pCampoFormatador);
		Calendar retorno = Calendar.getInstance();
		retorno.setTime(sdf.parse(pData));
		
		return retorno;
	}
	
	public static Date formatarHora(String pHora, String pCampoFormatador) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(pCampoFormatador);
		
		Date retorno= new Date();
		retorno = sdf.parse(pHora);
		
		return retorno;
	}
	
	/**Retorna uma data assim : 11 de maio de 2014
	 * 
	 * @param pData
	 * @return
	 */
	public static String getDataComoString(Date pData){
		SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy");
		String data = sdf.format(pData);
        data = data.replace(" ", " de ");
		return data;
	}
	
	public static String criptografarPalavra(String pPalavra){
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest criptSenha = MessageDigest.getInstance("SHA-256");
			byte messageHash[] = criptSenha.digest(pPalavra.getBytes("UTF-8"));
			
			
			for (byte b : messageHash) {
				sb.append(String.format("%02X", 0xFF & b));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	
	/**Função que gera código alfa numerico.
	 * 
	 * @param pQtdCaracteres Quantidade de casas que deseja gerar
	 * @return
	 */
	public static String gerarCodigoAlfaNumerico(int pQtdCaracteres){
		
		Random rd = new Random();
		
		char[] arrayChar = new char[pQtdCaracteres];
		
		for (int i = 0; i < arrayChar.length; i++) {
			arrayChar[i] = toChar(rd.nextInt(62));
		}
		
		return new String(arrayChar);
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> array = new ArrayList<>(1);
		array.add(1001);
		array.add(1002);
		//System.out.println(array.get(array.size()));
		
//		String teste = criptografarPalavra("12345");
//		System.out.println(teste);
//		System.out.println("oi");
	}
	
	
	private static char toChar(int index) {  
        if (index < 10)  
            return (char)(index + 48); //os chars 48 a 57 representam [0 - 9]  
        else if (index < 36)  
            return (char)(index + 55); //os chars 65 a 90 representam [A - Z]  
        else  
            return (char)(index + 61); //os chars 97 a 122 representam [a - z]  
    }  
	
}
