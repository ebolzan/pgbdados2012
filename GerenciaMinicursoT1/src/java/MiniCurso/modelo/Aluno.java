/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MiniCurso.modelo;

/**
 *
 * @author Gabriel Lunardi
 */
public class Aluno {
    
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String telefone;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }
    
}
