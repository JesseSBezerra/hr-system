package br.com.jdsb.userapi.service.exceptions;

public class ObjectNotFoundException extends  RuntimeException{

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
