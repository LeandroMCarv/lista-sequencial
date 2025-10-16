package listaSequencial;

public class Main {
	public static void main(String[] args) {
		ListaSequencialOrdenada lista = new ListaSequencialOrdenada(4);
		lista.adicionarNo(new No(7));
		lista.adicionarNo(new No(9));
		lista.adicionarNo(new No(3));
		lista.adicionarNo(new No(12));
		lista.removerNo(9);
		System.out.println(lista.toString());
	}
}