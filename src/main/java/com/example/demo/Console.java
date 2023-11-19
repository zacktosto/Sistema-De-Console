package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Console {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nome;
    private String versao;
    private int ano;
    private boolean disp;
    private String estado;
    private double valor;

    

    // Getters and setters for each attribute...

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getVersao() {
        return versao;
    }

    public int getAno() {
        return ano;
    }

    public boolean getDisp() {
        return disp;
    }

    public String getEstado() {
        return estado;
    }

    public double getValor() {
        return valor;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
    
}


