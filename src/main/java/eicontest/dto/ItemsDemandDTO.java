package eicontest.dto;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemsDemandDTO {
  @ApiModelProperty(position = 0)
  private String productName;
  @ApiModelProperty(position = 1)
  private BigDecimal price;
  @ApiModelProperty(position = 2)
  private Integer numberOfControl;
  @ApiModelProperty(position = 3)
  private Integer quantity = 1;
}
