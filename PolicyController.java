package com.example.demo.controller;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import com.example.demo.model.Benefits;
import com.example.demo.model.LoadFile;
import com.example.demo.model.Policy;
import com.example.demo.requests.AddBenefitToPolicyRequestForm;
import com.example.demo.service.PolicyServices;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/policy")
public class PolicyController {
	
	@Autowired
	PolicyServices policyServices;
	

	@GetMapping("/")
	public List<Policy> getAllPolicy(){
		return policyServices.getAllPolicy();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Policy> getById(@PathVariable Long id) {
		return policyServices.getPolicyById(id);
	}
	
	@PostMapping("/")
	public Policy insertPolicy(@RequestBody Policy policy) 
		//	@RequestParam("file")MultipartFile file) throws IOException
	{
		//policyServices.addFile(file, policy.getPolicyId());
		return policyServices.addPolicy(policy);
	}
	
	@DeleteMapping("/")
	public String deletePolicy(@PathVariable Long id) {
		policyServices.deletePolicy(id);
		return "Record deleted successfully";
	}
	
	@PutMapping("/addBenefitToPolicy")
	public String addBenefitToPolicy(@RequestBody AddBenefitToPolicyRequestForm form) throws Exception {
		policyServices.addBenefitToPolicy(form);
		return "updated the benefit list";
	}
	
	@GetMapping("/benefitsEnquiry/{aadhar}")
	public Optional<Policy> getAllBenefits(@PathVariable Long aadhar){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity
				(
				"http://localhost:5000/api/member/getPolicyId/" + aadhar, 
				String.class
				);
		return policyServices.getPolicyById(Long.parseLong(response.getBody()));
		
	}
	
	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,
    								@RequestParam("policyId") Long id) throws IOException {
        return new ResponseEntity<>(policyServices.addFile(file, id), HttpStatus.OK);
    }
	
	  @GetMapping("/download/{id}")
	    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
	        LoadFile loadFile = policyServices.downloadFile(id);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
	                .body(new ByteArrayResource(loadFile.getFile()));
	    }

}
