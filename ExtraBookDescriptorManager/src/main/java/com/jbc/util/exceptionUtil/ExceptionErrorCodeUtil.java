package com.jbc.util.exceptionUtil;

/*enum that contains the exceptions error codes*/
public enum ExceptionErrorCodeUtil {

	DescriptorAlreadyExistsException("DSC-001.001"), DescriptorNotFoundException("DSC-001.002"),
	DescriptorNullException("DSC-001.003");

	/* attributes */
	private final String ERROR_CODE;

	/* constructor */
	ExceptionErrorCodeUtil(String errorCode) {
		ERROR_CODE = errorCode;
	}

	/* toString */
	@Override
	public String toString() {
		return ERROR_CODE;
	}

}
