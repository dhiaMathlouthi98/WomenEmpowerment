package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Report;
import tn.esprit.spring.service.ReportService;

@Api(tags = "Report Management")
@RestController
@RequestMapping("/Report")
public class ReportRestController {

	@Autowired
	 private ReportService repSer ;
	
	@GetMapping("/retrieve-all-reps")
	@ApiOperation(value = "Récupérer la liste des Reports ")
	@ResponseBody
	public List<Report> getReports()
	{
		List<Report> reps = repSer.retrieveallreps();
		return reps;
	}
	
	@GetMapping("/retrieve-rep/{idReport}")
	@ApiOperation(value = "recuperer un Report  ")
	@ResponseBody
	public Report getReport (@PathVariable("idReport") Long idrep)
	{
		return repSer.retrievebyId(idrep);   
	}
	
	@PostMapping("/add-rep")
	@ApiOperation(value = "ajouter un Report ")
	@ResponseBody 
	public Report addReport(@RequestBody Report rep )
	{
		Report r= repSer.addReport(rep);
		return r ; 
		
	}
	@DeleteMapping("/remove-rep/{idReport}")
	@ApiOperation(value = "supprimer un Report ")
	@ResponseBody
	public void removerep(@PathVariable("idReport") Long idreport )
	{
		repSer.deleterepById(idreport);
	}
	
	@PutMapping("/modify-rep")
	@ApiOperation(value = "modifier un Report ")
	@ResponseBody
	public Report modifyReport(@RequestBody Report rep)
	{
		Report r = repSer.updatereport(rep);
		return r ; 
	}
}
