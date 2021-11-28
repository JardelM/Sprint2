package modelo;

public class Filme {

	private Integer id;
	private String nome;
	private String descricao;
	private Integer ano;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Filme(Integer id, String nome, String descricao, Integer ano) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
	}
	
	public Filme(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	

	@Override
	public String toString() {
		return String.format("Filme : %d, %s, %s, %d", this.id, this.nome, this.descricao, this.ano);
	}

}
