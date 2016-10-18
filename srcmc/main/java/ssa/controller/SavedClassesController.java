package ssa.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssa.entity.Review;
import ssa.entity.SavedClasses;
import ssa.service.ISavedClassesService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class SavedClassesController {
	
	@Autowired
	private ISavedClassesService SavedClassesService;
	
	@RequestMapping(value= "/savedclasses/{login_id}", method = RequestMethod.GET)
    public ResponseEntity<List<SavedClasses>> getSavedClassesById(@PathVariable("login_id") int login_id) {
        List<SavedClasses> savedClasses = SavedClassesService.getSavedClassesById(login_id);
        return new ResponseEntity<List<SavedClasses>>(savedClasses, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/deletesavedclass/{id}", method = RequestMethod.GET)
    public ResponseEntity<SavedClasses> deleteReview(@PathVariable("id") int id) {
        SavedClassesService.deleteSavedClass(id);
        return new ResponseEntity<SavedClasses>(HttpStatus.OK);
    }
	

	@RequestMapping(value= "/insertsavedclass/", method = RequestMethod.POST)
	public ResponseEntity<Void> insertSavedClass(@RequestBody SavedClasses savedClass) {
		SavedClassesService.insertSavedClass(savedClass);
	    return new ResponseEntity<Void>(HttpStatus.OK);    
    }
	
}
