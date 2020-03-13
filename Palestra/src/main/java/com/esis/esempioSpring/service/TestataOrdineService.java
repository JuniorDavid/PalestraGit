package com.esis.esempioSpring.service;

import com.esis.esempioSpring.dao.TestataOrdineDAO;
import com.esis.esempioSpring.dto.RigaOrdineDTO;
import com.esis.esempioSpring.dto.TestataOrdineDTO;
import com.esis.esempioSpring.entities.RigaOrdine;
import com.esis.esempioSpring.entities.TestataOrdine;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvano
 */

//fa le operazioni vere e proprie, logica di business

/* nel nostro caso fa il traduttore da DTO a entity e viceversa*/
@Service
public class TestataOrdineService {

    @Autowired
    TestataOrdineDAO testataOrdineDAO;

    public List<TestataOrdineDTO> findAll() {
        List<TestataOrdineDTO> ordiniDTO = new ArrayList<>();
        List<TestataOrdine> ordini = testataOrdineDAO.findAllBySelect();
        if (ordini != null) {
            for (TestataOrdine ordine : ordini) {
                ordiniDTO.add(getDTOFromEntity(ordine));
            }
        }
        return ordiniDTO;
    }

    public List<TestataOrdineDTO> findRange(int first_result, int max_results) {
        List<TestataOrdineDTO> ordiniDTO = new ArrayList<>();
        List<TestataOrdine> ordini = testataOrdineDAO.findRangeBySelect(first_result, max_results);
        if (ordini != null) {
            for (TestataOrdine ordine : ordini) {
                ordiniDTO.add(getDTOFromEntity(ordine));
            }
        }
        return ordiniDTO;
    }

    public void create(TestataOrdineDTO dto) {
        testataOrdineDAO.create(getEntityFromDTO(dto));
    }

    public void edit(TestataOrdineDTO dto) {
        testataOrdineDAO.edit(getEntityFromDTO(dto));
    }

    public TestataOrdineDTO find(Integer id) {
        return getDTOFromEntity(testataOrdineDAO.find(id));
    }

    public void remove(Integer id) {
        testataOrdineDAO.remove(testataOrdineDAO.find(id));
    }

    private TestataOrdineDTO getDTOFromEntity(TestataOrdine entity) {
        TestataOrdineDTO ordineDTO = new TestataOrdineDTO();
        RigaOrdineDTO rigaOrdineDTO;

        ordineDTO.setIdTestata(entity.getIdTestata());
        ordineDTO.setDataConsegna(entity.getDataConsegna());

        ordineDTO.setIdCliente(entity.getIdCliente().getIdCliente());
        ordineDTO.setCognome(entity.getIdCliente().getCognome());
        ordineDTO.setNome(entity.getIdCliente().getNome());

        for (RigaOrdine rigaOrdine : entity.getRigaOrdineList()) {
            rigaOrdineDTO = new RigaOrdineDTO();
            rigaOrdineDTO.setNumeroPezzi(rigaOrdine.getNumeroPezzi());
            rigaOrdineDTO.setCodiceArticolo(rigaOrdine.getRigaOrdinePK().getCodiceArticolo());
            rigaOrdineDTO.setDescrizione(rigaOrdine.getArticolo().getDescrizione());
            ordineDTO.getRigaOrdineList().add(rigaOrdineDTO);
        }
        return ordineDTO;
    }

    private TestataOrdine getEntityFromDTO(TestataOrdineDTO testataOrdineDTO) {
        TestataOrdine testataOrdine = new TestataOrdine();
        //TODO da implementare

        return testataOrdine;
    }

    public Integer count() {
        return testataOrdineDAO.count();
    }
}
