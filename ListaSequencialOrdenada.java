package listaSequencial;

public class ListaSequencialOrdenada {
	private int tamanho;
	private int quantidadeNos;
	private No nos[];
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getQuantidadeNos() {
		return quantidadeNos;
	}
	public void setQuantidadeNos(int quantidadeNos) {
		this.quantidadeNos = quantidadeNos;
	}
	public No[] getNos() {
		return nos;
	}
	public ListaSequencialOrdenada(int tamanho) {
		setTamanho(tamanho);
		setQuantidadeNos(0);
		this.nos= new No[tamanho];
	}
	public boolean estaVazia() {
		if(getQuantidadeNos()==0) {
			return true;
		}
		return false;
	}
	public boolean estaCheia() {
		if(getQuantidadeNos()==tamanho) {
			return true;
		}
		return false;
	}
	public void adicionarNo(No no) {
		if (!estaCheia()) {  	
			if (estaVazia()) {
				this.nos[getQuantidadeNos()] = no;
	        	setQuantidadeNos(getQuantidadeNos()+1);
	        }
			else {
				int indice = buscaBinariaParaInsercao(no.getValor());
				for(int x=getQuantidadeNos();x>indice;x--) {
					getNos()[x]=getNos()[x-1];
				}
				getNos()[indice]=no;
				setQuantidadeNos(getQuantidadeNos()+1);
			}
		}
		else {
			System.out.println("A lista esta cheia!");
		}
	}
	
	public int buscaBinariaParaInsercao(int valor) {
		int inicio=0;
		int meio=0;
		int fim= getQuantidadeNos()-1;
		while(inicio<=fim) {
			meio=(inicio+fim)/2;
			if(getNos()[meio].getValor()==valor) {
				return meio;
			}
			else if(getNos()[meio].getValor()>valor) {
				fim=meio-1;
			}
			else {
				inicio=meio+1;
			}
		}
		return inicio;
	}
	
	private int buscarBinaria(int valor) {
		int inicio=0;
		int meio=0;
		int fim=getQuantidadeNos()-1;
		while(inicio<=fim) {
			meio=(inicio+fim)/2;
			if(getNos()[meio].getValor()==valor) {
				return meio;
			}
			else if(getNos()[meio].getValor()>valor) {
				fim=meio-1;
			}
			else{
				inicio=meio+1;
			}
		}
		return -1;
	}

	public boolean removerNo(int valor) {
		int indice = buscarBinaria(valor);
		if(indice>-1) {
			for(int x=indice;x<getQuantidadeNos()-1;x++) {
				getNos()[x]=getNos()[x+1];
			}
			getNos()[getQuantidadeNos()-1]=null;
			setQuantidadeNos(getQuantidadeNos()-1);
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String linha=" ";
		for(int x=0;x<getQuantidadeNos();x++) {
			linha += getNos()[x].getValor();
			if(x+1<getQuantidadeNos()) {
				linha+=",";
			}
		}
		return linha;
	}
}
