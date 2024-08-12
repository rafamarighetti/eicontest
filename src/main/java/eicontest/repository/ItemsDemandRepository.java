package eicontest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import eicontest.model.ItemsDemand;




public interface ItemsDemandRepository extends JpaRepository<ItemsDemand, Integer> {
 boolean existsByNumberOfControl(Integer numberOfControl);
}
