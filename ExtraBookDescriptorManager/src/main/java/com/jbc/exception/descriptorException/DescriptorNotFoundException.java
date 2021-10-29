package com.jbc.exception.descriptorException;

import com.jbc.exception.CustomException;
import com.jbc.util.exceptionUtil.ExceptionErrorCodeUtil;

/*exception if a "Descriptor" is not found by "bookName"*/
public class DescriptorNotFoundException extends CustomException {

	/* serial */
	private static final long serialVersionUID = 4598323957282010671L;
	private String bookName;

	/* constructor */
	public DescriptorNotFoundException(String bookName) {
		errorCode = ExceptionErrorCodeUtil.DescriptorNotFoundException.toString();
		this.bookName = bookName;
	}

	/* toString */
	@Override
	public String toString() {
		return "The book with the name: " + bookName + " doesn't exist, make sure the book name is correct.";
	}

}
