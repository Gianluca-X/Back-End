package org.example.exception;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
@ResponseStatus( NOT_FOUND )
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException( String message ) {
        super( message );
    }


}
