package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IStudentController;
import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.student;
import com.example.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{
@Autowired
	private IStudentService studentService;
	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU DtostudentIU) {
		return studentService.saveStudent(DtostudentIU);
	}
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getallStudents() {

		return studentService.getallStudents();
	}
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudent(@PathVariable(name = "id") Integer id) {
		return studentService.getStudentbyıd(id);

	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deletestudent(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudent(id);
		
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id") Integer id,@RequestBody DtoStudentIU dtoStudentIU) {
		
		return studentService.updateStudent(id, dtoStudentIU);
	}

}
