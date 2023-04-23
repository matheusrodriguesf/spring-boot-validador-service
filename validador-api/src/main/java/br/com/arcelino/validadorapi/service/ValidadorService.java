package br.com.arcelino.validadorapi.service;

import org.springframework.stereotype.Service;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.types.ParametroTipo;

@Service
public class ValidadorService {

    public boolean isCpfInvalido(String cpf) {
        cpf = removeCaracteresEspeciais(cpf);
        var check = new SafeguardCheck();
        return check
                .elementOf(cpf, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
                .elementOf(cpf, ParametroTipo.CPF)
                .validate()
                .hasError();
    }

    public boolean isCnpjInvalido(String cnpj) {
        cnpj = removeCaracteresEspeciais(cnpj);
        var check = new SafeguardCheck();
        return check
                .elementOf(cnpj, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
                .elementOf(cnpj, ParametroTipo.CNPJ)
                .validate()
                .hasError();
    }

    public boolean isTituloEleitorInvalido(String tituloEleitor) {
        tituloEleitor = removeCaracteresEspeciais(tituloEleitor);
        var check = new SafeguardCheck();
        return check
                .elementOf(tituloEleitor, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
                .elementOf(tituloEleitor, ParametroTipo.TITULO_DE_ELEITOR_FORMATADO)
                .validate()
                .hasError();
    }

    private String removeCaracteresEspeciais(String value) {
        return value.replaceAll("[^0-9]", "");
    }
}
