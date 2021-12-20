declare
    wRespuesta varchar2(500);
    wMensajeError varchar(500);
    wMoneda cuentas.ctamoneda%type;
begin
    movimientosop.fn_crear_moovimiento(-50, 12, wRespuesta, wMensajeError);
    DBMS_OUTPUT.PUT_LINE('Respuesta: ' || wRespuesta || '-- Mensaje Error: ' || wMensajeError);
end;
