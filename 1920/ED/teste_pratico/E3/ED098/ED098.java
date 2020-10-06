/* -----------------------------------
   Estruturas de Dados 2019/2020
   Triagem de Manchester [ED098]  
   ----------------------------------- */

import java.util.Scanner;
import java.util.LinkedList;

// Classe para representar um Doente
class Doente {
    public String nome;     // Nome
    public int chegada;     // Tempo de chegada
    public int atendimento; // Tempo que demora a ser atendido
    public int entrada;     // Tempo em que comecou a ser atendido

    // Construtor: inicializa os atributos
    Doente(String n, int c, int a) {
		nome        = n;
		chegada     = c;
		atendimento = a;
		entrada     = -1;
    }
}

// Classe para representar uma fila de atendimento de uma cor (necessaria criar array)
// (nota: Java nao permite criacao direta de array de genericos)
class FilaAtendimento {
    public MyQueue<Doente> fila;

    FilaAtendimento() {
		fila = new LinkedListQueue<Doente>();
    }
}

// Classe para representar uma equipa da urgencia
class Equipa {
    int numDoentes;       // Numero de doentes que atenderam
    int totalAtendimento; // Total de tempo passado a atender
    int livre;            // Tempo em que ficam livres para poder atender novo doente

    Equipa() {
		numDoentes       = 0;
		totalAtendimento = 0;
		livre            = 0;
    }

    // Novo doente d comecou a ser atendido num dado tempo t nesta equipa
    void novoDoente(Doente d, int t) {
		d.entrada = t;
    }
}

// Classe principal que contem o metodo main
class ED098 {
    // Constantes que nao mudam durante o programa: numero de cores e seus nomes
    private static final int NUM_CORES = 5;
    private static final String[] CORES = {"Vermelho","Laranja","Amarelo","Verde","Azul"};

    private static int numEquipas;               // Numero de equipas
    private static int numDoentes;               // Numero total de doentes
    private static FilaAtendimento emEspera[];   // Array com uma fila para cada cor
    private static LinkedList<Doente> atendidos; // Lista de doentes ja atendidos
    private static Equipa equipas[];             // Equipas da urgencia

    // Metodo para devolver indice de uma cor representada pela string s //DONE
    private static int indiceCor(String s) {
		int ind = -1;
		for(int i = 0; i<5; i++){
		    if(s.equals(CORES[i])) return i;
		}
		return -1;
    }

    // Ler os doentes a partir do input e coloca-los nas respetivas filas //DONE
    private static void lerDoentes(Scanner in) {
		while (in.hasNext()) {
	    	String nome     = in.next();
	    	String cor      = in.next();
	    	int chegada     = in.nextInt();
	    	int atendimento = in.nextInt();
	    	numDoentes++;
	    	//System.out.printf("Li [%s,%s,%d,%d]%n", nome, cor, chegada, atendimento); 
	    	Doente d = new Doente(nome,chegada,atendimento);
	    	emEspera[indiceCor(cor)].fila.enqueue(d);
	    	//System.out.println(emEspera[indiceCor(cor)].fila.first().nome);
		}
    }

    // Mostrar numero de doentes em cada cor (necessario para flag==0) //DONE
    private static void mostrarCores() {

		System.out.println("------------");
		System.out.println("Cores     ND");
		System.out.println("------------");
		
		for(int i = 0; i<5; i++){
			System.out.printf("%8s %3s\n",CORES[i],emEspera[i].fila.size());
		}

		System.out.println("------------");
		System.out.println("Numero doentes atendidos: "+numDoentes);
    }
    

    // Mostrar estatisticas dos doentes atendidos (necessario para flag==1 e flag==2)
    private static void mostrarAtendidos() {
		System.out.println("---------------------------");
		System.out.println("Lista dos doentes atendidos");
		System.out.println("---------------------------");
		double media = 0.0;
		// itera sobre todos os doentes já atendidos (instrução for-each)
		for (Doente d : atendidos) { 
		    System.out.println(d.nome+" "+d.chegada+" "+(d.entrada-d.chegada)+" "+(d.entrada+d.atendimento));
		    media+=((double)(d.entrada-d.chegada)/(double)atendidos.size());
		}
		System.out.println("---------------------------");
		System.out.printf("Tempo medio de espera: %.1f\n",media);
    }

    // Mostrar estatisticos das equipas (necessario para flag==2)
    private static void mostrarEquipas() {
		System.out.println("-----------------------");
		System.out.println("Equipa NDoentes MediaTA");
		System.out.println("-----------------------");

		// a completar ...
    }

    // Qual a cor da proxima equipa a ficar livre?
    private static int proximaEquipaLivre() {
    	for(int i = 0; i<5; i++){

    	}
    }

    // Qual a cor mais prioritaria com doente ainda por ser atendido no tempo atual? DONE.
    private static int proximoDoente(int tempo) {
    	
    	for(int i = 0; i<5; i++){
    		if(emEspera[i].fila.first()!=null && emEspera[i].fila.first().chegada<=tempo) return i;
    	}
   		return -1;
   	}

    // Simular processo de atendimento pelas varias equipas medicas
    private static void simular() {
    	int time = 0;
    	while(atendidos.size()<numDoentes){
    		int i = proximaEquipaLivre();
    		Equipa e = equipas[i];
    		time = equipas[e.livre];
    		if(proximoDoente(time) == -1) time++;
    		else{
    			Doente d = emEspera[proximoDoente(time).fila.dequeue()];
    			equipas[i].novoDoente(d, time);
    			d.entrada = time;
    			atendidos.addLast(d);
    		
    		}
    	}
    }

    // Inicializar variaveis
    private static void inicializar() {
		numDoentes = 0;

		emEspera = new FilaAtendimento[NUM_CORES];	
		for (int i=0; i<NUM_CORES;i++)
	 	   emEspera[i] = new FilaAtendimento();

		atendidos = new LinkedList<Doente>();

		equipas = new Equipa[numEquipas];
		for (int i=0; i<numEquipas; i++)
		    equipas[i] = new Equipa();
    }
    // ----------------------------------------------------------------

    // Funcao principal chamada no inicio do codigo
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int flag   = in.nextInt();
		numEquipas = in.nextInt();
		
		inicializar();
		lerDoentes(in);

		if (flag==0) {
		    mostrarCores();
		} else {
		    simular();
		    if (flag==2) mostrarEquipas(); 
		    mostrarAtendidos();
		}
    }
}
