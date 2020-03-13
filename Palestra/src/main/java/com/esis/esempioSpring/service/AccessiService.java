package com.esis.esempioSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esis.esempioSpring.repository.AccessiRepository;

import com.esis.esempioSpring.dto.AccessiDTO;

import com.esis.esempioSpring.entities.Accessi;

@Service
public class AccessiService {
	
	 @Autowired
	 AccessiRepository accessiRepository;

	    public List<AccessiDTO> findAll() {
	        List<AccessiDTO> accessiDTO = new ArrayList<>();
	        List<Accessi> ordini = accessiRepository.findAllBySelect();
	        if (ordini != null) {
	            for (Accessi ordine : ordini) {
	                accessiDTO.add(getDTOFromEntity(ordine));
	            }
	        }
	        return accessiDTO;
	    }

	    public List<AccessiDTO> findRange(int first_result, int max_results) {
	        List<AccessiDTO> ordiniDTO = new ArrayList<>();
	        List<Accessi> ordini = accessiRepository.findRangeBySelect(first_result, max_results);
	        if (ordini != null) {
	            for (Accessi ordine : ordini) {
	                ordiniDTO.add(getDTOFromEntity(ordine));
	            }
	        }
	        return ordiniDTO;
	    }

	    public void create(AccessiDTO dto) {
	        accessiRepository.create(getEntityFromDTO(dto));
	    }

	    public void edit(AccessiDTO dto) {
	        accessiRepository.edit(getEntityFromDTO(dto));
	    }

	    public AccessiDTO find(String id) {
	        return getDTOFromEntity(accessiRepository.find(id));
	    }

	    public void remove(String id) {
        accessiRepository.remove(accessiRepository.find(id));
	    }

	    private AccessiDTO getDTOFromEntity(Accessi entity) {
	        AccessiDTO ordineDTO = new AccessiDTO();
	       // RigaOrdineDTO rigaOrdineDTO;

	        ordineDTO.setUsr(entity.getUsr());
	        ordineDTO.setPswd(entity.getPswd());

//	        ordineDTO.setIdCliente(entity.getIdCliente().getIdCliente());
//	        ordineDTO.setCognome(entity.getIdCliente().getCognome());
//	        ordineDTO.setNome(entity.getIdCliente().getNome());

//	        for (RigaOrdine rigaOrdine : entity.getRigaOrdineList()) {
//	            rigaOrdineDTO = new RigaOrdineDTO();
//	            rigaOrdineDTO.setNumeroPezzi(rigaOrdine.getNumeroPezzi());
//	            rigaOrdineDTO.setCodiceArticolo(rigaOrdine.getRigaOrdinePK().getCodiceArticolo());
//	            rigaOrdineDTO.setDescrizione(rigaOrdine.getArticolo().getDescrizione());
//	            ordineDTO.getRigaOrdineList().add(rigaOrdineDTO);
//	        }
	        return ordineDTO;
	    }
	    
	    //MODIFICATO da noi
	    private Accessi getEntityFromDTO(AccessiDTO accessiDTO) {
	        Accessi accesso = new Accessi();
	        System.out.println("siamo nel service");
	        accesso.setUsr(accessiDTO.getUsr());
	        accesso.setPswd(accessiDTO.getPswd());

	        return accesso;
	    }

	    public Integer count() {
	        return accessiRepository.count();
	    }
	}


