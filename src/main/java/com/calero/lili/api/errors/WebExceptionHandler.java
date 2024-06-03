package com.calero.lili.api.errors;

import com.calero.lili.api.dtos.errors.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.text.MessageFormat.format;

@Slf4j
@ControllerAdvice
public class WebExceptionHandler extends ResponseEntityExceptionHandler {
/*
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        log.error("Fatal error: {}", ex.getMessage(), ex);
        ErrorDto error = ErrorDto
                .builder()
                .messages(Collections.singletonList("Existe un error de tipo ConstraintViolationException."))
                .resource(request.getRequestURI())
                .build();
        return buildResponseEntity(INTERNAL_SERVER_ERROR, error);
    }

 */

//    @ExceptionHandler({AlreadyExistsException.class})
//    public ResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException ex, HttpServletRequest request) {
//        ErrorDto error = ErrorDto
//                .builder()
//                .messages(Collections.singletonList(ex.getMessage()))
//                .resource(request.getRequestURI())
//                .build();
//        return buildResponseEntity(CONFLICT, error);
//    }

//    @ExceptionHandler({ReadOnlyException.class})
//    public ResponseEntity<?> handleReadOnlyException(ReadOnlyException ex, HttpServletRequest request) {
//        ErrorDto error = ErrorDto
//                .builder()
//                .messages(Collections.singletonList(ex.getMessage()))
//                .resource(request.getRequestURI())
//                .build();
//        return buildResponseEntity(CONFLICT, error);
//    }

//    @ExceptionHandler({NotFoundException.class})
//    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
//        ErrorDto error = ErrorDto
//                .builder()
//                .messages(Collections.singletonList(ex.getMessage()))
//                .resource(request.getRequestURI())
//                .build();
//        return buildResponseEntity(NOT_FOUND, error);
//    }

//    @Override
//    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> errorMessages = new ArrayList<>();
//        errorMessages.addAll(ex.getBindingResult().getFieldErrors().stream().map(this::serialize).collect(Collectors.toList()));
//        ErrorDto error = ErrorDto
//                .builder()
//                .messages(errorMessages)
//                .resource(((ServletWebRequest) request).getRequest().getRequestURI())
//                .build();
//        return buildResponseEntity(BAD_REQUEST, error);
//    }

    private ResponseEntity buildResponseEntity(HttpStatus httpStatus, ErrorDto error) {
        return new ResponseEntity(error, httpStatus);
    }

    private String serialize(FieldError fieldError) {
        return format("{0}.{1}: {2}", fieldError.getObjectName(), fieldError.getField(), StringUtils.capitalize(fieldError.getDefaultMessage()));
    }

}
