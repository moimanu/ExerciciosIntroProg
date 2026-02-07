programa {
  funcao inicio() {
    
    cadeia nome
    inteiro idade, dependentes
    inteiro aumento = 0
    real salario
    caracter sexo
    logico escreveuErrado = falso

    // Entradas
    escreva("Informe o seu nome: \n")
    leia(nome)
    escreva("Informe a sua idade: \n")
    leia(idade)
    escreva("Informe a quantidade de seus dependentes: \n")
    leia(dependentes)
    escreva("Informe o seu salário: \n")
    leia(salario)
    escreva("Informe o seu sexo (M - Masculino/F - Feminino): \n")
    leia(sexo)
    escreva("\n")
  
    // Processo
    escolha(sexo){
      caso 'M':
        se(dependentes > 7){
          aumento += 25
        }
        se(idade > 55){
          aumento += 15
        }
        se(dependentes <= 7 e idade <= 55){
          aumento += 5
        }
      pare

      caso 'F':
        se(idade > 40 ou dependentes > 5){
          aumento = 30
        } senao {
          aumento += 5
        }
      pare

      caso contrario:
        escreveuErrado = verdadeiro
    }

    // Saidas
    se(escreveuErrado){
      escreva("Sexo inválido, tente novamente...\n")
    } senao {
      escreva("O seu salário final é de ", salario + salario*(aumento/100), " reais.\n")
    }
  }
}
