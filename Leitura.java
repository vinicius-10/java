//vinicius Souza Dias 2564599

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Leitura {
	private static Leitura leiUnic;//primeiro passo para Singleton
	
	private Leitura(){}//segundo metodo contrutor privado
	
	public static Leitura geraLeitura(){//terceiro criar o metodo de acesso
		if(leiUnic == null)leiUnic = new Leitura();
		
		return leiUnic;
	}
	
	public static String entString(String rotulo){
		System.out.println(rotulo);
		
		InputStreamReader tec = new InputStreamReader(System.in);
		
		BufferedReader bufTec = new BufferedReader(tec);
		
		String ret = "";
		
		try{
			ret = bufTec.readLine();
		}catch(IOException ioe){
			System.out.println("Erro JVM ou de ram");
		}
		
		return ret; 
	}
        
	public static int entInt( String mensagem) {
		int valor;
		
		try {
			valor = Integer.parseInt(entString(mensagem));
			return valor;
		} catch (NumberFormatException e) {
			System.out.println("Valor inválido! Digite um número inteiro.");
			return entInt(mensagem);
		}
	}
}