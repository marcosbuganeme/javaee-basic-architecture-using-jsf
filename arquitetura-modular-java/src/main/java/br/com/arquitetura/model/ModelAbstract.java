package br.com.arquitetura.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>
 * <b>Título:</b> ModelSupportImpl.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe que implementará a interface <code>ModelSupport</code>.
 * </p>
 *
 * @author marcosolavo
 *
 * @version 1.0.0
 */
public abstract class ModelAbstract implements ModelSupport {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -4556342773862483027L;

	/** Atributo id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Atributo dataCadastro. */
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	/** Atributo dataModificacao. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataModificacao;

	/**
	 * Método responsável por executar o ciclo de vida JPA para os objetos das datas.<br>
	 * Irá persistir sempre uma data de criação e modificação para objetos novos. Já para objetos já existentes, somente a data de modificação.
	 *
	 * @author marcosolavo
	 *
	 */
	@PrePersist
	@PreUpdate
	private void executeCicleJPA() {

		if (this.dataCadastro == null) {

			this.dataCadastro = new Date();
		}

		this.dataModificacao = new Date();
	}

	@Override
	public Long getId() {

		return this.id;
	}

	@Override
	public boolean isNewRecord() {

		return this.getId() == null;
	}

}
