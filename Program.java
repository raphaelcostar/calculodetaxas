package calculodetaxas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o n�mero de pessoas: ");
		int n = sc.nextInt();
		List<Pessoa> list = new ArrayList();

		for (int i = 1; i <= n; i++) {
			System.out.println("Cadastre o " + i + "�");
			System.out.println("Pessoa f�sica ou j�ridica: ");
			char tipo = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("Digite o nome: ");
			String nome = sc.nextLine();
			System.out.println("Digite a renda anual: ");
			Double rendaTotal = sc.nextDouble();

			if (tipo == 'f') {
				System.out.println("Digite o total gasto com sa�de: ");
				double gastosComSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaTotal, gastosComSaude));
			}

			if (tipo == 'j') {
				System.out.println("Digite o n�mero de funcion�rios: ");
				int totalDeFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaTotal, totalDeFuncionarios));
			}

		}
		
		System.out.println("Taxas pagas: ");
		for(Pessoa pessoa : list) {
			System.out.println(pessoa);
		}
		
		Double sum = 0.0;
		for (Pessoa pessoa : list) {
			sum+= pessoa.imposto();
		}
		System.out.println("O total de taxas �: " + String.format("%.2f", sum));
	}
}
