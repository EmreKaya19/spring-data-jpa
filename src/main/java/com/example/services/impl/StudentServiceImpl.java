package com.example.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoStudent;
import com.example.dto.DtoStudentIU;
import com.example.entities.student;
import com.example.repository.StudentRepository;
import com.example.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtostudentıu) {
		DtoStudent response=new DtoStudent();
		student student= new student();
		BeanUtils.copyProperties(dtostudentıu, student);
		student dbStudent=studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
      return response ;	
	}
	
	
	@Override
	public List<DtoStudent> getallStudents() {
		List<DtoStudent> dtoList=new ArrayList<>();
		
		 List<student> studentlist= studentRepository.findallstudentList();
		 for (student student : studentlist) {
			 DtoStudent dtoStudent=new DtoStudent();
			 BeanUtils.copyProperties(student, dtoStudent);
			 dtoList.add(dtoStudent); 
			
		}
		 return dtoList;
	}
	
	
	
	
	@Override
	public DtoStudent getStudentbyıd(Integer id) {
		DtoStudent dto=new DtoStudent();
		Optional<student> optional=studentRepository.findstudentListbyid(id);
if (optional.isPresent()) {
student dbStudent=optional.get();
BeanUtils.copyProperties(dbStudent, dto);
return dto;

}
		return null;
	}
	
	
	@Override
	public void deleteStudent(Integer id) {

		Optional<student> optional=studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
			
		}
	}
	
	
	
	@Override
	public DtoStudent updateStudent(Integer id,  DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent=new DtoStudent();
		Optional<student> opiOptional=studentRepository.findById(id);
		if (opiOptional.isPresent()) {
			student dbStudent=opiOptional.get();
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthofDate(dtoStudentIU.getBirthofDate());
			
		student updatedStudent=	studentRepository.save(dbStudent);
		BeanUtils.copyProperties(updatedStudent, dtoStudent);
					return dtoStudent;

		}
		return null;
	}

}
