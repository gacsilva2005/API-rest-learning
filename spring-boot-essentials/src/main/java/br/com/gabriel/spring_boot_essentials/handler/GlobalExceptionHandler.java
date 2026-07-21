package br.com.gabriel.spring_boot_essentials.handler;

import br.com.gabriel.spring_boot_essentials.exception.ErrorResponse;
import br.com.gabriel.spring_boot_essentials.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** Been que indica ao Spring que esta classe será responsável por tratar
 *  exceções lançadas por qualquer controller. **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {

        // Cria um objeto contendo as informações que vão pra API
        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        // Retorna uma resposta HTTP Not Found
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    //Tratamento para erros genéricos não mapeados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        // Retorna uma resposta HTTP Erro interno de servidor
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}