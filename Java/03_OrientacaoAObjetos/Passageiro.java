package vendadepassagens;

import java.time.LocalDate;
import java.time.Period;

class Passageiro {
    String nome;
    String email;
    String endereco;
    LocalDate dataNascimento;
    boolean comorbidades;
    int qntdViajada;
    
    public Passageiro(String nome, String email, String endereco, LocalDate dataNascimento, boolean comorbidades){
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.comorbidades = comorbidades;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public boolean isComorbidades() {
        return comorbidades;
    }

    public int getQntdViajada() {
        return qntdViajada;
    }
    
    //Metodos personalizados
    
        public void adicionaViagem(){
            this.qntdViajada += 1;
        }
        
        public Period retornaIdade(){

            Period idadeCliente = VendaDePassagens.dataReferencia.until(this.getDataNascimento());
            return idadeCliente;
        }
}
