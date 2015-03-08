package br.com.arquitetura.model;

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
	private Long id;

	@Override
	public Long getId() {

		return this.id;
	}

	@Override
	public boolean isNewRecord() {

		return this.getId() == null;
	}

}
