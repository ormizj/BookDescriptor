package com.jbc.exception.descriptorException;

import com.jbc.exception.CustomException;
import com.jbc.util.exceptionUtil.ExceptionErrorCodeUtil;

/*exception if a "Descriptor" already exists*/
public class DescriptorAlreadyExistsException extends CustomException {

	/* serial */
	private static final long serialVersionUID = 4335427104843699141L;
	private String bookName;

	/* constructor */
	public DescriptorAlreadyExistsException(String bookName) {
		errorCode = ExceptionErrorCodeUtil.DescriptorAlreadyExistsException.toString();
		this.bookName = bookName;
	}

	/* toString */
	@Override
	public String toString() {
		return "The book with the name: " + bookName + " already exists, we can't have duplicate book names.";
	}

}
