package com.mercadolivre.mutants.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.mutants.model.DNASequence;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="Teste - Mercado Livre")
@RestController
public interface MutantsControllerr {
	
	 @ApiResponses(value = {
			@ApiResponse(code = 200, message="Ok"),
			@ApiResponse(code = 400, message="Bad Request"),
			@ApiResponse(code = 404, message="Not Found"),
			@ApiResponse(code = 500, message="Internal Server Error")
	})
	 
	@ApiOperation(value = "Serviço que realiza analise mutante")
	@ApiResponse(code= 200, message="analise mutante realizada com sucesso")
	@RequestMapping(value="/mutant", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> analizeMutantCandidate(@RequestBody DNASequence dna);
	

}
