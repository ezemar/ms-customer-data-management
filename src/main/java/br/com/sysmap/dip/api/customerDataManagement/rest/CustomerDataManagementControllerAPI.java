package br.com.sysmap.dip.api.customerDataManagement.rest;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.sysmap.dip.core.port.in.dto.ErrorInfoDto;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdRequestDTO;
import br.com.sysmap.dip.core.port.in.dto.GetClientInfoByIdResponseDTO;
import br.com.sysmap.dip.infrastructure.AbstractGenericException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

public interface CustomerDataManagementControllerAPI {

    @Operation(summary = "API goal is to provide client basics information", tags ="CustomerDataManagement")
                @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))}),
                        @ApiResponse(responseCode = "400", description = "Problem with the client request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfoDto.class))}),
                        @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfoDto.class))}),
                        @ApiResponse(responseCode = "403", description = "Client does not have sufficient permission", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfoDto.class))}),
                        @ApiResponse(responseCode = "404", description = "Resource not found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfoDto.class))}),
                        @ApiResponse(responseCode = "500", description = "Server error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfoDto.class))}),
                        @ApiResponse(responseCode = "504", description = "Request timeout exceeded", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorInfoDto.class))})
                })
                @PostMapping(value="/CustomerDataManagement/ClientInformation")
                ResponseEntity<GetClientInfoByIdResponseDTO> getClientInfoById(@RequestHeader (value = "Authorization") String authorization,
                                                                 @Valid @RequestBody GetClientInfoByIdRequestDTO getClientInfoByIdRequestDTO
                                                                 ) throws DatatypeConfigurationException, AbstractGenericException;
                }


