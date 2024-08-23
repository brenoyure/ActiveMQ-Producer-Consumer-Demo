package br.albatross.apis.email;

import java.io.Serializable;

/**
 * Representa os dados de envio de um e-mail.
 */
public interface DadosDoEnvio extends Serializable {

	/**
	 * 
	 * @return O Remetente <strong>(FROM)</strong> do e-mail (<strong>Não</strong> podendo ficar em branco).
	 */
	String getRemetente();

	/**
	 * 
	 * @return O Destinatário <strong>(TO)</strong> do e-mail, podendo ser um ou vários. 
	 * 
	 * (<strong>Não</strong> podendo ficar em branco).
	 */
	String getDestinatario();

	/**
	 * 
	 * @return (Opcional) Os contatos (e-mails) que receberão cópia <strong>(CC)</strong> deste e-mail.
	 */
	String getCopiaPara();

	/**
	 * 
	 * Define o Remetente <strong>(FROM)</strong> do e-mail (<strong>Não</strong> podendo ficar em branco).
	 */
	void setRemetente(String remetente);

	/**
	 * <p>Define o Destinatário <strong>(TO)</strong> do e-mail, podendo ser um ou vários.</p>
	 * exemplo: destinatario1@email.br ou destinatario1@email.br, destinatario2@email.br, destinatario3@email.br... 
	 */
	void setDestinatario(String destinatario);

	/**
	 * (Opcional) Define os contatos (e-mails) que receberão cópia <strong>(CC)</strong> deste e-mail.
	 * @param copiaPara
	 */
	void setCopiaPara(String copiaPara);

}
