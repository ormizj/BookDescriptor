package com.jbc.exception;

import lombok.Getter;
import lombok.Setter;

/*general exceptions, all system exceptions will extend this exception*/
@Getter
@Setter
public abstract class CustomException extends Exception {

	/* serial */
	private static final long serialVersionUID = 6196041472980746758L;

	/* attributes */
	protected String errorCode;

}
