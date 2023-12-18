package com.esaa.corp.stock.consumer._test.handlers.routes;


import com.esaa.corp.stock.consumer._test.model.TestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GetTestRoute {

    @Bean
    public RouterFunction<ServerResponse> testEndpoint(){
        return RouterFunctions.route(
                RequestPredicates.GET("/test"),
                request ->
                   ServerResponse.ok()
                           .contentType(MediaType.APPLICATION_JSON)
                           .bodyValue(new TestDTO("hello app2"))
        );
    }
}
