package com.formento.reactivex.reactivexexamples.person.infra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ControllerAdvice//(basePackageClasses = PersonExceptionHandler.class)
@RequestMapping(produces = "application/vnd.error+json")
public class PersonExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(PersonExceptionHandler.class);

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public PersonError notFoundException(final PersonNotFoundException e) {
        final String id = e.getId().toString();
        LOGGER.error("Person not found by id {}", id);
        return new PersonError(String.format("Person not found by id %s", id));
    }

    static class PersonError implements Serializable {

        private final String message;

        PersonError(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

}
