programa {
  funcao inicio() {
    inteiro opcao
    inteiro d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11 // Variaveis que guardam o cpf 
    inteiro dv1,dv2 // Variáveis que guardam o os digitos verificadores

  
    escreva("Informe o documento que deseja validar:\n 1 - CPF\n 2 - CNPJ\n")
      leia(opcao)

      escolha(opcao){
        caso 1:
        // entrada de dados
        escreva("Digite o CPF:\n")
        leia(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11)

        // processamento do primeiro digito
        inteiro op = ((d9*2)+(d8*3)+(d7*4)+(d6*5)+(d5*6)+(d4*7)+(d3*8)+(d2*9)+(d1*10))%11
        se (op < 2){
          dv1 = 0
        } senao{
          dv1 = 11 - op
        }
        
        // processamento do segundo digito 
        op = ((dv1*2)+(d9*3)+(d8*4)+(d7*5)+(d6*6)+(d5*7)+(d4*8)+(d3*9)+(d2*10)+(d1*11))%11

        se (op < 2){
          dv2 = 0
        } senao{
          dv2 = 11 - op
        }

        se((dv1 == d10) e (dv2 == d11)){
          escreva("CPF É VÁLIDO")
        } senao {
          escreva("CPF INVÁLIDO")
        }

        pare
        caso 2:
        escreva("Aqui eu vou validar o CNPJ")

        pare
        caso contrario: 
          escreva("Opção invalida")
      }
  }
}