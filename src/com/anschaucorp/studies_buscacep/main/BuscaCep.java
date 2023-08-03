package com.anschaucorp.studies_buscacep.main;

import com.anschaucorp.studies_buscacep.connection.ApiConnectionViaCEP;
import com.anschaucorp.studies_buscacep.model.Cep;

import java.util.List;
import java.util.Scanner;

public class BuscaCep {
    public static void main(String[] args) {
        System.out.println("############## **** >> WELCOME TO BUSCA CEP << **** ##############");

        Scanner read = new Scanner(System.in);
        String estado = "";
        String cidade = "";
        String logradouro = "";
        String cep = "";
        String option = "";

        System.out.println("> SELECT one of the following options:");
        System.out.println(">> 1 - search by ESTADO, CIDADE , LOGRADOURO");
        System.out.println(">> 2 - search by CEP");
        System.out.println(">> 3 or Exit - close application");

        option = read.nextLine();

        ApiConnectionViaCEP apiConnectionViaCEP = new ApiConnectionViaCEP();

        while (!option.equalsIgnoreCase("3") && !option.equalsIgnoreCase("exit")) {

            if (option.equalsIgnoreCase("1")) {
                System.out.println(">>> Type the ESTADO you need to search:");
                estado = read.nextLine();

                System.out.println(">>> Type the CIDADE you need to search:");
                cidade = read.nextLine();

                System.out.println(">>> Type the LOGRADOURO you need to search:");
                logradouro = read.nextLine();

                var ceps = apiConnectionViaCEP.searchByAddress(estado,cidade,logradouro);

                for (Cep item: ceps) {
                    System.out.println(item);
                }

                System.out.println("\n\n\n***************************************");
                System.out.println("> SELECT one of the following options:");
                System.out.println(">> 1 - search by ESTADO, CIDADE , LOGRADOURO");
                System.out.println(">> 2 - search by CEP");
                System.out.println(">> 3 or Exit - close application");
                option = read.nextLine();

            } else if (option.equalsIgnoreCase("2")) {

                System.out.println(">>> Type the CEP you need to search:");
                cep = read.nextLine();

                var returnCep = apiConnectionViaCEP.searchByCep(cep);

                System.out.println(returnCep);

                System.out.println("\n\n\n***************************************");
                System.out.println("> SELECT one of the following options:");
                System.out.println(">> 1 - search by ESTADO, CIDADE , LOGRADOURO");
                System.out.println(">> 2 - search by CEP");
                System.out.println(">> 3 or Exit - close application");
                option = read.nextLine();

            } else {
                System.out.println("You type a invalid option!");

                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("> SELECT one of the following options:");
                System.out.println(">> 1 - search by ESTADO, CIDADE , LOGRADOURO");
                System.out.println(">> 2 - search by CEP");
                System.out.println(">> 3 or Exit - close application");
                option = read.nextLine();
            }

        }

    }
}
