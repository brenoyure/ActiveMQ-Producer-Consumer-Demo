package br.albatross.apis.email;

import java.io.File;
import java.io.Serializable;

public interface Email extends Serializable {

	/**
	 * 
	 * @return O assunto do e-mail (<strong>Não</strong> podendo ficar em branco).
	 */
	String getAssunto();

	/**
	 * 
	 * @return O(s) anexo(s) do e-mail (<strong>Não</strong> podendo ficar nulo ou vazio).
	 */
	File[] getAnexos();

	/**
	 * 
	 * @return O corpo da mensagem do e-mail (<strong>Não</strong> podendo ficar em branco).
	 */
	String getCorpoDaMensagem();

	/**
	 * 
	 * @return Os Dados do Envio (como remetente, destinatário...) do e-mail (<strong>Não</strong> pode ficar nulo).
	 */
	DadosDoEnvio getDadosDoEnvio();
	
	/**
	 * 
	 * Define assunto do e-mail (<strong>Não</strong> podendo ficar em branco).
	 */
	void setAssunto(String assunto);

	/**
	 * 
	 * Define o(s) anexo(s) do e-mail (<strong>Não</strong> podendo ficar nulo ou vazio).
	 */
	void setAnexos(File[] anexos);

	/**
	 * 
	 * Define o corpo da mensagem do e-mail (<strong>Não</strong> podendo ficar em branco).
	 */
	void setCorpoDaMensagem(String corpoDaMensagem);

	/**
	 * 
	 * Define os Dados do Envio (como remetente, destinatário...) do e-mail (<strong>Não</strong> podendo ficar nulo).
	 */
	void setDadosDoEnvio(DadosDoEnvio dadosDoEnvio);
	
}
