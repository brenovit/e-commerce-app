package io.github.brenovit.luvshop.payload.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
	
	private String code;
	private String message;	
}
