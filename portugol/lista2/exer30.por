// Exer. 30: Encontrar a altura ideal da escada.
programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real hArvore, distancia, hEscada

		// Entradas
		escreva("Digite => \n")
		escreva("Altura da árvore: ")
		leia(hArvore)
		escreva("Distância entre árvore e escada: ")
		leia(distancia)
		
		// Processo
		hEscada = mat.raiz(mat.potencia(hArvore, 2.0)+mat.potencia(distancia, 2.0), 2.0)

		// Saída
		escreva("A altura da escada é: ",hEscada)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 290; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */