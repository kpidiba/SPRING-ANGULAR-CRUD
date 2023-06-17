package com.simple.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.crud.models.Human;
import com.simple.crud.services.HumanService;

@RestController
public class HumanController {
    @Autowired
    HumanService service;
    // NOTE: affichage de index
    @GetMapping
    public ResponseEntity<List<Human>> index() {
        try {
            List<Human> humans  = this.service.getAll();
            return ResponseEntity.of(Optional.of(humans));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value="/register")
    public ResponseEntity<Human> addUEntity(@RequestBody Human human) {
        try {
			this.service.addHuman(human);
			return ResponseEntity.status(HttpStatus.CREATED).body(human);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<Human> deleteBook(@PathVariable("id") Integer id){
		//NOTE:delete BOOK
        Human human = this.service.findById(id);
        try {
                    this.service.deleteHuman(human);
                    return ResponseEntity.status(HttpStatus.OK).body(human);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

    //NOTE: process PUT request
    @PutMapping(value="/update/{id}")
	public ResponseEntity<Human> putBook(@PathVariable("id") Integer id, @RequestBody Human human) {
        try {
			this.service.updateHuman(human, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(human);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
