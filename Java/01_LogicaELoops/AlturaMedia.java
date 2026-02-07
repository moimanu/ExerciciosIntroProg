//Criar um algoritmo que analise a altura de um grupo de 150 pessoas e determine quantas pessoas possuem altura superior à média do grupo.

import java.util.Scanner;

public class AlturaMedia {
    
    public static void main (String[] args) {
        
        float alturas[] = new float[150];
        int cont = 0; 
        int soma = 0;
        
        
        Scanner t = new Scanner(System.in);
        
        do {
            alturas[cont] = t.nextFloat();
            soma += alturas[cont];
            cont++;
        } while(cont < 150);
        
        float media = soma/150;
        cont = 0;
        
        for(int i = 0; i < 150; i++) {
            if(alturas[i] > media) {
                cont++;
            }
        }
        
        System.out.print(cont);
    }
}


/* EXEMPLO DE ENTRADA (saída: 73):

188
152
134
162
161
131
84
213
112
116
206
97
202
168
122
155
223
123
131
113
105
164
127
91
145
220
109
216
174
196
220
210
116
104
110
135
104
219
139
100
170
160
154
168
187
170
202
219
182
201
151
145
131
186
193
127
86
81
214
193
87
229
159
173
154
81
207
208
102
107
168
162
147
170
144
192
116
97
137
103
196
162
127
184
78
137
218
212
172
166
163
229
225
166
99
206
186
143
190
104
94
158
151
186
79
87
93
149
97
80
147
121
151
146
126
168
189
197
159
133
183
160
120
215
89
89
139
144
120
151
150
156
229
137
211
201
178
146
220
146
221
196
227
119
113
142
152
141
180
228

*/