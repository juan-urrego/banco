CREATE OR REPLACE PACKAGE movimientosop IS
    PROCEDURE fn_crear_moovimiento (
        pvalor        IN movimientos.movvalor%TYPE,
        pcuenta       IN movimientos.movcuenta%TYPE,
        prespuesta    OUT VARCHAR2,
        pmensajeerror OUT VARCHAR2
    );

    FUNCTION fn_calcular_saldo (
        parametro1 IN NUMBER,
        parametro2 IN NUMBER
    ) RETURN NUMBER;

END;

CREATE OR REPLACE PACKAGE BODY movimientosop AS

    PROCEDURE fn_crear_moovimiento (
        pvalor        IN movimientos.movvalor%TYPE,
        pcuenta       IN movimientos.movcuenta%TYPE,
        prespuesta    OUT VARCHAR2,
        pmensajeerror OUT VARCHAR2
    ) IS

        error_nulo EXCEPTION;
        error_campo EXCEPTION;
        wcampo_nulo VARCHAR2(20);
        wcampo      VARCHAR2(100);
        wmoneda     cuentas.ctamoneda%TYPE;
    BEGIN
        IF pcuenta IS NULL THEN
            wcampo_nulo := 'Cuenta';
            RAISE error_nulo;
        END IF;
        SELECT
            ctamoneda
        INTO wmoneda
        FROM
            cuentas
        WHERE
            ctaid = pcuenta;

        IF pvalor IS NULL THEN
            wcampo_nulo := 'Valor';
            RAISE error_nulo;
        ELSIF wmoneda = 'COP' THEN
            IF pvalor > 1000000 THEN
                wcampo := 'excede el monto permitido';
                RAISE error_campo;
            END IF;
        ELSIF wmoneda = 'USD' THEN
            IF pvalor > 300 THEN
                wcampo := 'excede el monto permitido';
                RAISE error_campo;
            END IF;
        ELSIF wmoneda = 'EUR' THEN
            IF pvalor > 150 THEN
                wcampo := 'excede el monto permitido';
                RAISE error_campo;
            END IF;
        END IF;

        INSERT INTO movimientos VALUES (
            smovimientos.NEXTVAL,
            current_timestamp,
            pvalor,
            pcuenta
        );

        UPDATE cuentas
        SET
            ctasaldo = fn_calcular_saldo(
                ctasaldo, pvalor
            )
        WHERE
            ctaid = pcuenta;

        prespuesta := 'done';
    EXCEPTION
        WHEN error_nulo THEN
            pmensajeerror := 'Campo Obligatorio: ' || wcampo_nulo;
        WHEN error_campo THEN
            pmensajeerror := 'El campo no es valido : ' || wcampo;
    END;

    FUNCTION fn_calcular_saldo (
        parametro1 IN NUMBER,
        parametro2 IN NUMBER
    ) RETURN NUMBER IS
        wresult NUMBER;
    BEGIN
        wresult := parametro1 + parametro2;
        RETURN wresult;
    EXCEPTION
        WHEN OTHERS THEN
            RAISE;
    END;

END;