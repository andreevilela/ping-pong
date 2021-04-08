package atividade;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket s = new ServerSocket(2001);
		
		String resposta;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("Esperando conectar...");
			Socket conexao = s.accept();
			if (conexao.isConnected()) 
					System.out.println("Esperando mensagem.");
			
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			
			String linha = entrada.readUTF();
			while (linha != null && !(linha.trim().equals("SAIR"))) {
				System.out.println("Mensagem recebida: " + linha);
				saida.writeUTF("Mensagem enviada.");
				System.out.print("Digite a resposta: ");
				resposta = teclado.readLine();
			}
			saida.writeUTF(linha);
			conexao.close();
		}

	}

}
