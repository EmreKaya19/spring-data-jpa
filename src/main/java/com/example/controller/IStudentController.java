package com.example.controller;

import java.util.List;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.student;

public interface IStudentController {
	public DtoStudent saveStudent(DtoStudentIU studentIU);
	
	public List<DtoStudent> getallStudents();
	public DtoStudent getStudent(Integer id);
	public void deletestudent(Integer id);
public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU );
}
