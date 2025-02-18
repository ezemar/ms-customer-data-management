package br.com.sysmap.dip.infrastructure.soap.wsSysmap;

import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapLoggingInterceptor implements ClientInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SoapLoggingInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        // Logando a requisição (antes de enviar)
        SoapMessage requestMessage = (SoapMessage) messageContext.getRequest();
        logRequestOrResponse("Requisição", requestMessage);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        // Logando a resposta (após receber)
        SoapMessage responseMessage = (SoapMessage) messageContext.getResponse();
        logRequestOrResponse("Resposta", responseMessage);
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) {
        // Logando erro de SOAP (caso ocorra)
        SoapMessage faultMessage = (SoapMessage) messageContext.getRequest();
        logRequestOrResponse("Erro SOAP", faultMessage);
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) {
        // Não precisa fazer nada aqui, já estamos lidando com a requisição e resposta
    }

    private void logRequestOrResponse(String type, SoapMessage message) {
        try {
            // Acessando o XML da requisição/resposta e logando
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            message.writeTo(byteArrayOutputStream);
            String xml = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);

            // Logando o XML
            log.info("{} XML: \n{}", type, xml);
        } catch (Exception e) {
            log.error("Erro ao logar a mensagem SOAP", e);
        }
    }
}

