package com.rsalas.lab7.repositories;

import com.rsalas.lab7.models.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by USUARIO on 5/04/2018.
 */

public class CompanyRepository {
    private static List<Company> company= new ArrayList<>();

    static {
        company.add(new Company("1", "ad","ads", "ad", "asd", "ad", "ad", "ad", "sad"));
    }

    public static List<Company> search(String word){

        Stream<Company> bstream= company.stream().filter(p -> p.getTag().equals(word));
        List<Company> result = (List<Company>) company.stream().filter(p -> p.getTag().equals(word));
        return result;
    }
}
