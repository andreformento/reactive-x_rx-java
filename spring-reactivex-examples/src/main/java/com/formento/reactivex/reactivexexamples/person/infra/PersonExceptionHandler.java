package com.formento.reactivex.reactivexexamples.person.infra;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice//(basePackageClasses = PersonExceptionHandler.class)
@RequestMapping(produces = "application/vnd.error+json")
public class PersonExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(PersonExceptionHandler.class);

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public VndErrors notFoundException(final PersonNotFoundException e) {
        final String id = e.getId().toString();
        LOGGER.error("Person not found by id {}", id);
        return new VndErrors("a", "b");
    }

    private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }

}
