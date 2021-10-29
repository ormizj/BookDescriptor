package com.jbc.service.ifc;

import com.jbc.exception.descriptorException.DescriptorAlreadyExistsException;
import com.jbc.exception.descriptorException.DescriptorNotFoundException;
import com.jbc.exception.descriptorException.DescriptorNullException;
import com.jbc.model.Descriptor;

public interface DescriptorServiceIFC {

	public Descriptor createDescriptor(Descriptor descriptor)
			throws DescriptorAlreadyExistsException, DescriptorNullException;

	public Descriptor updateDescriptor(Descriptor descriptor)
			throws DescriptorNotFoundException, DescriptorNullException;

	public Descriptor getDescriptor(String bookName) throws DescriptorNotFoundException, DescriptorNullException;

	public void deleteDescriptor(String bookName) throws DescriptorNotFoundException, DescriptorNullException;

}
