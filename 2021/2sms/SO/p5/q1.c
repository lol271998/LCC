#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
int main(int argc, char* argv[]) {
	int i, wstatus;

	/* fork a child process */
	printf("%d\n", fork());

	/* fork another child process */
	printf("%d\n", fork());

	/* and fork another */
	printf("%d\n", fork());

	for(i=0; i<3; i++)
		wait(&wstatus);
	return EXIT_SUCCESS;
}
