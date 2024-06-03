package com.calero.lili.api.controllers;

import com.calero.lili.api.dtos.vtClientes.VtClienteCreationRequestDto;
import com.calero.lili.api.dtos.vtClientes.VtClienteCreationResponseDto;
import com.calero.lili.api.services.VtClientesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "api/v1.0/clientes")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")

public class VtClientesController {

    private final VtClientesServiceImpl vtClientesService;

    @PostMapping("{idData}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public VtClienteCreationResponseDto create(
            @PathVariable("idData") String idData,
            @RequestBody VtClienteCreationRequestDto request) {
        return vtClientesService.create(idData, request);
    }

}
