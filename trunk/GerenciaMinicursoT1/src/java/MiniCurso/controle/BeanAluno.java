/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MiniCurso.controle;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import MiniCurso.modelo.Aluno;
import java.util.*;

@Named("BeanAluno")
@SessionScoped
public class BeanAluno implements Serializable {
    
    private Collection<Aluno> ListAluno = new ArrayList<Aluno>();
    private Aluno aluno = new Aluno();
    
    public void setListAluno(ArrayList<Aluno> ListAluno) {
        this.ListAluno = ListAluno;
    }

    public Collection<Aluno> getListAluno() {
        return ListAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void adicionar(){
        getListAluno().add(getAluno());
        Aluno a = new Aluno();
        setAluno(a);
    }
     
}
