package mili;

public class PilhaChar {
	public final int N = 15;

	char dados[] = new char[N];
	int topo;

	public static class RetornoChar {
		public char elem;
		public boolean sucesso;
	}

	public void init() {
		topo = 0;
	}

	// checa se a pilha ta vazia
	public boolean isEmpty() {
		if (topo == 0)
			return true;
		else
			return false;
	}

	// checa se a pilha ta cheia
	public boolean isFull() {
		if (topo == N)
			return true;
		else
			return false;
	}

	// insere um novo elemento
	public void push(char elem) {
		if (!isFull()) {
			dados[topo] = elem;
			topo++;
		} else
			System.out.println("Stack overflow");
	}

	// retira o emento do topo
	public RetornoChar pop() {
		RetornoChar saida = new RetornoChar();
		if (!isEmpty()) {
			topo--;
			saida.elem = dados[topo];
			saida.sucesso = true;
		} else {
//					System.out.println("Stack is empty");
			saida.sucesso = false;
		}
		return saida;
	}

}
