package com.calero.lili.api.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vt_clientes")
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VtClientesEntity {

    @Column(name = "id_data")
    private String idData;

    @Id
    @Column(name = "id_cliente")
    private UUID idCliente;

    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion", length = 15,unique=true)
    private String numeroIdentificacion;

    @Column(name = "cliente", columnDefinition = "varchar (300)")
    private String cliente;

    @Column(name = "web")
    private String web;

    @Column(name = "observaciones", columnDefinition = "varchar (300)")
    private String observaciones;

    @Column(name = "tipo_cliente")
    private String tipoCliente;

//    @Column(columnDefinition = "jsonb")
//    private List<Direccion> direcciones;
//
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Direccion {
//        private String ciudad;
//        private String direccion;
//        private String telefonos;
//        private String contacto;
//        private String email;
//    }

}

