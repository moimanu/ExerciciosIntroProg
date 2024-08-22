programa
{
	
	funcao inicio()
	{
		inteiro vCompra, vNota, vMoeda

		// Entrada
		escreva("Digite o valor da compra: ")
		leia(vCompra)

		// Processos
		vNota = 5
		vMoeda = 1
		se (vCompra > 10*vNota + 10*vMoeda) {
			// Saída 1
			escreva("Você não possui dinheiro suficiente.")
		} senao se (vCompra >= 55) {
			// Saída 2
			escreva("Use 10 notas e ", vCompra-50, " moedas.")
		} senao {
			// Saída 3
			escreva("Use ", vCompra/vNota, " notas e ", vCompra%vNota, " moedas.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 309; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */
