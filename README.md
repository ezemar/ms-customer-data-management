# ms-customer-data-management

Micro-serviço que retorna informações de clientes

## Informações e observações sobre o projeto

> Nome artefato: ms-customer-data-management
> Versão Java: 17
> Versão SpringBoot: 3.4.2
> Contrato WSDL do adapter: ./src/main/resources/wsdl/WSSysmap
> MOCK WebService SOAP: ./ws-SysMap-soapui-project.xml

## Dependências Maven

**Dependências do plugin JaxB que gera os Stubs:**

```
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-xjc</artifactId>
</dependency>

<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>3.0.0</version>
</dependency>

<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
```

⚠️ Verificar sempre a compatilibilidade entre as verões de cada dependência e versão de Java. Em caso de impatibilidade o plugin não funcionará corretamente.


**Implementação do WebServiceTemplate:**

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web-services</artifactId>
</dependency>
Implementação no AdapterSOAP
<dependency>
    <groupId>com.sun.activation</groupId>
    <artifactId>jakarta.activation</artifactId>
    <version>2.0.1</version>
</dependency>
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-soap-jakarta</artifactId>
    <version>13.1</version>
</dependency>
```

⚠️ Verificar sempre a compatilibilidade entre as verões de cada dependência e versão de Java. Sem essas dependencias não poderá ser possivel a troca de objetos Requets - Response


**Validações na classe Controller**

```
<dependency>
        <groupId>io.swagger.core.v3</groupId>
        <artifactId>swagger-annotations</artifactId>
        <version>2.2.28</version>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>   
```


## Como os Stubs (representação Java do XSD) foram criados?

Foi utilizado o plugin JAXB 0.14.0 para criar as classes Stubs

```
<!-- O plugin abaixo é executado toda vez que o arquivo pom.xml é salvo (em alguns casos precisa rodar "mvn clean install" ou "mvn compile") -->
<!--
<plugin>
    <groupId>org.jvnet.jaxb2.maven2</groupId>
    <artifactId>maven-jaxb2-plugin</artifactId>
   <version>0.14.0</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <schemaLanguage>WSDL</schemaLanguage>
        <cleanPackageDirectories>false</cleanPackageDirectories>
        <generateDirectory>${project.basedir}/src/main/java/</generateDirectory>
        <outputDirectory></outputDirectory>
                <generatePackage>br.com.sysmap.dip.infrastructure.soap.wsSysmap.stub</generatePackage>
        <schemas>
            <schema>
                <url>http://localhost:7001/demo/ws?WSDL</url>
            </schema>
        </schemas>
    </configuration>
</plugin>
```
> ⚠️ Antes de salvar ou compilar o pom.xml você precisar ter certeza de que existe um web-service sendo exposto no endereço especificado
>
> ⚠️ Verificar sempre a compatilibilidade entre as versões do plugin e versão de Java. Em caso de imcompatibilidade os stubs podem não ser criados / criados corretamente
>

**Correção na importação de pacotes javax / jakarta**

>⚠️ Por padrão, os stubs são gerados com referencias aos pacotes do javax. Ao implementar os stubs no adapter e ao tentar fazer o marshmaller isto ocasiona um problema de compatibilidade entre jakarta e javax, por isso foi necessario o seguinte ajuste: Todos os pacotes que antes eram importados como javax.xml.bind.annotation.* passaram a serem importados do pacote jakarta.xml.bind.* como mostra a seguinte imagem:

    1. 

![Captura de tela 2025-02-26 083644](https://github.com/user-attachments/assets/e8eb37f2-722b-4e85-aa21-27aafbc5c02a)


    2. 

![Captura de tela 2025-02-26 083509](https://github.com/user-attachments/assets/21f5daca-4a64-467a-9e71-a05b26a386ff)


Como rodar este projeto?
    1. Clonar projeto 
git clone https://github.com/ezemar/ms-customer-data-management
    2. Compilar no Maven 
mvn clean package
    4. Criar e montar imagem docker: 
docker build -t sysmap/service-image .
docker-compose up --build
    5. Importar e executar MockService 
Clique em Import:

Selecionar o arquivo ws-SysMap-soapui-project.xml

Duplo clique no elemento ws-SysMap-binding MockService

Clicar em Play para inicializar o mock:

Mock inicializado:

