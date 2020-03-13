package com.esis.esempioSpring.service;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esis.esempioSpring.dto.ClientiDTO;

import com.esis.esempioSpring.entities.Clienti;
import com.esis.esempioSpring.repository.*;

@Service
public class ClientiService {

	@Autowired
	ClientiRepository clientiRepository;
	AccessiRepository accessiRepository;

	public List<ClientiDTO> findAll() {
		List<ClientiDTO> clientiDTO = new ArrayList<>();
		List<Clienti> clienti = clientiRepository.findAllBySelect();
		if (clienti != null) {
			for (Clienti cliente : clienti) {
				clientiDTO.add(getDTOFromEntity(cliente));
			}
		}
		return clientiDTO;
	}

	public List<ClientiDTO> findRange(int first_result, int max_results) {
		List<ClientiDTO> clientiDTO = new ArrayList<>();
		List<Clienti> clienti = clientiRepository.findRangeBySelect(first_result, max_results);
		if (clienti != null) {
			for (Clienti cliente : clienti) {
				clientiDTO.add(getDTOFromEntity(cliente));
			}
		}
		return clientiDTO;
	}

	public void create(ClientiDTO dto) {
		clientiRepository.create(getEntityFromDTO(dto));
	}

	public void edit(ClientiDTO dto) {
		clientiRepository.edit(getEntityFromDTO(dto));
	}

	public ClientiDTO find(Integer id) {
		return getDTOFromEntity(clientiRepository.find(id));
	}

	public void remove(Integer id) {
		clientiRepository.remove(clientiRepository.find(id));
	}

	private ClientiDTO getDTOFromEntity(Clienti entity) {
		ClientiDTO clienteDTO = new ClientiDTO();

		clienteDTO.setIdCliente(entity.getIdCliente());
		clienteDTO.setNome(entity.getNome());
		clienteDTO.setCognome(entity.getCognome());
		clienteDTO.setCf(entity.getCf());

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strDate = dateFormat.format(entity.getFineAbbonamento());
		clienteDTO.setFineAbbonamento(strDate);

		clienteDTO.setUsr(entity.getAccessi().getUsr());

		return clienteDTO;
	}

	private Clienti getEntityFromDTO(ClientiDTO clientiDTO) {
		Clienti cliente = new Clienti();

		cliente.setIdCliente(clientiDTO.getIdCliente());
		cliente.setNome(clientiDTO.getNome());
		cliente.setCognome(clientiDTO.getCognome());
		cliente.setCf(clientiDTO.getCf());

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = formatter.parse(clientiDTO.getFineAbbonamento());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setFineAbbonamento(d);
		
		cliente.getAccessi().setUsr(clientiDTO.getUsr());
//		cliente.setAccessi(accessiRepository.find(clientiDTO.getUsr()));

		return null;
	}

	public Integer count() {
		return clientiRepository.count();
	}
}
