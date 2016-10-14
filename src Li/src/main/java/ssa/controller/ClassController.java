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
import ssa.entity.Class;
import ssa.service.IClassService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class ClassController {

	@Autowired
	private IClassService classService;
	
	@RequestMapping(value= "/classesbyprof/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesByProf(@PathVariable("id") Integer instructorId) {
        List<Class> aClass = classService.getAllClassesByProf(instructorId);
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/classesbysubject/{subject}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesBySubject(@PathVariable("subject") String name) {
        List<Class> aClass = classService.getAllClassesBySubject(name);
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/classesbysubjectsection/{subject}/{section}", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClassesBySubjectSection(@PathVariable("subject") String name, @PathVariable("section") Integer section) {
        List<Class> aClass = classService.getAllClassesBySubjectSection(name, section);
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	
	@RequestMapping(value= "/class/{id}", method = RequestMethod.GET)
    public ResponseEntity<Class> getClassById(@PathVariable("id") Integer id) {
        Class aClass = classService.getClassById(id);
        return new ResponseEntity<Class>(aClass, HttpStatus.OK);
    }
		
	@RequestMapping(value= "/addclass", method = RequestMethod.POST)
    public ResponseEntity<Void> addClass(@RequestBody Class aClass) {
		Class newclass = new Class();
		newclass.setName(aClass.getName());
		newclass.setProfessor_id(aClass.getProfessor_id());
		newclass.setUniversity_id(aClass.getUniversity_id());
		newclass.setSection(aClass.getSection());
		System.out.println("Instantiated:" + newclass);

        boolean condition = classService.addClass(newclass);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updateclass", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateClass(@RequestBody Class aClass) {
        classService.updateClass(aClass);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
