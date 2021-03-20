package app.mysql.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{


	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<ExceptionResponse> generalException(Exception e, WebRequest request) throws Exception {

		ExceptionResponse er = new ExceptionResponse(
				new Date(), 
				e.getMessage(), 
				request.getDescription(false)
				);

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MonitorNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> specificException(MonitorNotFoundException onfex, WebRequest request) throws Exception {

		ExceptionResponse officeNotFound = new ExceptionResponse(
				new Date(), 
				onfex.getMessage(), 
				request.getDescription(false)
				);

		return new ResponseEntity <ExceptionResponse>(officeNotFound, HttpStatus.NOT_FOUND);
	}
}
