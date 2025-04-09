package com.example.dto;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	@NotEmpty(message = "firstname alanı boş olamaz")
	@NotNull(message = "fiirstname alanı null olamaz ")
	@Min(value = 3, message = "en az 3 karakter girmeliydiniz")
	@Max(value = 11, message = "en fazla 11 karakter girilmelidir")
	private String firstName;
	
	@Size(min = 3,max = 30)
	private String lastName;
	private Date birthofDate;

}
