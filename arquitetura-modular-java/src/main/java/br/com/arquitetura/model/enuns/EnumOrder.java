package br.com.arquitetura.model.enuns;

/**
 * <p>
 * <b>Título:</b> EnumOrder.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Enumerator responsável por valorar o tipo da ordenação da paginação deve seguir.
 * </p>
 *
 * @author marcosolavo
 *
 * @version 1.0.0
 */
public enum EnumOrder {

	/** Constante ASC. */
	ASC(1, "ASCENDING"),

	/** Constante DESC. */
	DESC(2, "DESCENDING");

	/** Atributo chave. */
	private Integer chave;

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private EnumOrder() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param chave
	 * @param descricao
	 */
	private EnumOrder( final Integer chave, final String descricao ) {

		this.chave = chave;

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>chave</code>
	 *
	 * @return <code>Integer</code>
	 */
	public Integer getChave() {

		return chave;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return descricao;
	}
}
