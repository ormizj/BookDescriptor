package com.jbc.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Descriptor implements Serializable {

	/* serial */
	private static final long serialVersionUID = -8079585289846515040L;
	/* attributes */
	private String bookName;
	private String authorName;
	private String description;

	/* constructor */
	public Descriptor(String bookName, String authorName, String description) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
	}

	/* equals & hashcode (By: String bookName) */
	/* equals & hashcode with "lower-case" to insure the book names are Unique */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Descriptor other = (Descriptor) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.toLowerCase().equals(other.bookName.toLowerCase()))
			return false;
		return true;
	}

}
