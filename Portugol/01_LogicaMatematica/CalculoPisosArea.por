programa
{
	inclua biblioteca Tipos --> tip
	
	funcao inicio()
	{
		real lado, qntdDePisos
		inteiro pisosGastos

		// Entrada
		escreva("Digite o lado do quadrado: ")
		leia(lado)

		// Processo
		qntdDePisos = (lado*lado)/0.3
		pisosGastos = tip.real_para_inteiro(qntdDePisos)

		se (qntdDePisos - pisosGastos != 0) {
			pisosGastos = pisosGastos + 1
		}
		
		// Saída
		escreva("A área do chão é de: ", lado*lado, "m².\n")
		escreva("A quantidade de pisos gastos foi de: ", pisosGastos, " pisos.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 500; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */