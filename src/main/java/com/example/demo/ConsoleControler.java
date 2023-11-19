package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consoles")

public class ConsoleControler {
	@Autowired
    private CosoleRepository cosoleRepository;

    @GetMapping
    public List<Console> getAllConsole()
    {
        return cosoleRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console adicionarConsole(@RequestBody Console console)
    {
        return cosoleRepository.save(console);
    }
    
    @PutMapping("/{id}")
    public Console atualizarConsole(
        @PathVariable Long id, 
        @RequestBody Console consoleAtualizado
    ) {
        return cosoleRepository.findById(id)
                .map(console -> {
                    console.setNome(consoleAtualizado.getNome());
                    console.setVersao(consoleAtualizado.getVersao());
                    console.setAno(consoleAtualizado.getAno());
                    console.setDisp(consoleAtualizado.getDisp());
                    console.setEstado(consoleAtualizado.getEstado());
                    console.setValor(consoleAtualizado.getValor());
                                   return cosoleRepository.save(console);
                })
                .orElseGet(() -> cosoleRepository.save(consoleAtualizado));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirConsole(@PathVariable Long id) {
    	cosoleRepository.deleteById(id);
    }

}
