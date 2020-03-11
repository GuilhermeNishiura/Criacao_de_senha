package mili;

import java.util.Scanner;

import mili.PilhaChar.RetornoChar;

public class SalvaSenha {

	public static void main(String[] args) {

		// melhor nome de entrada de dados
		Scanner potato = new Scanner(System.in);

		PilhaChar senha = new PilhaChar();
		RetornoChar res = new RetornoChar();

		senha.init();

		System.out.println("Insira sua senha:");
		String tempSenha = potato.next();

		tempSenha = inverter(tempSenha, senha, res);

		tempSenha = trocar(tempSenha);

		tempSenha = aumentar(tempSenha);

		System.out.println(tempSenha);

		potato.close();

	}

	// inverte os elementos da senha
	public static String inverter(String tempSenha, PilhaChar senha, RetornoChar res) {
		String aux = "";
		for (int i = 0; i < tempSenha.length(); i++) {
			if (tempSenha.charAt(i) != '_' && tempSenha.charAt(i) != '#') {
				// armazena os caracteres na pilha
				senha.push(tempSenha.charAt(i));
			} else {
				// coloca os caracteres na variável auxiliar para voltar na senha
				while (senha.topo > 0) {
					res = senha.pop();
					if (res.sucesso == true) {
						aux += res.elem;
					}
				}
				// coloca o espaçamento(_ ou #)
				if (tempSenha.charAt(i) == '_') {
					aux += '_';
				} else {
					aux += '#';
				}
			}
		}
		// coloca os caracteres na variável auxiliar para voltar na senha
		while (senha.topo > 0) {
			res = senha.pop();
			if (res.sucesso == true) {
				aux += res.elem;
			}
		}
		return aux;
	}

	// troca os caracteres normais por especiais
	public static String trocar(String tempSenha) {
		String aux = "";
		for (int i = 0; i < tempSenha.length(); i++) {
			if (tempSenha.charAt(i) == 'a') {
				aux += "@";
			} else if (tempSenha.charAt(i) == 's') {
				aux += "$";
			} else if (tempSenha.charAt(i) == 'r') {
				aux += "*";
			} else if (tempSenha.charAt(i) == 'e') {
				aux += "&";
			} else if (tempSenha.charAt(i) == 'i') {
				aux += "!";
			} else if (tempSenha.charAt(i) == 'o') {
				aux += "(";
			} else if (tempSenha.charAt(i) == 'u') {
				aux += "+";
			} else {
				aux += tempSenha.charAt(i);
			}
		}

		return aux;
	}

	// deixar tudo em caps lock
	public static String aumentar(String tempSenha) {
		String aux = "";
		aux = tempSenha.toUpperCase();
		return aux;
	}
}
