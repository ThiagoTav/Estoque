package estoque;
import java.text.NumberFormat;

public class Produto {
	// Fields
		private int idProduto;
		private String nome;
		private double preco;
		private int quantidade;
		private boolean estado;
		private NumberFormat formatter;

		public Produto() { 
			formatter = NumberFormat.getCurrencyInstance();
		}
		
		public Produto(int idProduto, String nome) {
			this();
			this.idProduto = idProduto;
			this.nome = nome;
		}
		

		public Produto(int idProduto, String nome, double preco, int quantidade, boolean estado) {
			this(idProduto, nome);
			this.preco = preco;
			this.quantidade = quantidade;
			this.estado = estado;
		}

		public int getIdProduto() {
			return idProduto;
		}

		public void setIdProduto(int idProduto) {
			this.idProduto = idProduto;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public void addQuantidade(int quantidade) {
			this.quantidade += quantidade;
		}

		public boolean isEstado() { 
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		
		public double valorEstoque() {
			return preco * quantidade;
		}
		
		@Override
		public String toString() {
			return  "Número do item \t\t: " + idProduto + "\n" +
				    "Nome \t\t\t: " + nome  + "\n" +
					"Preço \t\t\t: " + formatter.format(preco)  + "\n" +
				    "Quantidade em estoque\t: " + quantidade + "\n" +
					"Valor do estoque\t: " + formatter.format(valorEstoque()) + "\n" +
					"Status do produto \t: " + (estado?"Ativo":"Descontinuado");
		}
		
	}

