package br.com.nextgen2020.comandablue.model.entidade;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario extends Usuario{

    @NotNull
    private String funcao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
