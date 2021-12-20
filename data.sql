--Ejecutar en orden, para respetar foreign keys
insert into cli_juridicos values(CLI_SJURIDICOS.nextval, 'Esto es una razon social para 1', '2014');
insert into cli_juridicos values(CLI_SJURIDICOS.nextval, 'Esto es una razon social para 2', '2014');
insert into cli_juridicos values(CLI_SJURIDICOS.nextval, 'Esto es una razon social para 3', '2014');


insert into cli_naturales  values(CLI_SNATURALES.nextval, 'Juan Jose', 'urrego rios', 'CC', 12345, 'estoesnrutASFFG', null);
insert into cli_naturales  values(CLI_SNATURALES.nextval, 'daniel', 'gonzales', 'CC', 353245, 'estosunrutASFFG', null);
insert into cli_naturales  values(CLI_SNATURALES.nextval, 'pepito', 'zapata', 'CC', 32456, 'estoesrutASFFG', 1);
insert into cli_naturales  values(CLI_SNATURALES.nextval, 'carlos', 'correa', 'CC', 23456, 'estoeunrutASFFG', null);
insert into cli_naturales  values(CLI_SNATURALES.nextval, 'cielo', 'uribe', 'CC', 6537, 'estoesurutASFFG', 2);
insert into cli_naturales  values(CLI_SNATURALES.nextval, 'luz', 'cano', 'CC', 657567, 'estoesunutASFFG', 3);


insert into cuentas values(SCUENTAS.nextval, 13456787, 'USD', 0, 6);
insert into cuentas values(SCUENTAS.nextval, 1245687, 'COP', 0, 6);
insert into cuentas values(SCUENTAS.nextval, 12345787, 'COP', 0, 6);
insert into cuentas values(SCUENTAS.nextval, 1456787, 'COP', 0, 6);
insert into cuentas values(SCUENTAS.nextval, 1234687, 'USD', 0, 6);
insert into cuentas values(SCUENTAS.nextval, 1234677, 'EUR', 0, 6);

select * from cli_naturales;
select * from cuentas;
select * from movimientos;

select * from cli_juridicos;
desc cli_juridicos