package ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value= "/professors", method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> professors = professorService.getAllProfessors();
        return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
    }
	
	@RequestMapping(value="/SearchProfessorByLastName/{last_name}", method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> searchProfessorByProfessorLastName(@PathVariable("last_name") String last_name) {
		List<Professor> professors = professorService.searchProfessorByProfessorLastName(last_name);
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/professor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> getProfessorById(@PathVariable("id") Integer id) {
        Professor professor = professorService.getProfessorById(id);
        return new ResponseEntity<Professor>(professor, HttpStatus.OK);
    }
		
	@RequestMapping(value= "/professorbyfnamelname/{fname}/{lname}", method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> getProfessorByFnameLname(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
        List<Professor> professor = professorService.getProfessorByFnameLname(fname, lname);
        return new ResponseEntity<List<Professor>>(professor, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/addprofessor", method = RequestMethod.POST)
    public ResponseEntity<Void> addProfessor(@RequestBody Professor professor) {
		Professor newprofessor = new Professor();
		newprofessor.setFirst_name(professor.getFirst_name());
		newprofessor.setLast_name(professor.getLast_name());
		newprofessor.setUniversity_id(professor.getUniversity_id());
		System.out.println("Instantiated:" + newprofessor);

        boolean condition = professorService.addProfessor(newprofessor);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
}
