programa {
  funcao inicio() {
    real hrsTrabalhadasMensal, salarioPorHora, hrsExtra, salarioFinal

    // Entradas
    escreva("Informe a quantidade de horas trabalhadas no mês: \n")
    leia(hrsTrabalhadasMensal)
    escreva("Informe o valor do seu salário, por hora: \n")
    leia(salarioPorHora)

    // Processo
    se (hrsTrabalhadasMensal > 160) {
      hrsExtra = hrsTrabalhadasMensal - 160
      hrsTrabalhadasMensal = 160.0
    } senao {
      hrsExtra = 0.0
    }
    salarioFinal = (hrsExtra * salarioPorHora * 1.5) + hrsTrabalhadasMensal * salarioPorHora

    // Sai�da
    escreva("O valor do salário total é de ", salarioFinal, " reais.")
  }
}