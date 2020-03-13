package com.esis.esempioSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esis.esempioSpring.dto.AccessiDTO;
import com.esis.esempioSpring.service.AccessiService;

@RestController
@RequestMapping("accessi") // vogliamo che il cliente richiami il tutto nell'url con "ordine"
public class AccessiController {

	@Autowired // istanzia un oggetto di tipo TestataOrdineService nella variabile
				// testataOrdineService
	private AccessiService accessiService;

	private AccessiService getService() {
		System.out.println("service= " + accessiService);
		return accessiService;
	}

	@Transactional
	@PostMapping(value = "")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody AccessiDTO dto) {
		System.out.println("dto = "+dto);
		System.out.println("dto = "+dto.getUsr());
		System.out.println("dto = "+dto.getPswd());
		getService().create(dto);
	}

	@Transactional
	@PutMapping("")
	public void edit(@RequestBody AccessiDTO dto) {
		getService().edit(dto);
	}

	@Transactional()
	@DeleteMapping("{usr}")
	public void remove(@PathVariable String usr) {
		getService().remove(usr);
	}

	@Transactional(readOnly = true)
	@GetMapping("{id}")
	public AccessiDTO find(@PathVariable String usr) {
		System.out.println("SIL find id=" + usr);
		return getService().find(usr);
	}

	@Transactional(readOnly = true)
	@GetMapping("")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			// MediaType.APPLICATION_JSON_VALUTestataOrdine
			// APPLICATION_XML_VALUTestataOrdine
			method = RequestMethod.GET /* , value = "/foo/bar" */)
	@ResponseBody
	public List<AccessiDTO> findAll() {
		System.out.println("SIL findAll");
		return getService().findAll();
	}

	@Transactional(readOnly = true)
	@GetMapping("{from}/{to}")
	public List<AccessiDTO> findRange(@PathVariable Integer from, @PathVariable Integer to) {
		return getService().findRange(from, to);
	}

	@Transactional(readOnly = true)
	@GetMapping("count")
	public Integer countRTestataOrdineST() {
		return getService().count();
	}

}
