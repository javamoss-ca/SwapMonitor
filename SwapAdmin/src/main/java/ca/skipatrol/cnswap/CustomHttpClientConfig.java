package ca.skipatrol.cnswap;
import javax.net.ssl.SSLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import reactor.netty.http.client.HttpClient;

/**
 * Custom http client class which overrides Spring Boot Admin's server default client.<br>
 * The custom client will bypass any SSL Validation by configuring an instance of
 *  {@link InsecureTrustManagerFactory}
 * @author Hanif Rajabali
 * @see <a href="https://codecentric.github.io/spring-boot-admin/current/#_using_mutual_tls">Spring Boot Admin 2.6.2 Using Mutual TLS</a>
 */
@Configuration
public class CustomHttpClientConfig {

    @Bean
    public ClientHttpConnector customHttpClient() throws SSLException {
        SslContext sslContext = SslContextBuilder
              .forClient()
              .trustManager(InsecureTrustManagerFactory.INSTANCE)
              .build();
        HttpClient httpClient = HttpClient.create().secure(
            ssl -> ssl.sslContext(sslContext)
        );
        return new ReactorClientHttpConnector(httpClient);
    }

}