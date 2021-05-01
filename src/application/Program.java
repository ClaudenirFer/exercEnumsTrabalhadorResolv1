package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.print("Digite o Departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("Informe os Dados do Trabalhador: ");
		System.out.print("Nome: ");
		String trabalhadorNome = sc.nextLine();
		System.out.print("Nível: ");
		String trabalhadorNivel = sc.nextLine();
		System.out.print("Salário Base: ");
		Double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(trabalhadorNome, NivelTrabalhador.valueOf(trabalhadorNivel), salarioBase, new Departamento(departamentoNome));
		/*--------------------------------------------------------------------------*/
		System.out.println();		
		System.out.print("How many contracts to this Worker? ");
		int n = sc.nextInt();		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i +" data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			//sc.nextLine();
			String data = sc.next();
			System.out.print("Value per Hour: ");
			Double valorHora = sc.nextDouble();
			System.out.print("Duration: ");
			int duracaoHora = sc.nextInt();
			HoraContrato contrato = new HoraContrato(sdf.parse(data), valorHora, duracaoHora);
			trabalhador.addContrato(contrato);
			
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String mesAno = sc.next();
		/*
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));*/				
		SimpleDateFormat sdfMesAno = new SimpleDateFormat("MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdfMesAno.parse(mesAno));
		int mes = 1 + cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);		
		System.out.print("Name: ");
		System.out.println(trabalhador.getNome());
		System.out.print("Department: ");
		System.out.println(trabalhador.getDepartamento().getNome());		
		System.out.print("Income for " + mesAno +": "  + String.format("%.2f", trabalhador.renda(ano, mes)));		
		sc.close();

	}

}
