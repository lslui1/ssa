package ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ssa.entity.Professor;
import ssa.service.IProfessorService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class ProfessorController {

	@Autowired
	private IProfessorService professorService;
	
	
	@RequestMapping(value= "/professor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> getProfessorById(@PathVariable("id") Integer id) {
        Professor professor = professorService.getProfessorById(id);
        return new ResponseEntity<Professor>(professor, HttpStatus.OK);
    }
		

	
}
