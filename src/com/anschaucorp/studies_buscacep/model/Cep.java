package com.anschaucorp.studies_buscacep.model;

public class Cep {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localiade;
    private String uf;
    private int ddd;

    public Cep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, int ddd) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localiade = localidade;
        this.uf = uf;
        this.ddd = ddd;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocaliade() {
        return localiade;
    }

    public String getUf() {
        return uf;
    }

    public int getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return "Cep{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localiade='" + localiade + '\'' +
                ", uf='" + uf + '\'' +
                ", ddd=" + ddd +
                '}';
    }
}
