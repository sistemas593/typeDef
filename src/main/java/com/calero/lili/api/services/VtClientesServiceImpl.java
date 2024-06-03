package com.calero.lili.api.services;

import com.calero.lili.api.dtos.vtClientes.VtClienteCreationRequestDto;
import com.calero.lili.api.dtos.vtClientes.VtClienteCreationResponseDto;
import com.calero.lili.api.errors.exceptions.AlreadyExistsException;
import com.calero.lili.api.repositories.VtClientesRepository;
import com.calero.lili.api.repositories.entities.VtClientesEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VtClientesServiceImpl {

//    private final ValidarIdentificacion validarIdentificacion;
    private final VtClientesRepository vtClientesRepository;

    public VtClienteCreationResponseDto create(String idData, VtClienteCreationRequestDto request) {
        VtClientesEntity vtClientesEntity = vtClientesRepository.findByIdDataAndNumeroIdentificacion(idData,request.getNumeroIdentificacion());
        if(vtClientesEntity!=null) {
            System.out.println(request.getNumeroIdentificacion());
            throw new AlreadyExistsException(MessageFormat.format("El cliente con número de identificación {0} ya existe", request.getNumeroIdentificacion()));
        }
        VtClientesEntity  vtClientesNew = new VtClientesEntity();
        vtClientesNew.setIdData(idData);
        vtClientesNew.setIdCliente(UUID.randomUUID());

//        List<VtClientesEntity.Direccion> listaDireccionesEntity = new ArrayList<>();
//        List<VtClienteCreationRequestDto.Direccion> listaDireccionesDto = request.getDirecciones();
//        for (VtClienteCreationRequestDto.Direccion direccionDto : listaDireccionesDto ){
//            VtClientesEntity.Direccion direccionEntity = new VtClientesEntity.Direccion();
//            direccionEntity.setDireccion(direccionDto.getDireccion());
//            direccionEntity.setTelefonos(direccionDto.getTelefonos());
//            direccionEntity.setCiudad(direccionDto.getCiudad());
//            direccionEntity.setEmail(direccionDto.getEmail());
//            direccionEntity.setContacto(direccionDto.getContacto());
//            listaDireccionesEntity.add(direccionEntity);
//        }
//        vtClientesNew.setDirecciones(listaDireccionesEntity);

        return toResponseDto(vtClientesRepository.save(toEntity(request, vtClientesNew)));
    }


    private VtClienteCreationResponseDto toResponseDto(VtClientesEntity entity) {
        VtClienteCreationResponseDto dto = new VtClienteCreationResponseDto();
        dto.setIdCliente(entity.getIdCliente());
        return dto;
    }
    private VtClientesEntity toEntity(VtClienteCreationRequestDto request, VtClientesEntity entidad) {
        entidad.setCliente(request.getCliente());
        entidad.setTipoIdentificacion(request.getTipoIdentificacion());
        entidad.setNumeroIdentificacion(request.getNumeroIdentificacion());
        entidad.setWeb(request.getWeb());
        entidad.setTipoCliente(request.getTipoCliente());
        entidad.setObservaciones(request.getObservaciones());
        return entidad;
    }

}