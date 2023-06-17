package com.simple.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.crud.dao.HumanRepository;
import com.simple.crud.models.Human;

@Service
public class HumanService {
    @Autowired
    HumanRepository humanRepository;

    public Human addHuman(Human human) {
        return this.humanRepository.save(human);
    }

    public List<Human> getAll() {
        return (List<Human>) this.humanRepository.findAll();
    }

    public Human findById(long id) {
        return this.humanRepository.findById(id);
    }

    public void deleteHuman(Human human) {
        this.humanRepository.delete(human);
    }

    public Human updateHuman(Human human,Integer id){
		human.setId(id);
		humanRepository.save(human);
		return human;
	}
}
