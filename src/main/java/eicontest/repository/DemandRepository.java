package eicontest.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import eicontest.model.Demand;


public interface DemandRepository extends JpaRepository<Demand, Integer> {

 boolean existsById(Integer id);

 Demand findByCreateAt(Date createAt); 

 @Transactional
  void deleteById(Integer id);
  
}
