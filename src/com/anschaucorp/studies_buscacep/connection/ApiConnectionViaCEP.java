package com.anschaucorp.studies_buscacep.connection;

import com.anschaucorp.studies_buscacep.model.Cep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiConnectionViaCEP {
    private String url;
    private Gson gson;

    public ApiConnectionViaCEP() {
        this.url = "https://viacep.com.br/ws/";
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    public List<Cep> searchByAddress(String estado, String cidade, String logradouro){
        List<Cep> ceps = new ArrayList<>();
        try {
            String url = this.url.concat(estado.replace(" ","%20")).concat("/").concat(cidade.replace(" ","%20")).concat("/").concat(logradouro.replace(" ","%20")).concat("/json");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();

            Type cepListType = new TypeToken<ArrayList<Cep>>() {
            }.getType();

            ceps = gson.fromJson(json, cepListType);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ceps;
    }

    public Cep searchByCep(String searchCep){
        Cep cep;
        try {
            String url = this.url.concat(searchCep).concat("/").concat("/json");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            var json = response.body();

            cep = gson.fromJson(json, Cep.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return cep;
    }
}
