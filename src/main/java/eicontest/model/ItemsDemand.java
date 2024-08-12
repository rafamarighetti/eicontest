package eicontest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import eicontest.dto.ItemsDemandDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
public class ItemsDemand {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "demand_id")
  private Demand demand;

  @Size(min = 2, max = 50, message = "productName -> (Required) min: 2 characters / max: 50 characters")
  @Column(nullable = false)
  private String productName;

  @Column(precision=10, scale=2, nullable = false)
  private double price;

  @Column(unique = true, nullable = false)
  private Integer numberOfControl;

  @Column(nullable = true)
  private Integer quantity = 1;
}
