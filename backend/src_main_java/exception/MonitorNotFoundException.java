package app.mysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MonitorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MonitorNotFoundException(String response) {
		super(response);
	}
}
