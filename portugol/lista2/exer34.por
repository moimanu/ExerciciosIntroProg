// Exer. 34: Encontrar o salário bruto e líquido de um funcionário.
programa
{
	
	funcao inicio()
	{
		// Entradas
		real salarioMin, hTrab, nDependentes
		escreva("Digite o valor do salário mínimo: ")
		leia(salarioMin)
		escreva("Digite o número de horas trabalhadas: ")
		leia(hTrab)
		escreva("Digite o número de dependentes do funcionário: ")
		leia(nDependentes)

		// Processo
		real valorHTrab, salarioDoMes, auxilioFamilia, salarioBruto, irrf, salarioLiquido
		valorHTrab = salarioMin/5
		salarioDoMes = hTrab*valorHTrab
		auxilioFamilia = nDependentes*250
		salarioBruto = salarioDoMes+auxilioFamilia
		irrf = salarioBruto*0.275
		salarioLiquido = salarioBruto-irrf

		// Saída
		escreva("O salário bruto é de ", salarioBruto, " reais e o salário liquido é de ", salarioLiquido, " reais.")	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 692; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */