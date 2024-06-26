package com.dutybot2.dutybot2.service;

import com.dutybot2.dutybot2.dto.CadetDto;
import com.dutybot2.dutybot2.model.Cadet;
import com.dutybot2.dutybot2.repository.CadetRepository;
import com.dutybot2.dutybot2.util.Caste;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CadetService {

    private CadetRepository cadetRepository;

    @Transactional
    public CadetDto updateCadet(int existingCadetId, Cadet updateCadet){
        Cadet cadet = cadetRepository.getReferenceById(existingCadetId);
        cadet.setDutyDayCount(updateCadet.getDutyDayCount());
        cadet.setStatus(updateCadet.getStatus());
        cadet.setCaste(updateCadet.getCaste());
        cadet.setChatId(updateCadet.getChatId());
        cadet.setLastName(updateCadet.getLastName());
        return cadetToCadetDtoMap(cadet);
    }
    public CadetDto findCadetDtoById(int id){
        return cadetToCadetDtoMap(cadetRepository.getReferenceById(id));
    }

    public CadetDto cadetToCadetDtoMap(Cadet cadet){
        return new CadetDto(cadet.getLastName(),cadet.getDutyDayCount(), cadet.getChatId(),cadet.getStatus(),cadet.getCaste());
    }

    public List<Cadet> findAll() {
        return cadetRepository.findAll();
    }

    public void save(Cadet newCadet) {
        cadetRepository.save(newCadet);
    }

    public Cadet getReferenceById(Integer id) {
        return cadetRepository.getReferenceById(id);
    }

    public Object findAllByCaste(Caste caste) {
        return cadetRepository.findAllByCaste(caste);
    }

    public void deleteCadetById(int id){
        cadetRepository.deleteById(id);
    }
}
