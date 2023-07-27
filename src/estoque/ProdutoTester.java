package estoque;
import java.util.Scanner;
import java.util.ArrayList;

public class ProdutoTester {

	private static ArrayList<Produto> listaProdutos;
	private static Scanner scanner;

	public static void main(String[] args) {
		int opcao;
		scanner = new Scanner(System.in);
		listaProdutos = new ArrayList<Produto>();
		
		// Produtos iniciais =)
		listaProdutos.add(new Produto(10, "Mouse", 25.99, 10, true));
		listaProdutos.add(new Produto(11, "Teclado", 45.00, 8, true));
	
		do {
			opcao = menu();
			switch (opcao) {
				case 1:
					cadastrar();
					break;
				case 2:
					adicionar();
					break;
				case 3:
					remover();
					break;
				case 4:
					alterar();
					break;
				case 5:
					listar();
					break;
			}
			
		} while(opcao != 6);
		
	}

	public static int menu() {
		int opcao;
		System.out.println("\n**** Controle de Inventário ****");
		System.out.println("1. Cadastrar");
		System.out.println("2. Adicionar quantidade");
		System.out.println("3. Remover quantidade");
		System.out.println("4. Modificar");
		System.out.println("5. Listar");
		System.out.println("6. Encerrar Programa");
		
		System.out.print("Informe uma opção: ");
		
		try {		
			opcao = scanner.nextInt();
		} catch (Exception e) {
			System.err.println("Valor inválido!");
			opcao = 0;
		}
		clearCache();
		return opcao;
	}
	
	public static void clearCache() {
		if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
	}
	
	public static void cadastrar() {

		Produto produto;
		int idProduto;
		String nome;
		double preco;
		int quantidade;
		boolean estado;

		try {
			System.out.print("Informe o número do Produto: ");
			idProduto = scanner.nextInt();
			clearCache();

			System.out.print("Informe o nome do Produto: ");
			nome = scanner.next();
			clearCache();

			System.out.print("Informe a quantidade do Produto: ");
			quantidade = scanner.nextInt();
			clearCache();

			System.out.print("Informe o preço do Produto: ");
			preco = scanner.nextDouble();
			clearCache();

			System.out.print("Informe o status do Produto: ");
			estado = scanner.nextBoolean();
			clearCache();
			
		} catch (Exception e) {
			System.err.println("Erro nos valores digitados, tente novamente!");
			return;
		}
		
		produto = new Produto(idProduto, nome);
		produto.setQuantidade(quantidade);
		produto.setPreco(preco);
		produto.setEstado(estado);
		
		listaProdutos.add(produto);
		
	}

	private static void adicionar() {

		int idProduto;
		int quantidade;

		try {
			System.out.print("Informe o número do Produto: ");
			idProduto = scanner.nextInt();
			clearCache();

			System.out.print("Informe a quantidade do Produto: ");
			quantidade = scanner.nextInt();
			clearCache();
			
		} catch (Exception e) {
			System.err.println("Erro nos valores digitados, tente novamente!");
			return;
		}
		
		for (Produto produto : listaProdutos) {
			if (produto.getIdProduto() == idProduto) {
				produto.setQuantidade(produto.getQuantidade() + quantidade);
				System.out.println("Quantidade adicionada com sucesso!");
				return;
			}
		}
		System.err.println("Produto não encontrado!");
	}


	private static void remover() {
		
	}

	
	private static void alterar() {
		
	}
	
	public static void listar() {
		System.out.println("\n Relação de produtos");
		for (Produto produto : listaProdutos) {
			System.out.println(produto.toString() + "\n");
		}
		

		for (int i=0; i< listaProdutos.size(); i++) {
			Produto produto = listaProdutos.get(i); 
			System.out.println(produto.toString() + "\n");
		}
	
	}
	
}
