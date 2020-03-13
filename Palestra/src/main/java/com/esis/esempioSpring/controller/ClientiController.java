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
import com.esis.esempioSpring.dto.ClientiDTO;
import com.esis.esempioSpring.service.AccessiService;
import com.esis.esempioSpring.service.ClientiService;

@RestController
@RequestMapping("clienti")
public class ClientiController {

	@Autowired
	private ClientiService clientiService;

	private ClientiService getService() {
		System.out.println("service= " + clientiService);
		return clientiService;
	}

	@Transactional
	@PostMapping(value = "")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody ClientiDTO dto) {
		getService().create(dto);
	}

	@Transactional
	@PutMapping("")
	public void edit(@RequestBody ClientiDTO dto) {
		getService().edit(dto);
	}

	@Transactional()
	@DeleteMapping("{id}")
	public void remove(@PathVariable Integer id) {
		getService().remove(id);
	}

	@Transactional(readOnly = true)
	@GetMapping("{id}")
	public ClientiDTO find(@PathVariable Integer id) {
		System.out.println("SIL find id=" + id);
		return getService().find(id);
	}

	@Transactional(readOnly = true)
	@GetMapping("")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			// MediaType.APPLICATION_JSON_VALUTestataOrdine
			// APPLICATION_XML_VALUTestataOrdine
			method = RequestMethod.GET /* , value = "/foo/bar" */)
	@ResponseBody
	public List<ClientiDTO> findAll() {
		System.out.println("SIL findAll");
		return getService().findAll();
	}

	@Transactional(readOnly = true)
	@GetMapping("{from}/{to}")
	public List<ClientiDTO> findRange(@PathVariable Integer from, @PathVariable Integer to) {
		return getService().findRange(from, to);
	}

	@Transactional(readOnly = true)
	@GetMapping("count")
	public Integer countRTestataOrdineST() {
		return getService().count();
	}

}
