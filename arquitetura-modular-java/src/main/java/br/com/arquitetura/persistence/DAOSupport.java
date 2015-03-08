package br.com.arquitetura.persistence;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import br.com.arquitetura.exception.NegocioException;
import br.com.arquitetura.model.ModelSupport;
import br.com.arquitetura.model.enuns.EnumOrder;
import br.com.arquitetura.utilities.Paginator;
import br.com.arquitetura.utilities.ValidatorUtil;

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
@SuppressWarnings("unchecked")
public abstract class DAOSupport<T extends ModelSupport> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 4625497366728889843L;

	@PersistenceContext(unitName = "marcosolavo")
	@ApplicationScoped
	private EntityManager manager;

	/**
	 * Método responsável por obter a classe do modelo persistente.
	 *
	 * @author marcosolavo
	 *
	 * @return <i>classe persistente</i>
	 */
	protected abstract Class<T> persistenceClazz();

	/**
	 * Método responsável por obter objeto de sessão do hibernate.
	 *
	 * @author marcosolavo
	 *
	 * @return <i>objeto de sessão</i>
	 */
	public Session getSession() {

		return this.getManager().unwrap(Session.class);
	}

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
	void save(final T entity) {

	}

	/**
	 * Método responsável por
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 * 
	 * @throws NegocioException
	 */
	public void merge(final T entity) {

	}

	/**
	 * Método responsável por
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 * 
	 * @throws NegocioException
	 */
	public void remove(final T entity) {

	}

	/**
	 * Método responsável por consultar um registro sob um determinado criterio
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 * 
	 * @return
	 */
	public List<T> consult(final T entity) {

		return null;
	}

	/**
	 * Método responsável por colocar as restrições sob uma determinada entidade do modelo de dados.
	 *
	 * @author marcosolavo
	 *
	 * @param entity
	 *            - entidade que receberá as restrições.
	 * 
	 * @return <i>objeto criteria</i>.
	 */
	public abstract Criteria consultPaginator(final T entity);

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
	public Paginator<T> consultPaginator(final T domain, final int first, final int pageSize, final String sortField, final String sortOrder) {

		Paginator<T> paginador = new Paginator<T>();

		Criteria criteria = consultPaginator(domain);
		verifyOrder(sortField, sortOrder, criteria);

		criteria.setProjection(Projections.rowCount());
		paginador.setCount(( (Long) criteria.list().get(0) ).longValue());

		criteria = consultPaginator(domain);
		verifyOrder(sortField, sortOrder, criteria);

		criteria.setFirstResult(first);
		criteria.setMaxResults(pageSize);
		paginador.setLista(criteria.list());
		return paginador;
	}

	private void verifyOrder(final String sortField, final String sortOrder, final Criteria criteria) {

		if (!ValidatorUtil.isBlank(sortField)) {

			if (sortOrder.equals(EnumOrder.ASC.getDescricao())) {

				criteria.addOrder(Order.asc(sortField));

			} else {

				criteria.addOrder(Order.desc(sortField));
			}
		}
	}

	/**
	 * Retorna o valor do atributo <code>manager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	public EntityManager getManager() {

		return this.manager;
	}

	/**
	 * Define o valor do atributo <code>manager</code>.
	 *
	 * @param manager
	 */
	public void setManager(final EntityManager manager) {

		this.manager = manager;
	}
}
