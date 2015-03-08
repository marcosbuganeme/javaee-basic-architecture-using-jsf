package br.com.arquitetura.exception;

/**
 * <p>
 * <b>Título:</b> NegocioException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe de exceção
 * </p>
 *
 * @author marcosolavo
 *
 * @version 1.0.0
 */
public class NegocioException extends RuntimeException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3051965302909421465L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public NegocioException() {

		super();
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param message
	 * @param header
	 */
	public NegocioException( final String message, final String header ) {

		super(message);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 */
	public NegocioException( final Throwable causa ) {

		super(causa);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 * @param causa
	 */
	public NegocioException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}
}
