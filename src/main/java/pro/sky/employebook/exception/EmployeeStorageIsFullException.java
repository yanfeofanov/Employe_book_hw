package pro.sky.employebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "EmployeeStorageIsFullException")
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message){
        super(message);
    }

}
