import java.util.Scanner;

class Process {
	public String name;
	public int time;

	Process(String n,int t){
		name = n;
		time = t;
	}
}

public class ED237{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MyQueue<Process> fila = new LinkedListQueue<Process>();
		int it = 1;
		int t = in.nextInt();
		int p = in.nextInt();
		Process protmp;
		int tempot = 0;

		for(int i = 0; i<p; i++){
			String pn = in.next();
			int tp = in.nextInt();
			//System.out.println(pn+" "+tp);
			Process proc = new Process(pn,tp);
			fila.enqueue(proc);
		}

		while(!(fila.isEmpty())){
			if(fila.first().time-t <= 0){
				tempot+=(fila.first().time);
				System.out.println(fila.dequeue().name+" "+tempot+" "+it);

			}
			else{
				fila.first().time = fila.first().time-t;
				tempot += t;
				protmp = fila.first();
				fila.dequeue();
				fila.enqueue(protmp);
			}
			it++;
		}
	}
}