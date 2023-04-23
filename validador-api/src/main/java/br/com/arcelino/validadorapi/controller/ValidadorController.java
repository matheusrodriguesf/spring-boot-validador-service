package br.com.arcelino.validadorapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.validadorapi.api.Response;
import br.com.arcelino.validadorapi.service.ValidadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/validadores")
@RequiredArgsConstructor
public class ValidadorController {

    private final ValidadorService validadorCpfService;

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Response> isCpfValido(@PathVariable String cpf) {
        var result = validadorCpfService.isCpfInvalido(cpf);
        var message = result ? "CPF inválido" : "CPF válido";
        return ResponseEntity.ok(new Response(message, !result));

    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Response> isCnpjValido(@PathVariable String cnpj) {
        var result = validadorCpfService.isCnpjInvalido(cnpj);
        var message = result ? "CNPJ inválido" : "CNPJ válido";
        return ResponseEntity.ok(new Response(message, !result));

    }

    @GetMapping("titulo-eleitor/{tituloEleitor}")
    public ResponseEntity<Response> isTituloEleitorValido(@PathVariable String tituloEleitor) {
        var result = validadorCpfService.isTituloEleitorInvalido(tituloEleitor);
        var message = result ? "Título de eleitor inválido" : "Título de eleitor válido";
        return ResponseEntity.ok(new Response(message, !result));
    }
}
