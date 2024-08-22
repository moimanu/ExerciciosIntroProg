// Exer. 29: Encontrar o saldo final da conta após dois cheques.
programa
{
	
	funcao inicio()
	{
		real salario, cheque1, cheque2, saldo

		// Entradas
		escreva("Digite os valores => \n")
		escreva("Salário: ")
		leia(salario)
		escreva("1º cheque: ")
		leia(cheque1)
		escreva("2º cheque: ")
		leia(cheque2)

		// Processo
		saldo = salario - cheque1 - (cheque1*0.0038) - cheque2 - (cheque2*0.0038)

		// Saída
		escreva("O saldo final ficou em ", saldo)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 64; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */