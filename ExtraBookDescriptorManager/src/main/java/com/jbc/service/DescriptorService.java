package com.jbc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jbc.exception.descriptorException.DescriptorAlreadyExistsException;
import com.jbc.exception.descriptorException.DescriptorNotFoundException;
import com.jbc.exception.descriptorException.DescriptorNullException;
import com.jbc.model.Descriptor;
import com.jbc.service.ifc.DescriptorServiceIFC;

@Service
public class DescriptorService implements DescriptorServiceIFC {

	/* attributes */
	@Value("${file.directory}")
	private String fileDirectory;

	/* methods */
	/* creates a descriptor */
	@Override
	public Descriptor createDescriptor(Descriptor descriptor)
			throws DescriptorAlreadyExistsException, DescriptorNullException {
		checkDescriptorNull(descriptor);
		try {
			// reading the "descriptor" (to check if it exists)
			// if it exists, it will reach the "throw"
			// if it doesn't exist, it will reach the "catch" block
			readDescriptorFile(descriptor.getBookName());
			throw new DescriptorAlreadyExistsException(descriptor.getBookName());
		} catch (IOException e) {
			try {
				// writing a new "descriptor" (reaching here means, a "descriptor" with the name
				// doesn't exists)
				writeDescriptorFile(descriptor);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return descriptor;
	}

	/* updates a descriptor by name */
	@Override
	public Descriptor updateDescriptor(Descriptor descriptor)
			throws DescriptorNullException, DescriptorNotFoundException {
		checkDescriptorNull(descriptor);
		try {
			// reading the "descriptor" (to check if it exists)
			// if it exists, it will reach the "throw"
			// if it doesn't exist, it will continue to update the "descriptor"
			readDescriptorFile(descriptor.getBookName());
			deleteDescriptorFile(descriptor.getBookName());
			writeDescriptorFile(descriptor);
		} catch (IOException e) {
			throw new DescriptorNotFoundException(descriptor.getBookName());
		}
		return descriptor;
	}

	/* deletes a descriptor */
	@Override
	public void deleteDescriptor(String bookName) throws DescriptorNotFoundException, DescriptorNullException {
		if (bookName == null)
			throw new DescriptorNullException();
		try {
			readDescriptorFile(bookName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new DescriptorNotFoundException(bookName);
		}
		deleteDescriptorFile(bookName);
	}

	/* gets a descriptor by name */
	@Override
	public Descriptor getDescriptor(String bookName) throws DescriptorNotFoundException, DescriptorNullException {
		if (bookName == null)
			throw new DescriptorNullException();
		try {
			return readDescriptorFile(bookName);
		} catch (IOException e) {
			throw new DescriptorNotFoundException(bookName);
		}
	}

	/* helper method, ensuring there are no nulls in the descriptor instance */
	private void checkDescriptorNull(Descriptor descriptor) throws DescriptorNullException {
		if (descriptor == null || descriptor.getBookName() == null || descriptor.getAuthorName() == null
				|| descriptor.getDescription() == null) {
			throw new DescriptorNullException();
		}
	}

	/* helper method, to write the descriptor as file */
	private void writeDescriptorFile(Descriptor descriptor) throws IOException {
		FileOutputStream data = new FileOutputStream(fileDirectory + descriptor.getBookName() + ".txt");
		ObjectOutputStream obj = new ObjectOutputStream(data);
		obj.writeObject(descriptor);
		data.close();
		obj.close();
	}

	/* helper method, to read the descriptor from a file */
	private Descriptor readDescriptorFile(String bookName) throws IOException {
		FileInputStream data = new FileInputStream(fileDirectory + bookName + ".txt");
		ObjectInputStream obj = new ObjectInputStream(data);
		Descriptor descriptor = null;
		try {
			descriptor = (Descriptor) obj.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		data.close();
		obj.close();
		return descriptor;
	}

	/* helper method, to delete the descriptor's file */
	private void deleteDescriptorFile(String bookName) {
		File file = new File(fileDirectory + bookName + ".txt");
		file.delete();
	}

}
