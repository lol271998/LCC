#include <stdio.h>
#include <stdlib.h>

//Mycat

int main(int argc, char *argv[]) {

	for(int i = 1; i<argc; i++) {
		FILE *fp = fopen(argv[i],"r");
		fseek(fp, 0L, SEEK_END);
		int sz = ftell(fp);
		fseek(fp, 0, SEEK_SET);
		char *c = malloc(sizeof(char)*sz);
		while (fread(c, sizeof(char), sz-1, fp) > 0) {
        	printf("%s", c);
    	}
    	printf("\n");
    	fclose(fp);
	}
	return 0;
}