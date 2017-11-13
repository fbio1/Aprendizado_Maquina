package redeNeural;

import java.util.Scanner;

public class Rede {

	Scanner entrar = new Scanner(System.in);
	int qtdAtributos;
	int qtdExemplos = 0;
	Neuronio n;
	
	int[][] exemplos = {{1,0,1,0},{0,1,0,1},{1,0,1,0},{0,1,1,1},{0,0,1,1},{0,0,0,1}};
	int[] saidaDesejada = {0,1,0,1,0,1};
	
	public static void main(String[] args) {
		Rede rede = new Rede();
		rede.iniciarRede();
		rede.treinarRede();
		rede.executarRede();	
	}
	
	public void iniciarRede(){
		qtdExemplos = exemplos.length;
		qtdAtributos = exemplos[0].length;
		n = new Neuronio(qtdAtributos);
	}
	
	public void treinarRede(){
		double erroTotal = 0;
		
//		n.iniciaPeso();
		
		do{		
			erroTotal = 0;
			for (int i = 0; i < exemplos.length ; i++) {		
				for (int j = 0; j < exemplos[i].length; j++) {
					n.setEntrada(j, exemplos[i][j]);
					System.out.println("ENTRADAS= " + exemplos[i][j]);
				}				
				
				//calculaSaida();				
				n.calculaSaida();
				System.out.println("saida= " + n.getSaida());
				//calculaErro();
				n.setErro(saidaDesejada[i]);				
				
				erroTotal = erroTotal + Math.abs(n.getErro());
				System.out.println("ErroTotal= " + erroTotal);
				System.out.println("Erro do neuronio= " + n.getErro());
				
			}			
		}while(erroTotal > 0);
	}
	
	public void executarRede(){
		System.out.println("Virus");
		System.out.println("Bacteria");
		System.out.println("Dor de cabeça");
		System.out.println("Corisa");
	}	
	
}