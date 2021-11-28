public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setAno(Double preco) {
		this.preco = preco;
	}

	public Produto(Integer id, String nome, String descricao, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Produto(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	

	@Override
	public String toString() {
		return String.format("Filme : %d, %s, %s, %d", this.id, this.nome, this.descricao, this.preco);
	}

}