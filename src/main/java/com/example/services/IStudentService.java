package com.example.services;

import java.util.List;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;

public interface IStudentService  {
public DtoStudent saveStudent(DtoStudentIU student);
public List<DtoStudent> getallStudents();
public DtoStudent getStudentbyıd(Integer id);
public void deleteStudent(Integer id);
public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);

}
