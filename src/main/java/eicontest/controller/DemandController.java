package eicontest.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import eicontest.dto.DemandDataDTO;
import eicontest.dto.UserDataDTO;
import eicontest.model.Demand;
import eicontest.model.User;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import eicontest.service.DemandService;

@RestController
@RequestMapping("/demand")
@Api(tags = "demand")
@RequiredArgsConstructor
public class DemandController {
  private final DemandService demandService;
  private final ModelMapper modelMapper;

  @GetMapping(value = "")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @ApiOperation(value = "${DemandController.demands}",  authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public List<Demand> getAllDwDemands() {
    return demandService.demands();
  }

  @PostMapping("/create")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @ApiOperation(value = "${DemandController.addDemands}",  authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use")})
  public Demand addDemand(@ApiParam("Add Demand") @RequestBody DemandDataDTO demand) {
    return demandService.addDemands(modelMapper.map(demand, Demand.class));
  }
}
