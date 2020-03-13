package com.esis.esempioSpring.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.esis.esempioSpring.dto.AttivitaDTO;
import com.esis.esempioSpring.entities.Attivita;
import com.esis.esempioSpring.repository.AttivitaRepository;

@Service
public class AttivitaService {
	@Autowired
	AttivitaRepository attivitaRepository;

	public List<AttivitaDTO> findAll() {
		List<AttivitaDTO> AttivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findAllBySelect();
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				AttivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return AttivitaDTO;
	}

	////////////////// create da noi/////////////////

	public List<AttivitaDTO> findAllAttivi() {
		List<AttivitaDTO> AttivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findAllBySelectAttivi();
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				AttivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return AttivitaDTO;
	}

	public List<AttivitaDTO> findByIstruttore(Integer id) {
		List<AttivitaDTO> attivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findByIstruttore(id);
		System.out.println("ATTIVITA SERVICE");
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				attivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return attivitaDTO;
	}

	public List<AttivitaDTO> findByCognomeIstruttore(String cognome) {
		List<AttivitaDTO> attivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findByCognomeIstruttore(cognome);
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				attivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return attivitaDTO;
	}

	public List<AttivitaDTO> findByCognomeIstruttoreQuery(String cognome) {
		List<AttivitaDTO> attivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findByCognomeIstruttoreQuery(cognome);
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				attivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return attivitaDTO;
	}

	public List<AttivitaDTO> findIstruttoreDate(Integer idIstruttore, String from, String to) throws ParseException {
		List<AttivitaDTO> attivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findIstruttoreDate(idIstruttore, from, to);
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				attivitaDTO.add(getDTOFromEntity(attivita));
			}
		}

		System.out.println("\nATTIVITA SERVICE ");
		System.out.print("id: " + idIstruttore + ", from: " + from + ", to: " + to);
		return attivitaDTO;
	}

	////////////////// default/////////////////

	public List<AttivitaDTO> findRange(int first_result, int max_results) {
		List<AttivitaDTO> attivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findRangeBySelect(first_result, max_results);
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				attivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return attivitaDTO;
	}

	public void create(AttivitaDTO dto) {
		attivitaRepository.create(getEntityFromDTO(dto));
	}

	public void edit(AttivitaDTO dto) {
		attivitaRepository.edit(getEntityFromDTO(dto));
	}

	public AttivitaDTO find(Integer id) {
		return getDTOFromEntity(attivitaRepository.find(id));
	}

	public void remove(Integer id) {
		attivitaRepository.remove(attivitaRepository.find(id));
	}

	private AttivitaDTO getDTOFromEntity(Attivita entity) {
		AttivitaDTO attivitaDTO = new AttivitaDTO();

		attivitaDTO.setIdAttivita(entity.getIdAttivita());
		attivitaDTO.getIdCliente().setIdCliente(entity.getClienti().getIdCliente());
		attivitaDTO.getIdCliente().setNome(entity.getClienti().getNome());
		attivitaDTO.getIdCliente().setCognome(entity.getClienti().getCognome());
		attivitaDTO.getIdCliente().setCf(entity.getClienti().getCf());
		attivitaDTO.getIdCliente().setUsr(entity.getClienti().getAccessi().getUsr());

		/* //////////METODO SPECIALE/////// */
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dateFormat.format(entity.getClienti().getFineAbbonamento());
		attivitaDTO.getIdCliente().setFineAbbonamento(dateFormat.format(entity.getClienti().getFineAbbonamento()));

		attivitaDTO.getIdIstruttore().setIdIstruttore(entity.getIstruttori().getIdIstruttore());
		attivitaDTO.getIdIstruttore().setUsr(entity.getIstruttori().getAccessi().getUsr());
		attivitaDTO.getIdIstruttore().setCognome(entity.getIstruttori().getCognome());
		attivitaDTO.getIdIstruttore().setNome(entity.getIstruttori().getNome());
		attivitaDTO.getIdIstruttore().setCf(entity.getIstruttori().getCf());

//		attivitaDTO.setDataOra(entity.getDataOra());

		attivitaDTO.setState(entity.getState());

		attivitaDTO.getIdTipoAttivita().setIdTipoAttivita(entity.getTipoAttivita().getIdTipoAttivita());
		attivitaDTO.getIdTipoAttivita().setDescr(entity.getTipoAttivita().getDescr());
		return attivitaDTO;
	}

	private Attivita getEntityFromDTO(AttivitaDTO AttivitaDTO) {
		Attivita attivita = new Attivita();

		System.out.print("getEntity");

		attivita.setIdAttivita(AttivitaDTO.getIdAttivita());
		System.out.println("idAttivita: " + AttivitaDTO.getIdAttivita());

//		attivita.setDataOra(AttivitaDTO.getDataOra());
		System.out.println("dataOra: " + AttivitaDTO.getDataOra());
//		cliente

		attivita.getClienti().setIdCliente(AttivitaDTO.getIdCliente().getIdCliente());
		System.out.println("idClienti: " + AttivitaDTO.getIdCliente().getIdCliente());
//		attivita.getClienti().setNome(AttivitaDTO.getIdCliente().getNome());
//		attivita.getClienti().setCognome(AttivitaDTO.getIdCliente().getCognome());

		attivita.getIstruttori().setIdIstruttore(AttivitaDTO.getIdIstruttore().getIdIstruttore());
		System.out.println("idIstruttore: " + AttivitaDTO.getIdIstruttore().getIdIstruttore());

		attivita.getTipoAttivita().setIdTipoAttivita(AttivitaDTO.getIdTipoAttivita().getIdTipoAttivita());
		System.out.println("idTipoAttivita: " + AttivitaDTO.getIdTipoAttivita().getIdTipoAttivita());

//		attivita.setDataOra(AttivitaDTO.getDataOra());
		System.out.println("DataOra: " + AttivitaDTO.getDataOra());

		attivita.setState(AttivitaDTO.getState());
		System.out.println("state: " + AttivitaDTO.getState());

		return attivita;
	}

	public Integer count() {
		return attivitaRepository.count();
	}

	public List<AttivitaDTO> findRange(Timestamp first_date, Timestamp second_date, Integer id) {
		List<AttivitaDTO> attivitaDTO = new ArrayList<>();
		List<Attivita> Attivita = attivitaRepository.findRange(first_date, second_date, id);
		if (Attivita != null) {
			for (Attivita attivita : Attivita) {
				attivitaDTO.add(getDTOFromEntity(attivita));
			}
		}
		return attivitaDTO;
	}
}
