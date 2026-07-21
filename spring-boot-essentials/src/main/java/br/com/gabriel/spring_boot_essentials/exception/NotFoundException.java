package br.com.gabriel.spring_boot_essentials.exception;

// Cria uma exceção personalizada
public class NotFoundException extends Exception {

    // Construtor que recebe uma mensagem de erro
    public NotFoundException(String message) {
        super(message);
    }
}