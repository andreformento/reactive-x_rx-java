package com.formento.reactivex.reactivexexamples.person.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> createPersonRouter(final PersonHandler  handler) {
        return route(GET("v2/person/{id}").and(accept(APPLICATION_JSON)), handler::getPersonById);
//                        .andRoute(POST("/person"), handler::createPerson);
    }

}
