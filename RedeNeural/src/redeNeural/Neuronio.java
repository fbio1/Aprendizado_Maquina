package redeNeural;

public class Neuronio {
	//e = erro (e = yd - y)
	//n = taxa de aprendizagem
	//w = peso
	//x = entrada
	//y = saida
	//yd = saida desejada
	
	private double erro;
	private double taxaAprendizagem = 0.3;
	private double peso[];
	private int entrada[];
	private int saida;


	public Neuronio(int qtdEntradas) {
		entrada = new int[qtdEntradas];
		peso = new double[qtdEntradas];
		iniciaPeso();
	}
	
	public void iniciaPeso(){
		for (int i = 0; i < peso.length; i++) {
			peso[i] = 0;
		}
	}
	
	public void atualizaPeso(){
		for (int i = 0; i < entrada.length; i++) {
			//Wi_novo = Wi_atual + n*e*Xi
			peso[i] = peso[i]+ taxaAprendizagem * erro * entrada[i];
		}
	}	

	public void calculaSaida(){
		int somatorio = 0;
		//u = somatorio
		for (int i = 0; i < entrada.length; i++) {
			somatorio += entrada[i]*peso[i];
		}		
		
		if(somatorio > 0){
			saida = 1;
		}else{
			saida = 0;
		}	
	}

	public double getErro() {
		return erro;
	}

	public void setErro(int saidaDesejada) {
		//calcula erro
		erro = saidaDesejada - saida;
		
		if(erro != 0){
			atualizaPeso();
		}
	}

//	public void setEntrada(int entrada , int v) {
//		this.entrada[entrada] = v;
//	}
	
	public void setEntrada(int[] entrada) {
		this.entrada = entrada;
	}			
	
	public int getSaida() {
		return saida;
	}	
}
