package eicontest.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import eicontest.model.ItemsDemand;

@Data
@NoArgsConstructor
public class DemandDataDTO {
  @ApiModelProperty(position = 0)
  private Date createAt;
  @ApiModelProperty(position = 1)
  private Date editedAt;
  @ApiModelProperty(position = 2)
  private Integer clientCode;
  @ApiModelProperty(position = 3)
  private List<ItemsDemand> itemsDemands;
}
