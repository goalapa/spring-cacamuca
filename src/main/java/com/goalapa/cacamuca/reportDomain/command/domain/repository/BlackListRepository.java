package com.goalapa.cacamuca.reportDomain.command.domain.repository;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackList, Integer> {

}