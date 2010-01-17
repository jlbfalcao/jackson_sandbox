package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: falcao
 * Date: Jan 17, 2010
 * Time: 12:44:22 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class Modelo {

    private String nome;
    private String email;
    private List<String> nomes;
    private Map<String, String> opa;


    public Modelo() {
    }

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }

    public Map<String, String> getOpa() {
        return opa;
    }

    public void setOpa(Map<String, String> opa) {
        this.opa = opa;
    }

    public Modelo(String s, String s1) {
        nome = s;
        nomes = new LinkedList<String>();
        nomes.add("oi");
        nomes.add("ola");

        opa = new HashMap<String, String>();
        opa.put("aaa", "bbb");



        email = s1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
