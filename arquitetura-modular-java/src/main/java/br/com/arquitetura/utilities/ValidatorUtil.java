package br.com.arquitetura.utilities;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * <b>Título:</b> ValidatorUtil.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe utilitária para validar dados.
 * </p>
 *
 * @author marcosolavo
 *
 * @version 1.0.0
 */
public class ValidatorUtil implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Método responsável por verificar se é nulo.
	 *
	 * @author marcosolavo
	 * 
	 * @param object
	 *            Objeto para validação
	 *
	 * @return boolean true or false.
	 */
	public static boolean isNull(final Object object) {

		return object == null;
	}

	/**
	 * Método responsável por verificar se é não é nulo.
	 *
	 * @author marcosolavo
	 * 
	 * @param object
	 *            Objeto para validação
	 *
	 * @return boolean true or false.
	 */
	public static boolean isNotNull(final Object object) {

		return object != null;
	}

	/**
	 * Método responsável por verificar se vazio.
	 *
	 * @author marcosolavo
	 * 
	 * @param str
	 *            String para validação
	 *
	 * @return boolean true or false.
	 */
	public static boolean isEmpty(final String str) {

		return ValidatorUtil.isNull(str) || str.isEmpty();
	}

	/**
	 * Método responsável por verificar se não é vazio.
	 *
	 * @author marcosolavo
	 * 
	 * @param str
	 *            String para validação
	 *
	 * @return boolean true or false.
	 */
	public static boolean isNotEmpty(final String str) {

		return ValidatorUtil.isNotNull(str) && !str.isEmpty();
	}

	/**
	 * Método responsável por verificar se a lista não é vazia.
	 *
	 * @author marcosolavo
	 * 
	 * @param lista
	 *            List para validação
	 *
	 * @return boolean true or false.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(final List lista) {

		return ValidatorUtil.isNull(lista) || lista.isEmpty();
	}

	/**
	 * Método responsável por verificar as seguintes situações:
	 *
	 * @author marcosolavo
	 * 
	 *         StringUtils.isBlank(null) = true StringUtils.isBlank("") = true StringUtils.isBlank(" ") = true StringUtils.isBlank("bob") = false StringUtils.isBlank("  bob  ") = false
	 *
	 * @param str
	 *            String que irá ser verificada.
	 *
	 * @return bolean true or false.
	 */
	public static boolean isBlank(final String str) {

		return StringUtils.isBlank(str);
	}

}
