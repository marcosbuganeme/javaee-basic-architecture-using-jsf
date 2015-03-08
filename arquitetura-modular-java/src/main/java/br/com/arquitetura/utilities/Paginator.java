package br.com.arquitetura.utilities;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * <b>Título:</b> Paginator.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por paginar os dados de uma tabela de dados.
 * </p>
 *
 * @author marcosolavo
 * 
 * @param <T>
 *            - entidade manipulada
 *
 * @version 1.0.0
 */
public class Paginator<T> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 5101043914153342669L;

	/** Atributo lista. */
	private List<T> lista;

	/** Atributo count. */
	private Long count;

	/**
	 * Retorna o valor do atributo <code>lista</code>
	 *
	 * @return <code>List<T></code>
	 */
	public List<T> getLista() {

		return this.lista;
	}

	/**
	 * Define o valor do atributo <code>lista</code>.
	 *
	 * @param lista
	 */
	public void setLista(final List<T> lista) {

		this.lista = lista;
	}

	/**
	 * Retorna o valor do atributo <code>count</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getCount() {

		return this.count;
	}

	/**
	 * Define o valor do atributo <code>count</code>.
	 *
	 * @param count
	 */
	public void setCount(final Long count) {

		this.count = count;
	}

}
