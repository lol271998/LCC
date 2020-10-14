import java.util.Scanner;

public class daa004{

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();

		for(int t = 0; t<n; t++){

			String line = in.nextLine();
			String numbers[] = line.split(" ",2);
			String num = numbers[0];
			
			int nsum = Integer.parseInt(numbers[1]),sum = 0, size = num.length();
			//System.out.println(nsum);
			for(int i = 0; i<size; i++){
				sum+=num.charAt(i)-'0';
			}

			//System.out.println("Before change: "+num);
			
			//Adicionar 1
			if(num.charAt(size-1) == '9'){
				for(int i = size-1; i>=0; i--){
					if(num.charAt(i) != '9'){
						char c = num.charAt(i);
						c+=1;
						num = num.substring(0,i) + c + num.substring(i,size-1);
						break;
					}
					else{
						num = num.substring(0,i) + '0' + num.substring(i,size-1);
						sum--;
					}
				}
			}
			else{
				char c = num.charAt(size-1);
				c+=1;
				num = num.substring(0,size-1) + c;
			}

			sum++;

			while(sum!=nsum){
				if(num.charAt(size-1) == '9'){
					for(int i = size-1; i>=0; i--){
						if(num.charAt(i) != '9'){
							char c = num.charAt(i);
							c+=1;
							num = num.substring(0,i) + c + num.substring(i+1);
							sum++;
							break;
						}
						else{
							if(i == 0 && size-1 == 0){
								num = "10";
								sum = 1;
								size = num.length();
							}
							else if(i == 0 && size-1 != 0){
								num = "1" + num;
								sum = sum - 9;
								size = num.length();
							}
							else{
								num = num.substring(0,i) + '0' + num.substring(i+1);
								sum=sum-9;
							}
						}
					}
				}

				else{

					char c = num.charAt(size-1);
					c+=1;
					if(size - 1 == 0){
						num = ""+c;
						sum++;
					}
					else{
						num = num.substring(0,size-1) + c;
						sum++;
					}
				}
			}
			System.out.println(num);
		}
	}
}