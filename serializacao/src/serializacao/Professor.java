package serializacao;

import java.io.Serializable;

public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    public String nome;
    private String email;
    private String materia;

    public Professor(String nome, String email, String materia) {
        super();
        this.nome = nome;
        this.email = email;
        this.materia = materia;
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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Professor [nome=" + nome + ", email=" + email + ", materia=" + materia + "]";
    }
}
