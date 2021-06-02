#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

int main(int argc, char const *argv[]) {

	if(argc < 2) {
		printf("Error: Not enough arguments \n");
		return 1;
	}
	char* line = NULL;
	size_t n = 0;
	int line_count = 0;
	FILE *fp = fopen(argv[2],"r");

	const char* needle = argv[1];

	while ((getline(&line,&n,fp)) != -1) {
		//printf("n: %ld\n",n);
		line_count++;
		char* str = strstr(line,needle);

		if(str!=NULL) {
			printf("[%d:%ld",line_count,(strlen(line)-(strlen(str))+1));
			str++;
			str = strstr(str,needle);
			while(str!=NULL) {
				printf(",%ld",(strlen(line) - strlen(str)+1));
				str++;
				str = strstr(str,needle);
			}
			printf("]\n");
		}

		free(str);
		str = NULL;
		free(line);
		n = 0;
		line = NULL;
	}

	return 0;
}
