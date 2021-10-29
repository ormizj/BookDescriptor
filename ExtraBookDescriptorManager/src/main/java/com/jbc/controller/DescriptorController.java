package com.jbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbc.exception.CustomException;
import com.jbc.message.ExceptionResponse;
import com.jbc.message.SuccessResponse;
import com.jbc.model.Descriptor;
import com.jbc.service.ifc.DescriptorServiceIFC;

/*exposing the descriptor end-points*/
@RestController
@RequestMapping("/descriptor")
public class DescriptorController {

	/* attributes */
	@Autowired
	DescriptorServiceIFC descServ;

	/* REST methods */
	@PostMapping("/create")
	public ResponseEntity<?> createDescriptor(@RequestBody Descriptor descriptor) {
		try {
			return new ResponseEntity<Descriptor>(descServ.createDescriptor(descriptor), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(e.toString(), e.getErrorCode()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateDescriptor(@RequestBody Descriptor descriptor) {
		try {
			return new ResponseEntity<Descriptor>(descServ.updateDescriptor(descriptor), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(e.toString(), e.getErrorCode()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{bookName}")
	public ResponseEntity<?> deleteDescriptor(@PathVariable String bookName) {
		try {
			descServ.deleteDescriptor(bookName);
			return new ResponseEntity<SuccessResponse>(
					new SuccessResponse("The book: " + bookName + " was deleted successfully."), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(e.toString(), e.getErrorCode()),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get-by-name/{bookName}")
	public ResponseEntity<?> getDescriptor(@PathVariable String bookName) {
		try {
			return new ResponseEntity<Descriptor>(descServ.getDescriptor(bookName), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(e.toString(), e.getErrorCode()),
					HttpStatus.BAD_REQUEST);
		}
	}

}
