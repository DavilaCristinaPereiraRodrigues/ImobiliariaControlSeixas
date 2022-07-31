package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ajuda {
	private String texto = ""; // para sumir o NULL quando a ajuda é chamada, comolcamos este = ""

	public Ajuda(String nomeArquivo) {
		
		try{
		
		// Abre o arquivo
		BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));
		
		// Variável para armazenar as linhas de texto do arquivo
		String linha = "";
		do {
			
			// Faz a leitura da linha do arquivo
			linha = in.readLine();
			
			// Caso não tenha terminado as linhas, vai armazenando
			if (linha != null) {
				texto += linha + "\n";
			}
		} while (linha != null);
		
		} catch (IOException io){
			System.out.println("Arquivo Ajuda.txt não encontrado."+
					" Consulte o site http://www.infonote.net/ajuda.html");
		}
	}

	public String getTexto() {
		return texto;
	}
}