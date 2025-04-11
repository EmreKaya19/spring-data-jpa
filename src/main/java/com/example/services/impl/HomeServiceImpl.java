package com.example.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DtoHome;
import com.example.dto.DtoRoom;
import com.example.entities.Home;
import com.example.entities.Room;
import com.example.repository.HomeRepository;
import com.example.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private HomeRepository homeRepository;

	@Override
	public DtoHome findHomeByİd(Long İd) {
		DtoHome dtoHome=new DtoHome();
		Optional<Home> optional=homeRepository.findById(İd);
		
		if (optional.isEmpty()) {
			return null;
		}
		Home dbhome=optional.get();
		
		List<Room> dbrooms=optional.get().getRooms();
		
		BeanUtils.copyProperties(dbhome, dtoHome);
		if (dbrooms!=null && !dbrooms.isEmpty()) {
			for (Room room : dbrooms) {
				DtoRoom dtoRoom=new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRooms().add(dtoRoom);
			}
			
		}
		 
		
		return dtoHome;
	}
	
	
}
