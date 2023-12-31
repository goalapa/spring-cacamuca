package com.goalapa.cacamuca.statDomain.command.application.service;

import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity.Stat;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.repository.StatRepository;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.service.SaveStatService;
import org.springframework.stereotype.Service;

@Service
public class SaveStatServiceImpl implements SaveStatService {

    private final StatRepository statRepository;

    public SaveStatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public void insertData(StatDTO statDTO) {
        Stat stat = new Stat();
        stat.setStatNo(statDTO.getStatNo());
        stat.setFoodNo(statDTO.getFoodNo());
        stat.setFoodName(statDTO.getFoodName());
        stat.setUpdateDate(statDTO.getUpdateDate());
        stat.setCountry(statDTO.getCountry());
        stat.setFoodRate(statDTO.getFoodRate());
        stat.setLikeCnt(statDTO.getLikeCnt());
        stat.setReviewCnt(statDTO.getReviewCnt());
        stat.setMemberAgeGroup(statDTO.getMemberAgeGroup());
        stat.setMemberGender(statDTO.getMemberGender());
        stat.setFoodImageUrl(statDTO.getFoodeImageUrl());

        statRepository.save(stat);
    }
}
