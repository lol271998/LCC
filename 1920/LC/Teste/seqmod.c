#include<stdio.h>
#include<stdlib.h>
#include<getopt.h>
#include<ctype.h>

int main(int argc, char* argv[]){
	int first = 1;
	int inc = 1;
	int last;
	int m = atoi(argv[1]);
	if(argc == 3){
		last = atoi(argv[2]);
	}
	if(argc == 4){
		first = atoi(argv[2]);
		last = atoi(argv[3]);
	}
	if(argc == 5){
		first = atoi(argv[2]);
		inc = atoi(argv[3]);
		last = atoi(argv[4]);
	}
	if(inc>=0){
		for(int i = first; i<=last; i+=inc){
			printf("%d\n",i%m);
		}
	}
	else{
		for(int i = first; i>=last; i+=inc){
			printf("%d\n",i%m);
		}
	}

}