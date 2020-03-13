package com.esis.esempioSpring.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
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

import com.esis.esempioSpring.dto.AttivitaDTO;
import com.esis.esempioSpring.service.AttivitaService;

@RestController
@RequestMapping("attivita")
public class AttivitaController {
	@Autowired
	private AttivitaService attivitaService;

	private AttivitaService getService() {
		System.out.println("service= " + attivitaService);
		return attivitaService;
	}

	@Transactional
	@PostMapping(value = "")
//insert
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody AttivitaDTO dto) {
		System.out.println("ATTIVITA CONTROLLER ");
		getService().create(dto);
	}

	@Transactional
//update
	@PutMapping("")
	public void edit(@RequestBody AttivitaDTO dto) {
		getService().edit(dto);
	}

	@Transactional()
	@DeleteMapping("{id}")
	public void remove(@PathVariable Integer id) {
		getService().remove(id);
	}

	@Transactional(readOnly = true)
	@GetMapping("{id}")
	public AttivitaDTO find(@PathVariable Integer id) {
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
	public List<AttivitaDTO> findAll() {
//		System.out.println("SIL findAll");
		return getService().findAll();
	}

	@Transactional(readOnly = true)
	@GetMapping("count")
	public Integer countRTestataOrdineST() {
		return getService().count();
	}

	/* ////////////////CREATO DA NOI/////////////////////// */
	@Transactional(readOnly = true)
	@GetMapping("istruttori/{id}")
	public List<AttivitaDTO> findByIstruttore(@PathVariable Integer id) {
//		System.out.println ("findByIstruttore"); //("SIL find id=" + id);
		return getService().findByIstruttore(id);
	}

	// trova l'attivita che ha come istruttore quello con il congome indicato,
	// creato da noi
	@Transactional(readOnly = true)
	@GetMapping("cognomeIstruttore/{cognomeIstruttore}")
	public List<AttivitaDTO> findByCognomeIstruttore(@PathVariable String cognomeIstruttore) {
		return getService().findByCognomeIstruttoreQuery(cognomeIstruttore);
	}

	@Transactional(readOnly = true)
	@GetMapping("{from}/{to}")
	public List<AttivitaDTO> findRange(@PathVariable Integer from, @PathVariable Integer to) {
		return getService().findRange(from, to);
	}

	@Transactional(readOnly = true)
	@GetMapping("{from}/{to}/{id}")
	public List<AttivitaDTO> findRange(@PathVariable Timestamp from, @PathVariable Timestamp to,
			@PathVariable Integer id) {
		return getService().findRange(from, to, id);
	}

//	fatta da noi
	@Transactional(readOnly = true)
	@GetMapping("istruttori/{idIstruttore}/{from}/{to}")
	public List<AttivitaDTO> findIstruttoreDate(@PathVariable Integer idIstruttore, @PathVariable String from,
			@PathVariable String to) throws ParseException {
		System.out.println("\nATTIVITA CONTRONLLER ");
		System.out.print("id: " + idIstruttore + ", from: " + from + ", to: " + to);

//		return null;
		return getService().findIstruttoreDate(idIstruttore, from, to);
	}

	@Transactional(readOnly = true)
	@GetMapping("attivi")
//	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET /* , value = "/foo/bar" */)
//	@ResponseBody
	public List<AttivitaDTO> findAllAttivi() {
//		System.out.println("SIL findAll");
		return getService().findAllAttivi();
	}

}
