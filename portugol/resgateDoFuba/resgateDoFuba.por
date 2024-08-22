//Alunos: Moisés Emanuel e Samuel Resende
programa {
	
	inclua biblioteca Util --> u
	inclua biblioteca Tipos --> t

	funcao inicio() {
		
		//Declaracao de variaveis ("p" -> posicao e "v" -> velocidade):
		real distancia, pSeuJose, pMaria, vSeuJose, vMaria
		inteiro pFuba, tempo
		cadeia quemEncontrou = "."

		//Entrada de dados:		
		escreva("Informe a distância entre os dois veículos: ")
		leia(distancia)
		
		escreva("Informe a velocidade do carro de Seu José: ")
		leia(vSeuJose)

		escreva("informe a velocidade do carro de Dona Maria: ") 
		leia(vMaria)

		//Atribuicao de valores:
		pSeuJose = 0.00
		pMaria = distancia
		pFuba = u.sorteia(t.real_para_inteiro(pSeuJose), t.real_para_inteiro(pMaria))
		tempo = 0

		//Laco de repeticao (imprime, segundo a segundo, a trajetória da busca pelo Fuba):
		enquanto(pSeuJose < pFuba e pMaria > pFuba){
			
			//Laco de repeticao (imprime a posicao dos carros e do Fubá de acordo com a distancia informada):
			para(inteiro km = 0; km <= distancia; km++){
				
				/*Escrevendo "!" caso Dona Maria se "aproxime" de Fubá",   
				 *escrevendo "S" para a posição de Seu José, 
				 *escrevendo "D" para a posição de Dona Maria, 
				 *escrevendo "F" para a posição de Fubá, 
				 *escrevendo "-" para caminho percorrido e "." para estrada a ser percorrida.
				 */

				se(km == t.real_para_inteiro(pMaria) e km == pFuba){
					escreva("!")
				}senao se(km == t.real_para_inteiro(pSeuJose)){
					escreva("S") 
				}senao se(km == t.real_para_inteiro(pMaria)){
					escreva("D")
				}senao se(km == pFuba){
					escreva("F")
				}senao se(km < pSeuJose ou km > pMaria){
					escreva("-")
				}senao{
					escreva (".")
				}
			}

			//Quebrando linha:
			escreva("\n")

			//Atualizando o tempo e as posicoes de "S", "D" e "F":
			tempo++
			pSeuJose += vSeuJose
			pMaria -= vMaria
			pFuba += u.sorteia(-3,3) 
		} 

		//Definindo quem encontrou o Fuba (com correcao para priorizar o mais proximo):
		se(pMaria - pFuba > pFuba - pSeuJose) {
			se(pSeuJose >= pFuba){
			 quemEncontrou = "Seu José encontrou"
			}senao{
			 quemEncontrou = "Dona Maria encontrou"
			}
		}senao se(pMaria - pFuba < pFuba - pSeuJose){
			se(pMaria <= pFuba){
		 		quemEncontrou = "Dona Maria encontrou"
			}senao{
				quemEncontrou = "Seu José encontrou"
			}	
		}senao{
			quemEncontrou = "Os dois encontraram"
		}
		
		
		//Saida:
		escreva(quemEncontrou, " o Fubá em ", tempo, "s.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 41; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */