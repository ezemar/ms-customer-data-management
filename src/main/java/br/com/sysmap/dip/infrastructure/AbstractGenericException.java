package br.com.sysmap.dip.infrastructure;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe que deve ser a pai de todas as classe de excção para permitir que se
 * trafegue junto com a excption o codigo de erro de negocio e os parametros
 * para a mensagem que será exibida ao usuário.
 *
 * @author A0089321 - Arthur Gomes
 */
public class AbstractGenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4460978644291909721L;

	private static Logger logger = LoggerFactory.getLogger(AbstractGenericException.class);
	private Object[] parametrosMensagem = null;

	private String mensagemAmigavel = null;

	private String mensagemStackTrace = null;

	private String tipoMensagem = null;

	private String codigo = null;

	/**
	 * Este novo construtor recebe um Throwable e possibilita a inserção de
	 * parametros na mensagem internacionalizada.
	 *
	 * @param cause      Causa do erro
	 * @param parameters parametros para a mensagem de usuario no padrao formatmsg
	 * @author A0089321 - Arthur Gomes
	 */
	public AbstractGenericException(final Throwable cause, final Object[] parameters) {
		super(cause);
		this.setParametrosMensagem(parameters);

		// Caso eu tenha uma excecao de negocio sendo construída com uma
		// DAOException por
		// exemplo, ela nao terá de passar novamente por todo este processo.
		if (cause instanceof AbstractGenericException) {
			if (((AbstractGenericException) cause).getMensagemAmigavel() != null) {
				this.setMensagemAmigavel(((AbstractGenericException) cause).getMensagemAmigavel());
				return;
			}
		}

		// É possível inserir uma msg amigável para um SQLException 'a partir de
		// uma XYZException na camada superior.
		Throwable innerCause = null;
		innerCause = cause.getCause();
		while (true) {
			if ((innerCause != null) && (innerCause instanceof SQLException)) {
				break;
			} else if ((innerCause != null) && (innerCause.getCause() != null)) {
				innerCause = innerCause.getCause();
			} else {
				break;
			}
		}
		if (innerCause instanceof SQLException) {
			String msg = null;
			String arg0 = null;
			if (innerCause.getMessage().indexOf("(") == -1) {
				msg = innerCause.getMessage();
			} else {
				msg = innerCause.getMessage().substring(0, innerCause.getMessage().indexOf("(") - 1);
				arg0 = innerCause.getMessage().substring(innerCause.getMessage().indexOf("(") + 1,
						innerCause.getMessage().indexOf(")"));
			}

			try {

				ResourceBundle bundle = ResourceBundle.getBundle("",
						Locale.getDefault(), this.getClass().getClassLoader());
				String mensagemBundle = bundle.getString(msg.replaceAll(" ", ""));
				// Existe arg0 no arquivo de mensagens?
				String tempArg0 = null;
				try {
					tempArg0 = bundle.getString(arg0);
				} catch (MissingResourceException i) {
					logger.debug("não exite parametro para a mensagem do bundle. ");
				}
				arg0 = tempArg0 != null ? tempArg0 : arg0;
				Object[] argumentos = null;
				if (arg0 != null) {
					argumentos = new Object[] { arg0 };
				}
				if (mensagemBundle != null) {
					// sincronizar o trecho)
					String mensagemTratada = null;
					if (argumentos != null) {
						mensagemTratada = MessageFormat.format(mensagemBundle, argumentos);
					} else {
						mensagemTratada = mensagemBundle;
					}
					this.setMensagemAmigavel(mensagemTratada);
				}
			} catch (MissingResourceException io) {
				System.out.println("Missing Resource " + io);
				this.setMensagemAmigavel(innerCause.getMessage());
			}
		} else {
			String mensagem = null;
			if (innerCause == null) {
				mensagem = cause.getMessage();
			} else {
				mensagem = innerCause.getMessage();
			}
			if (mensagem != null) {
				mensagem = getMensagemInternacionalizada(mensagem);
			}
			this.setMensagemAmigavel(mensagem);
		}
	}

	/**
	 * construtor.
	 *
	 * @param cause causa do erro
	 */
	public AbstractGenericException(Throwable cause) {
		this(cause, null);
	}

	/**
	 * todas as exceptions dos sistemas deve utilizar este construtor onde o tipo de
	 * mensagem indica se é um erro de sistema ex: falha ao conectar na base de
	 * dados ou um erro de negócio. Ex período inválido. a mensagem deve ser uma
	 * constantes para a mensagem que estará no bundle do struts.
	 *
	 * @param tipoMensagem       tipo da mensagem: erro de sietema ou erro de
	 *                           negocio
	 * @param mensagemAmigavel   mensagem que aparecerá para o usuário
	 * @param parametrosMensagem parametros da mensagem amigavel
	 * @param stackTrace         stackTrace do erro
	 */
	public AbstractGenericException(final String codigo, final String tipoMensagem, final String mensagemAmigavel,
			Object[] parametrosMensagem, String stackTrace) {
		this(new Throwable(mensagemAmigavel));
		this.setTipoMensagem(tipoMensagem);
		this.setParametrosMensagem(parametrosMensagem);
		this.setMensagemStackTrace(stackTrace);
		this.setCodigo(codigo);
	}

	/**
	 * retorna os parametros a serem passados a Mensagem de erro existente no
	 * bundle.
	 *
	 * Ex: Esta é uma mensagem de exempo com parametro = {valor}
	 *
	 * onde valor será um dos parametros do array de objetos
	 *
	 * @return arrai de paramtros para a mensagen
	 */
	public final Object[] getParametrosMensagem() {
		return parametrosMensagem;
	}

	/**
	 * Define os parametros a serem passados a Mensagemde de erro existente no
	 * bundle.
	 *
	 * Ex: Esta é uma mensagem de exempo com parametro = {valor}
	 *
	 * onde valor será um dos parametros do array de objetos
	 *
	 * @param paramMensagem parametros para a mensagem de negocio
	 */
	public final void setParametrosMensagem(Object[] paramMensagem) {
		this.parametrosMensagem = paramMensagem;
	}

	/**
	 * @return Returns the mensagem.
	 */
	public final String getMensagemAmigavel() {
		return mensagemAmigavel;
	}

	/**
	 * Procura a mensagem no bundle de exception caso nao existe repassa a mensagem.
	 *
	 * @param msgErro mensgem de negocio
	 */
	public final void setMensagemAmigavel(String msgErro) {
		this.mensagemAmigavel = msgErro;

	}

	/**
	 * Método que obtem a msg de erro internacionalizada do bundle.
	 *
	 * @param msgErro constante de msg de erro a ser internacionalizada *
	 * @return retorna a msg internacionalizada
	 *
	 */
	private String getMensagemInternacionalizada(String msgErro) {

		// Provavelmente alguém está construindo esta excecao através do
		// lançamento de um new Throwable(msg)

			return msgErro;

	}

	/**
	 * Método utilitário utilizado na infra de exceção para transformar uma lista de
	 * exceção na representação de String separando as mensagens pelo caracter "|".
	 * <br />
	 * <br />
	 *
	 * O resultado desse retorno, será utilizado para iterar nas mensagens da tela
	 * do usuário.
	 *
	 * @param listaMensagemErro Lista de erros (String).
	 * @return
	 *
	 * @author A0089321 - Arthur Gomes
	 */
	protected static String gerarEmString(List<String> listaMensagemErro) {
		StringBuilder sb = new StringBuilder();

		for (String mensagemErro : listaMensagemErro) {
			sb.append(mensagemErro + "|");
		}

		return sb.delete(sb.lastIndexOf("|"), sb.length()).toString();
	}

	/**
	 * @return Returns the mensagemStackTrace.
	 */
	public String getMensagemStackTrace() {
		return mensagemStackTrace;
	}

	/**
	 * @param mensagemStackTrace The mensagemStackTrace to set.
	 */
	public void setMensagemStackTrace(String mensagemStackTrace) {
		this.mensagemStackTrace = mensagemStackTrace;
	}

	/**
	 * @return Returns the tipoMensagem.
	 */
	public String getTipoMensagem() {
		return tipoMensagem;
	}

	/**
	 * @param tipoMensagem The tipoMensagem to set.
	 */
	public void setTipoMensagem(String tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}