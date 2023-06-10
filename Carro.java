/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardatabase;

/**
 *
 * @author facec.lab02
 */
public class Carro {
    private int id;
    private String nome;
    private String ano;
    private String modelo;
    private String marca;
// Id
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
// Marca
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
// Modelo
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
// Ano    
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
// Nome      
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
