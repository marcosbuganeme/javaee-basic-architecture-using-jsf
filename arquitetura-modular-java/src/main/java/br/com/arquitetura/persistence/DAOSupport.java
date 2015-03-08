package br.com.arquitetura.persistence;

import java.io.Serializable;
import java.util.List;

import br.com.arquitetura.exception.NegocioException;
import br.com.arquitetura.model.ModelSupport;
import br.com.arquitetura.utilities.Paginator;

/**
 * <p>
 * <b>Título:</b> DAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface pai de todos os repositorios.
 * </p>
 *
 * @author marcosolavo
 * 
 * @param <T>
 *            - entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public interface DAOSupport<T extends ModelSupport> extends Serializable {

	/**
	 * Método responsável por salvar um registro.
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 *            - registro que será salvo
	 * 
	 * @throws NegocioException
	 */
	void save(final T entity);

	/**
	 * Método responsável por
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 * 
	 * @throws NegocioException
	 */
	void merge(final T entity);

	/**
	 * Método responsável por
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 * 
	 * @throws NegocioException
	 */
	void remove(final T entity);

	/**
	 * Método responsável por consultar um registro sob um determinado criterio
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 * 
	 * @return
	 */
	List<T> consult(final T entity);

	/**
	 * Método responsável por criar uma consulta ordenada e paginada, reduzindo o custo de processamento de dados, perfomance de sql.
	 *
	 * @author marcosolavo
	 *
	 * @param domain
	 *            - entidade que será consultada.
	 * @param first
	 *            - primeiro registro.
	 * @param pageSize
	 *            - quantidade de páginas.
	 * 
	 * @param sortField
	 *            - campo que será ordenado
	 * 
	 * @param sortOrder
	 *            - tipo da ordenação do campo (ASC, DESC)
	 * 
	 * @return
	 */
	Paginator<T> consultPaginator(final T domain, final int first, final int pageSize, final String sortField, final String sortOrder);
}
