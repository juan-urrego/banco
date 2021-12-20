create table cli_juridicos (
    clJrId number(10),
    clJrRazonSocial varchar2(100) not null,
    clJrAño number(4) not null,
    constraint PK_cli_juridico primary key (clJrId)
)
desc cli_juridicos
create sequence cli_sJuridicos
    start with 1 increment by 1;

drop table movimientos;
drop table cuentas;
drop table cli_naturales;
drop table cli_juridicos;

desc cli_juridicos
desc movimientos
create table cli_naturales (
    clNtId number(10),
    clNtNombre varchar2(80) not null,
    clNtApellido varchar2(250) not null,
    clNtTipoDocumento varchar2(2) not null,
    clNtIdentificacion varchar2(10) not null,
    clNtRut varchar2(15) not null,
    clNtJuridico number(10),
    constraint PK_cli_natural primary key (clNtId),
    constraint CK_cli_tipoDocumento check (clNtTipoDocumento IN ('CC','TI','CE','RC','PA')),
    constraint UQ_rut unique (clNtRut),
    constraint UQ_identificacion unique (clNtIdentificacion),
    constraint FK_cli_naturales_cli_juridicos foreign key (clNtJuridico) references cli_juridicos(clJrId)
);
create sequence cli_sNaturales
    start with 1 increment by 1;

create table cuentas (
    ctaId number(10),
    ctaNumero number(15) not null,
    ctaMoneda varchar2(3) not null,
    ctaSaldo number(20,2) not null,
    ctaCliente number(10) not null,
    constraint PK_cuenta primary key (ctaId),
    constraint CK_cuenta_moneda check (ctaMoneda IN ('EUR','USD','COP')),
    constraint UQ_numero unique(ctaNumero),
    constraint FK_cuentas_cli_naturales foreign key (ctaCliente) references cli_naturales(clNtId)
);
create sequence sCuentas
    start with 1 increment by 1;


create table movimientos (
    movId number,
    movDateStamp timestamp not null,
    movValor number(20,2) not null,
    movCuenta number(10) not null,
    constraint PK_movimiento primary key (movId),
    constraint FK_movimientos_cuentas foreign key (movCuenta) references cuentas(ctaId)
);
create sequence sMovimientos
    start with 1 increment by 1;
