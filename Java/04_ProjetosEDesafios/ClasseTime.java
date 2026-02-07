class ClasseTime {
    
    String nome;
    int pontos;
    int saldoDeGols;

    int golsFeitos;
    float golsPro;
    int jogosRealizados;

    int cartoesVermelhos;
    int cartoesAmarelos;
    
    public ClasseTime(String nome){
        this.nome = nome;
    }

    //SETTERS
    
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setPontos(int pontos) {
            this.pontos = pontos;
        }

        public void setSaldoDeGols(int saldoDeGols) {
            this.saldoDeGols = saldoDeGols;
        }
        
        
        public void setGolsFeitos(int golsFeitos) {
            this.golsFeitos = golsFeitos;
        }

        public void setGolsPro(float golsPro) {
            this.golsPro = golsPro;
        }
        
        public void setJogosRealizados(int jogosRealizados) {
            this.jogosRealizados = jogosRealizados;
        }

        public void setCartoesVermelhos(int cartoesVermelhos) {
            this.cartoesVermelhos = cartoesVermelhos;
        }

        public void setCartoesAmarelos(int cartoesAmarelos) {
            this.cartoesAmarelos = cartoesAmarelos;
        }
        
    //GETTERS    

        public String getNome() {
            return nome;
        }

        public int getPontos() {
            return pontos;
        }

        public int getSaldoDeGols() {
            return saldoDeGols;
        }

        public int getGolsFeitos() {
            return golsFeitos;
        }
            
        public float getGolsPro() {
            return golsPro;
        }
        
        public int getJogosRealizados() {
            return jogosRealizados;
        }

        public int getCartoesVermelhos() {
            return cartoesVermelhos;
        }

        public int getCartoesAmarelos() {
            return cartoesAmarelos;
        }

}
