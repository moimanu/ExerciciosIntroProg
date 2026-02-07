programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real distancia, consumo, valorLGasolina, gasto, litroGasto, valorGasto

		// Entradas
		escreva("Digite a distância da viagem (ida e volta) em km: ")
		leia(distancia)
		escreva("Digite o preço da gasolina, por litro: ")
		leia(valorLGasolina)
		escreva("Digite o consumo do carro, em km por litro: ")
		leia(consumo)

		// Processo
		litroGasto = distancia/consumo
		valorGasto = consumo*valorLGasolina

		// Saídas
		escreva("Quantidade gasta de gasolina, em litros: ", mat.arredondar(litroGasto, 2), "\n")
		escreva("Valor gasto: ", mat.arredondar(valorGasto, 2)) 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 465; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */