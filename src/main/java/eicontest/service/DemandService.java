package eicontest.service;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import eicontest.exception.CustomException;
import eicontest.model.Demand;
import eicontest.repository.DemandRepository;
import eicontest.repository.ItemsDemandRepository;

@Service
@RequiredArgsConstructor
public class DemandService {

  private final DemandRepository demandRepository;  
  private final ItemsDemandRepository itemsDemandRepository;  

  public List<Demand>  demands() {
    return demandRepository.findAll();
  }

  public Demand addDemands(Demand demands) {   
        if(demands.getItemsDemands().size() > 10){

        demands.getItemsDemands().forEach(demand -> {
        demands.setTotal(demand.getPrice() + demands.getTotal());
        if(!itemsDemandRepository.existsByNumberOfControl(demand.getNumberOfControl())){
              demand.setNumberOfControl(demand.getNumberOfControl());
          }else {
            throw new CustomException("O numero de controle de um dos pedidos já foi registrado!", HttpStatus.UNPROCESSABLE_ENTITY);
          }
        });

        switch(demands.getItemsDemands().size()) {
          case 5: case 6: case 7: case 8: case 9:  
            demands.setTotal(demands.getTotal() - demands.getTotal() * 5/100);
            break;
          case 10: 
            demands.setTotal(demands.getTotal() - demands.getTotal() * 10/100);
            break;
          default: 
            demands.setTotal(demands.getTotal());
            break;
        }

      demandRepository.save(demands);
      return demands;
    } else {
      throw new CustomException("Cada demanda deve conter no máximo 10 pedidos!", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }
}
