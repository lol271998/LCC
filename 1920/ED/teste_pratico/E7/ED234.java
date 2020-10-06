/*
Nome: Filipe Colla David
Número mecanográfico: 201810097
Sobre ajudas: O professor Pedro Ribeiro ajudou me a identificar um erro 
Explicação da solução: na flag1 criei uma árvore binária de pesquisa, fui adicionando os vários filmes à árvore, caso
fossem repetidos não eram adicionados à àrvore (por definição), e no final era contar o numero de nós da árvore e temos o numero de filmes
com pelo menos uma avaliação. 
Para a flag 2 e 3, criei dois dicionários, um para contar quantas avaliações tinha cada filme e outro para guardar o 
somatório de todas as avaliações do filme, caso o filme não tivesse ainda sido adicionado, "inicializo" o filme com 
uma entrada, no caso do dicionário para contar as avaliações, e adicionava a avaliação, para o dicionário das avaliações,
caso esse filme já existisse, incrementava o valor associado a esse filme no dicionário de contagem e somo a sua 
respectiva avaliação. Faço também a comparação com uma variavel max, de modo a guardar o valor máximo de avaliações de um
filme e o seu respectivo nome com outra variável (maxs).
No final, caso a flag for a 2 imprimo o nome do filme com maior avaliações, caso contrário, percorro os dois dicionários, 
que têm uma estrutura idêntica e faço a média de cada filme usando o valor do somatório, e o numero de avaliações, que 
está guardado no dicionário de contagem.
*/

import java.util.Scanner;
import java.util.LinkedList;

public class ED234{
	
	public class film{
		private String name;
		private int nota;

		film(String name1, int nota1){
			name = name1;
			nota = nota1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int flag = in.nextInt();
		if(flag == 1){
			int n = in.nextInt();
			BSTree<String> movies = new BSTree<>();
			for(int i = 0; i<n; i++){
				String name = in.next();
				movies.insert(name);
				in.nextLine();
			}
			System.out.println(movies.numberNodes());
			return;
		}
		else{
			BSTMap<String,Integer> map_count = new BSTMap<>();
			BSTMap<String,Double> map_rating = new BSTMap<>();
			int n = in.nextInt();
			int max = 0;
			String maxs = new String();
			for(int i = 0; i<n; i++){
				String name = in.next();
				int rating = in.nextInt();
				double r = rating;
				if(map_count.get(name) == null){
					map_count.put(name,1);
					map_rating.put(name,r);
				}
				else{
					int val = map_count.get(name);
					val++;
					if(val>max){
						max = val;
						maxs = name;
					}
					map_count.put(name,val);
					double med = (map_rating.get(name) + rating);
					map_rating.put(name,med);
				}
			}
			if (flag == 2) System.out.println(maxs+" "+max);
			if (flag == 3){
				for (String k : map_count.keys()){
					if(map_rating.get(k)/map_count.get(k)>=5)
						System.out.println(k);
				}
			}
		}
	}
}