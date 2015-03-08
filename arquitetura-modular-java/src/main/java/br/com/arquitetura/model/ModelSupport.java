package br.com.arquitetura.model;

import java.io.Serializable;

/**
 * <p>
 * <b>Título:</b> ModelSupport.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface pai de todas os modelos.
 * </p>
 *
 * @author marcosolavo
 * 
 * @param <PK>
 *            - Chave primária da tabela
 *
 * @version 1.0.0
 */
public interface ModelSupport extends Serializable {

	/**
	 * Método responsável por obter o id da entidade manipulada
	 *
	 * @author marcosolavo
	 *
	 * @return <i>id</i>
	 */
	Long getId();

	/**
	 * Método responsável por verificar se um registro já foi persistido ou não, na condição de verificação da existência de id.
	 *
	 * @author marcosolavo
	 *
	 * @return <i>True, se for novo</i>
	 */
	boolean isNewRecord();
}
