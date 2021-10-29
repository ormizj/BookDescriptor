package com.jbc.exception.descriptorException;

import com.jbc.exception.CustomException;
import com.jbc.util.exceptionUtil.ExceptionErrorCodeUtil;

/*exception if the "Descriptor" is, or contains null*/
public class DescriptorNullException extends CustomException {

	/* serial */
	private static final long serialVersionUID = 3345671928382340535L;

	/* constructor */
	public DescriptorNullException() {
		errorCode = ExceptionErrorCodeUtil.DescriptorNotFoundException.toString();
	}

	@Override
	public String toString() {
		return "The \"Descriptor\" is, or contains \"null\",please insantiate it.";
	}
	
}
