package edu.upc.spa.utils;

import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class WSSUtilities {

	private static final String SECURITY_NAMESPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

	/**
	 * Funció que permet afegir a la capçalera de la petició SOAP la informació
	 * per l'autenticació de l'usuari que vol executar el servei
	 * 
	 * @param ws
	 *            - Instància del nostre servei
	 * @param username
	 *            String - Usuari a afegir a la capçalera.
	 * @param password
	 *            String - Contrasenya a afegir a la capçalera.
	 * @throws WSSParametresException
	 *             Excepció bàsica de control de parametres.
	 */
	@SuppressWarnings("rawtypes")
	public static void afegirUsernameTokenPeticioSOAP(Object ws,
			final String username, final String password) throws Exception {

		try {
			if (username == null || password == null) {
				throw new Exception(
						"El username i el password han d'estar informats.");
			}
			BindingProvider bp = (BindingProvider) ws;
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
					username);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
					password);
			List<Handler> chain = bp.getBinding().getHandlerChain();
			chain.add(createHandler(username, password));
			bp.getBinding().setHandlerChain(chain);
		} catch (SOAPException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	private static SOAPHandler createHandler(final String username,
			final String password) {
		return new javax.xml.ws.handler.soap.SOAPHandler() {
			@Override
			public void close(MessageContext context) {
			}

			@Override
			public boolean handleFault(MessageContext context) {
				return false;
			}

			@Override
			public boolean handleMessage(MessageContext context) {
				boolean isOutBound = (Boolean) context
						.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
				if (!isOutBound) {
					return true;
				}
				try {
					SOAPMessageContext smc = (SOAPMessageContext) context;
					SOAPMessage message = smc.getMessage();
					SOAPHeader header = message.getSOAPHeader();
					if (header == null) {
						SOAPEnvelope envelope = smc.getMessage().getSOAPPart()
								.getEnvelope();
						header = envelope.addHeader();
					}
					SOAPElement securityEl = header.addChildElement(new QName(
							SECURITY_NAMESPACE, "Security"));
					SOAPElement tokenEl = securityEl.addChildElement(new QName(
							SECURITY_NAMESPACE, "UsernameToken"));
					SOAPElement userNameEl = tokenEl.addChildElement(new QName(
							SECURITY_NAMESPACE, "Username"));
					userNameEl.addTextNode(username);
					SOAPElement passwordEl = tokenEl.addChildElement(new QName(
							SECURITY_NAMESPACE, "Password"));
					passwordEl.addTextNode(password);
					System.out.println(header);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			}

			@Override
			public Set getHeaders() {
				return null;
			}
		};
	}
}
