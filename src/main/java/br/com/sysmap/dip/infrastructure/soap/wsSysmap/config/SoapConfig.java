package br.com.sysmap.dip.infrastructure.soap.wsSysmap.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapConfig {

    @Value("${spring.webservice.wsSysmap.uri}")
    private String uri;

    @Value("${spring.webservice.wsSysmap.class.package}")
    private String classPackage;

    @Bean
    @Qualifier("webServiceTemplateSysmap")
    public WebServiceTemplate webServiceTemplateSysmap(@Qualifier("webServiceMarshallerSysmap") Jaxb2Marshaller marshaller) {

        WebServiceTemplate webservice = new WebServiceTemplate(marshaller);
        webservice.setDefaultUri(uri);
        webservice.setMarshaller(marshaller);

        return webservice;
    }

    @Bean
    @Qualifier("webServiceMarshallerSysmap")
    public Jaxb2Marshaller webServiceMarshallerSysmap() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(classPackage);
        return marshaller;
    }
}
