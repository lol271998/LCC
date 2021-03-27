#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
	int d = 0;
	for (int i = 0; i < 4; i++) {
		if(fork() != 0)
			printf("fork: %d, d: %d\n",fork(),d);
	}
	
	return EXIT_SUCCESS;
}