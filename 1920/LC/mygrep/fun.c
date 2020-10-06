#include<stdio.h>
#include <time.h> 

void delay(int number_of_seconds) 
{ 
    // Converting time into milli_seconds 
    int milli_seconds = 190000 * number_of_seconds; 
  
    // Storing start time 
    clock_t start_time = clock(); 
  
    // looping till required time is not achieved 
    while (clock() < start_time + milli_seconds) 
        ; 
} 

int main(){ 

	for(int i = 0; i<100; i++){
		delay(1);
		//if(i == 5)printf("MANDA NUDES\n");
		if(i%2==0){
			printf("    ^^^^^  \n");
			printf("    |   |  \n");
			printf("    |___|  \n");
			printf("      |    \n");
			printf("\\     |    /\n");
			printf(" \\    |   /\n");
			printf("  \\   |  /\n");
			printf("   \\  | /\n");
			printf("    \\ |/\n");
			printf("      |  \n");
			printf("      |  \n");
			printf("    |   | \n");
			printf("    |   |  \n");
			printf("    |   |  \n");
			printf("    |   | \n");
			printf("    |   | \n");
			printf("    |   | \n");
			printf("\n");
		}
		else{
			printf("    ^^^^^  \n");
			printf("    |   |  \n");
			printf("    |___|  \n");
			printf("      |    \n");
			printf("       |\n");
			printf("       |\n");
			printf("-------|-----\n");
			printf("       |\n");
			printf("       |\n");
			printf("      |  \n");
			printf("      |  \n");
			printf("     / \\    \n");
			printf("    /   \\   \n");
			printf("   /     \\  \n");
			printf("  /       \\ \n");
			printf(" /         \\\n");
			printf("\n");
		}
	}
}