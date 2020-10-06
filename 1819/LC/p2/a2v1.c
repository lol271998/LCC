#include<stdio.h>
#include<string.h>
int main(int argc, char **argv){
	int numc;
	for(int i = 1;i<argc;i++){
		numc = strlen(argv[i]);
		printf("%d\n",numc);
	}
	return 0;
}