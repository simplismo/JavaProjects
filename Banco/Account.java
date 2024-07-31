package Banco;

import java.util.Scanner;

public class Account {
		//Variabes
		int balance;
		int previousTransaction;
		String accId;
		String accName;
		Scanner sc = new Scanner(System.in);
		
		//Constructor
		Account(String name, String id) {
			accId = id;
			accName = name;
		}
		void printLines(String str, double value2) {
			System.out.println("=============================");
			System.out.println(str+": "+value2);
			System.out.println("=============================");
		}
		
		//Depósito
		void deposit() {
			System.out.println("Digite um valor para depositar: ");
			double value = sc.nextDouble();
			balance += value;
			previousTransaction = balance;
		}
		
		//Retirar
		void withdrawl() {
			System.out.println("Digite um valor para retirar: ");
			double value = sc.nextDouble();
			balance -= value;
			previousTransaction -= value;
		}

		//Transação prévia
		void viewPrevious() {
			if(previousTransaction > 0) {
				System.out.println("Depositado: "+balance);
			}
			else if(previousTransaction < 0) {
				System.out.println("Retirado: "+Math.abs(previousTransaction));
			} else {
				System.out.println("Nenhuma transação!");
			}
		}
		
		//Juros
		void interest() {
			System.out.println("Digite os anos que deseja de juros: ");
			int years = sc.nextInt();
			System.out.println("A taxa de juros atual é 1.85%");
			double result = balance*(1+1.85/100*10);
			System.out.println("Após "+years+" anos, seu saldo será "+result);	
		}
		
		//Menu
		void showMenu() {
			System.out.println("Olá, "+accName);
			System.out.println("Seu ID é: "+accId);
			
			System.out.println("O que você gostaria de fazer? ");
			System.out.println("A. Ver o saldo");
			System.out.println("B. Fazer um depósito");
			System.out.println("C. Fazer uma retirada");
			System.out.println("D. Ver a transação prévia");
			System.out.println("E. Calcular juros");
			System.out.println("F. Sair");
			
			char option;
			do {
				System.out.println("Sua opção: ");
				
				option = sc.next().charAt(0);
				char option2 = Character.toUpperCase(option);
				
				switch(option2) {
				case 'A':
					printLines("Saldo", balance);
					break;
				case 'B':
					deposit();
					break;
				case 'C':
					withdrawl();
					break;
				case 'D':
					viewPrevious();
					break;
				case 'E':
					interest();
					break;
				default:
					System.out.println("Opção inválida, tente novamente! ");
					break;
				}
				
			
			} while (option!='F'); System.out.println("Obrigado pela prefêrencia");
		}
		
}