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
import tn.esprit.spring.entities.Candidacy;
 
 
import tn.esprit.spring.service.CandidacyService;

@Api("Candidacy")
@RestController
@RequestMapping("/Candidacy")
public class CandidacyController {
	@Autowired
	private CandidacyService CS;
	
	@GetMapping("/GetAllCandid")
	@ResponseBody
	public List<Candidacy> getCandid()
	{
		List<Candidacy> c = CS.retrieveAll();
		return c;
	}
	
	@GetMapping("/GetCandid/{id}")
	@ResponseBody
	public Candidacy getReact (@PathVariable("id") Long id)
	{
		return CS.retrievebyID(id);   
	}
	
	
	@PostMapping("/Affect/{ido}/{idu}")
	@ResponseBody
	public void ajouterEtAffceterreactionPub( @RequestBody Candidacy Candidacy ,@PathVariable("ido") Long ido,@PathVariable("idu") int idu)
	{
		CS.Affect(Candidacy, ido, idu);
	}

	
	@DeleteMapping("/DeleteCandid/{id}")
	@ResponseBody
	public void removeCandid(@PathVariable("id") Long id )
	{
		CS.deleteCandidacy(id);
	}
	
	@PutMapping("/UpdateCandid")
	@ResponseBody
	public Candidacy UpdateCandid(@RequestBody Candidacy cand)
	{
		
		return CS.updatereCandidacy(cand); 
	}
}
