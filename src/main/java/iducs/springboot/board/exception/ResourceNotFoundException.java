package iducs.springboot.board.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends NoSuchElementException {
	private static final long serialVersionUID = 1L;
	
    public ResourceNotFoundException(String message){
        super(message);
    }
}