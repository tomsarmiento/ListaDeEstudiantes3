package springdata2.studentslist.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springdata2.studentslist.models.Contact;
import springdata2.studentslist.models.Dorm;
import springdata2.studentslist.models.Student;
import springdata2.studentslist.models.Class;
import springdata2.studentslist.services.StudentsListService;

@Controller
public class StudentsListController {
	private final StudentsListService stListServ;
	
	public StudentsListController(StudentsListService stListServ) {
		this.stListServ = stListServ;
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("students", stListServ.allStudents());
		model.addAttribute("dorms", stListServ.allDorms());
		model.addAttribute("firstDorm", stListServ.allDorms().get(0).getId());
		model.addAttribute("firstClass", stListServ.allClasses().get(0).getId());
		model.addAttribute("classes", stListServ.allClasses());
		return "studentslist/index.jsp";
	}
	
	@RequestMapping("/students/new") // I'm afraid this might not work
	public String createStudent(@ModelAttribute Student s) {
		return "studentslist/newstudent.jsp";
	}
	
	@RequestMapping("/students/create") // I'm saving a student through a ModelAttribute in a GET method. Never done this before. Kinda scares me
	public String saveStudent(@Valid @ModelAttribute Student s, BindingResult result) {
		if(result.hasErrors()) {
			return "studentslist/newstudent.jsp";
		}
		else {
			stListServ.createStudent(s);
			return "redirect:/index";
		}	
	}
	
	@RequestMapping("/contact/new")
	public String createContact(@ModelAttribute Contact c, Model model) {
		model.addAttribute("students", stListServ.findByContactNull());
		return "studentslist/newcontact.jsp";
	}
	
	@RequestMapping("/contact/create")
	public String saveContact(@Valid @ModelAttribute Contact c, BindingResult result) {
		if(result.hasErrors()) {
			return "studentslist/newcontact.jsp";
		}
		else {
			stListServ.createContact(c);
			return "redirect:/index";
		}
	}
	
	@RequestMapping("/dorms/new")
	public String createDorm(@ModelAttribute Dorm d) {
		return "studentslist/newdorm.jsp";
	}
	
	@RequestMapping("/dorms/create")
	public String saveDorm(@Valid @ModelAttribute Dorm d, BindingResult rslt) {
		if(rslt.hasErrors()) {
			return "studentlist/newdorm.jsp";
		}
		else {
			stListServ.createDorm(d);
			return "redirect:/index";
		}
	}
	
	@RequestMapping("/dorms/{sDormId}")
	public String dormDetails(@PathVariable String sDormId, Model model) {
		Long lDormId = Long.parseLong(sDormId);
		
		model.addAttribute("dorm", stListServ.findDormById(lDormId));
		model.addAttribute("students", stListServ.findByDormNull());
		return "studentslist/dormdetails.jsp";
	}
	
	@RequestMapping("/dorms/{dormId}/add")
	public String addStudentToDorm(@PathVariable Long dormId, @RequestParam("student") Long studentId) {
		stListServ.addStudentToDorm(studentId, dormId);
		return "redirect:/dorms/"+dormId;
	}
	
	@RequestMapping("/dorms/{dormId}/remove")
	public String removeStudentFromDorm(@PathVariable Long dormId, @RequestParam("student") Long studentId) {
		System.out.println("Dormitorio id:"+dormId+" Estudiante id:"+studentId);
		stListServ.removeStudentFromDorm(studentId, dormId);
		return "redirect:/dorms/"+dormId;
	}
	
	@RequestMapping("/classes/new")
	public String newClass(@ModelAttribute Class c) {
		return "studentslist/newclass.jsp";
	}
	
	@RequestMapping(value="/classes/create", method=RequestMethod.GET)
	public String createClass(@Valid @ModelAttribute Class c, BindingResult rslt) {
		if(rslt.hasErrors()) {
			return "studentslist/newclass.jsp";
		}
		else {
			stListServ.createClass(c);
			return "redirect:/index";
		}
	}
	
	@RequestMapping("/students/{stId}")
	public String showStudent(@PathVariable Long stId, Model model) {
		model.addAttribute("student", stListServ.findStudentById(stId));
		model.addAttribute("unregisteredClasses", stListServ.unregisteredClasses(stId));
		return "studentslist/showstudent.jsp";
	}
	
	@RequestMapping(value="/students/{stId}/add", method=RequestMethod.GET)
	public String addStudentToClass(@PathVariable Long stId, @RequestParam("id") Long clId) {
		stListServ.addStudentToClass(stId, clId);
		return "redirect:/students/"+stId;
	}
	
	@RequestMapping("/classes/{clId}")
	public String showClass(@PathVariable Long clId, Model model) {
		model.addAttribute("clase", stListServ.findClassById(clId));
		return "studentslist/showclass.jsp";
	}
	
	@RequestMapping(value="/students/{stId}/remove", method=RequestMethod.GET)
	public String removeStudentFromClass(@PathVariable Long stId, @RequestParam("id") Long clId) {
		stListServ.removeStudentFromClass(stId, clId);
		return "redirect:/students/"+stId;
	}
	
	
}
