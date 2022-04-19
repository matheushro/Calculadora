package programa;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Multiplicacao;
import classes.Soma;
import classes.Subtracao;
import classes.Divisao;

public class ExemploPrograma {	
	
	public static void main(String args[]) {
				
		Integer opc = 0;
		do {
			opc = menu();
			ArrayList<Double> entrada = menuEntradaDados();
			
			switch (opc) {
			case 1:
				Double data_soma[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_soma[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_soma));				
				
				Soma soma = new Soma();
				System.out.println(soma.calcula(data_soma));
				
				break;
			case 2:
				Double data_sub[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_sub[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_sub));				
				
				Subtracao sub = new Subtracao();
				System.out.println(sub.calcula(data_sub));
				break;
			case 3:
				Double data_mult[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_mult[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_mult));				
				
				Multiplicacao mult = new Multiplicacao();
				System.out.println(mult.calcula(data_mult));
				break;
			case 4:
				Double data_div[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_div[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_div));				
				
				Divisao div = new Divisao();
				System.out.println(div.calcula(data_div));
				break;
			default:
				System.out.println("Finalizando a aplicaÃ§Ã£o...");
				System.exit(0);
				break;
			}
		} while (opc != 0);
		
		
	}
	
	public static Integer menu() {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("===================================\n");
		sb.append("=========  CALCULADORA   ==========\n");
		sb.append("===================================\n");
		sb.append("Digite 1 para realizar SOMA \n");
		sb.append("Digite 2 para realizar SUBTRAÇÃO \n");
		sb.append("Digite 3 para realizar MULTIPLICAÇÃO \n");
		sb.append("Digite 4 para realizar DIVISÃO \n");
		sb.append("Digite 0 para encerrar \n");
		
		System.out.println(sb.toString());
		Integer opc = scan.nextInt();
		return opc;
	}
	
	public static ArrayList<Double> menuEntradaDados() {
		ArrayList<Double> entrada = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("===================================\n");
		sb.append("=========  Entrada de Dados   =====\n");
		sb.append("===================================\n");
		
		
		Integer usuarioQuerContinuar = 0;
		do {			
			System.out.println("Digite o número:");
			if (scan.hasNextDouble()) {
				entrada.add(scan.nextDouble());
			}			
			if (entrada.size() >= 2) {
				System.out.println("Você deseja iserir mais um número? [0 - SIM | 1 - NÃƒO]");
				usuarioQuerContinuar = scan.nextInt();
			}
			
		} while (entrada.size() < 2 || usuarioQuerContinuar  == 0);
	
		return entrada;
	}
	
	public static String verificaTipoEntrada(Double[] entrada) {
		// se todos forem inteiros deve retornar inteiro
		// se todos forem float devem retornar float
		// todos os outros casos devem retornar double
		Integer numeroEntradaInteiros = 0;
		Integer numeroEntradaFloat = 0;
		Integer numeroEntradaDouble = 0;
		for (int i = 0; i < entrada.length; i++) {
			
			double n = entrada[i];
			
			if ((int) n == n) {
				numeroEntradaInteiros++;
			} else if (Double.toString(n).split("\\.")[1].length() < 7) {
				numeroEntradaFloat++;
			} else {
				numeroEntradaDouble++;
			}			
		}
		
		if (numeroEntradaInteiros > 0 && numeroEntradaFloat == 0 && numeroEntradaDouble == 0) {
			return "inteiro";
		}
		
		if ((numeroEntradaInteiros > 0 || numeroEntradaInteiros == 0) && numeroEntradaFloat > 0 && numeroEntradaDouble == 0) {
			return "float";
		}
		
		return "double";
	}
}

