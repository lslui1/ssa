package ssa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ssa.entity.University;
import ssa.service.IUniversityService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class UniversityController {

	@Autowired
	private IUniversityService universityService;
	
	@RequestMapping(value= "/universities", method = RequestMethod.GET)
    public ResponseEntity<List<University>> getAllUniversities() {
        List<University> universities = universityService.getAllUniversities();
        return new ResponseEntity<List<University>>(universities, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/university/{id}", method = RequestMethod.GET)
    public ResponseEntity<University> getUniversityById(@PathVariable("id") Integer id) {
        University university = universityService.getUniversityById(id);
        return new ResponseEntity<University>(university, HttpStatus.OK);
    }
		
	@RequestMapping(value= "/universitybyname/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<University>> getUniversityByName(@PathVariable("name") String name) {
        List<University> university = universityService.getUniversityByName(name);
        return new ResponseEntity<List<University>>(university, HttpStatus.OK);
    }
	
	
}
