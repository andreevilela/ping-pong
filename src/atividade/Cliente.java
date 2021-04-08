package atividade;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket conexao = new Socket("127.0.0.1", 2001);
		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());

		String linha;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("Digite a mensagem: ");
			linha = teclado.readLine();
			saida.writeUTF(linha);
			linha = entrada.readUTF();
			
			if (linha.equalsIgnoreCase("sair")) {
				System.out.println("Conexao encerrada!");
				break;
			}
			System.out.println(linha);
		}

	}

}
