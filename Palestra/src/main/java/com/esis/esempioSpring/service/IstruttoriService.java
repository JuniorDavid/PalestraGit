package com.esis.esempioSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esis.esempioSpring.dto.IstruttoriDTO;
import com.esis.esempioSpring.entities.Istruttori;
import com.esis.esempioSpring.repository.IstruttoriRepository;


@Service
public class IstruttoriService {
	
	@Autowired
	 IstruttoriRepository istruttoriRepository;
	
	public List<IstruttoriDTO> findAll() {
       List<IstruttoriDTO> istruttoriDTO = new ArrayList<>();
       List<Istruttori> istruttori = istruttoriRepository.findAllBySelect();
       if (istruttori != null) {
           for (Istruttori istruttore : istruttori) {
               istruttoriDTO.add(getDTOFromEntity(istruttore));
           }
       }
       return istruttoriDTO;
   }

   public List<IstruttoriDTO> findRange(int first_result, int max_results) {
       List<IstruttoriDTO> istruttoriDTO = new ArrayList<>();
       List<Istruttori> istruttori = istruttoriRepository.findRangeBySelect(first_result, max_results);
       if (istruttori != null) {
           for (Istruttori istruttore : istruttori) {
               istruttoriDTO.add(getDTOFromEntity(istruttore));
           }
       }
       return istruttoriDTO;
   }

   public void create(IstruttoriDTO dto) {
       istruttoriRepository.create(getEntityFromDTO(dto));
   }

   public void edit(IstruttoriDTO dto) {
       istruttoriRepository.edit(getEntityFromDTO(dto));
   }

   public IstruttoriDTO find(Integer id) {
       return getDTOFromEntity(istruttoriRepository.find(id));
   }

   public void remove(Integer id) {
	   istruttoriRepository.remove(istruttoriRepository.find(id));
   }

   private IstruttoriDTO getDTOFromEntity(Istruttori entity) {
       IstruttoriDTO istruttoreDTO = new IstruttoriDTO();

       istruttoreDTO.setIdIstruttore(entity.getIdIstruttore());
       istruttoreDTO.setNome(entity.getNome());
       istruttoreDTO.setCognome(entity.getCognome());
       istruttoreDTO.setCf(entity.getCf());
       istruttoreDTO.setUsr(entity.getAccessi().getUsr());
       return istruttoreDTO;
   }

   private Istruttori getEntityFromDTO(IstruttoriDTO IstruttoriDTO) {
       Istruttori istruttore = new Istruttori();
       //TODO da implementare

       return istruttore;
   }

   public Integer count() {
       return istruttoriRepository.count();
   }

}
