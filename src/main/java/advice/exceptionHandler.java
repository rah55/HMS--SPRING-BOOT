package advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import exception.globalException;

@RestControllerAdvice  
public class exceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //THIS NOTATION TELL THE STATUS IF ERROR IS OCCUR
	@ExceptionHandler(MethodArgumentNotValidException.class)  //THIS NOTATION HANDLE THE GIVEN EXCEPTION
	
	public Map<String,String> handleInvalidArg(MethodArgumentNotValidException ex){  //THIS HANDLE THE EXCEPTION IF THE USER ENTER THE INVALID ARGUMENT 
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(globalException.class)
	
	public Map<String,String> handleGlobal(globalException ge){ // THIS WILL HANDLE THE GLOBAL EXCEPTION
		
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("Error",ge.getMessage());    // ERROR WILL PRINT ON THE SCREEN IF THE ERROR IS FOUND
		return errorMap;
	}
}
