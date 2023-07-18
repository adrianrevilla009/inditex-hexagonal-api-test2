package es.inditex.api.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Product not found")
public class ProductNotFoundException extends RuntimeException {

	private static final Logger logger = LoggerFactory.getLogger(ProductNotFoundException.class);

	@Override
	public void printStackTrace() {
		logger.error("[ERROR] Product not found");
		super.printStackTrace();
	}
}
