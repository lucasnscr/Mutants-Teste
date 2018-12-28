package com.mercadolivre.mutants.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.mutants.model.Stats;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="Estatisticas DNA -  Mercado Livre")
@RestController
public interface StaticsController {
	
	 @ApiResponses(value = {
				@ApiResponse(code = 200, message="Ok"),
				@ApiResponse(code = 400, message="Bad Request"),
				@ApiResponse(code = 404, message="Not Found"),
				@ApiResponse(code = 500, message="Internal Server Error")
		})
		 
	@ApiOperation(value = "Serviço de estatisticas")
	@ApiResponse(code= 200, message="analise das estatisticas realizada com sucesso")
	@RequestMapping(value="/stats", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	Stats getStatics();

    
}
