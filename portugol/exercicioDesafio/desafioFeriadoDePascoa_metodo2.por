programa
{
	
	funcao inicio()
	{
		inteiro vCompra, vNota, vMoeda, vNaCarteira // 'v' => 'valor'
		inteiro qNota, qMoeda // 'q' => quantidade

		// Entrada
		escreva("Digite o valor da compra: ")
		leia(vCompra)

		// Processos
		vNota = 5
		vMoeda = 1
		qNota = 10
		qMoeda = 10
		vNaCarteira = vNota*qNota + vMoeda*qMoeda

		se (vCompra > vNaCarteira) {
			// Saída 1
			escreva("Dinheiro insuficiente.")
		} senao se (vCompra < 5) {
			// Saída 2
			escreva("Você deve utilizar ", 0, " notas e ", vCompra, " moedas.")
		} senao {
			enquanto (vCompra%5 != 0) {
				vCompra = vCompra - 1
				qMoeda = qMoeda - 1
			}
			se (vCompra%5 == 0 e qMoeda == 10 e vCompra != 5) {
				vCompra = vCompra - 10
				qMoeda = qMoeda - 10
				qNota = vCompra/5
			} senao se (vCompra%5 == 0 e qMoeda >=5) {
				vCompra = vCompra - 5
				qMoeda = qMoeda - 5
				qNota = vCompra/5
			} senao {
				qNota = vCompra/5
			}
			// Saída 3
			escreva("Você deve utilizar ", qNota, " notas e ", 10 - qMoeda, " moedas.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 747; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */