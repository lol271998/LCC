#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <getopt.h>
#include <string.h>

#define MAX_LEN 1024 // Length of each line in input file.
#define bufsize 1024 

int openandsort(char* strFileName){
    
    char strTempData[MAX_LEN];
    char **strData = NULL; // String List
    int i, j;
    int noOfLines = 0;
    
    FILE * ptrFileLog = NULL;

    if ( (ptrFileLog = fopen(strFileName, "r")) == NULL ) {
        fprintf(stderr,"./my_sort: <file>: No such file or directory \n");
        return 1;
    }
    // Read and store in a string list.
    while(fgets(strTempData, MAX_LEN, ptrFileLog) != NULL) {
        // Remove the trailing newline character
        if(strchr(strTempData,'\n'))
            strTempData[strlen(strTempData)-1] = '\0';
        strData = (char**)realloc(strData, sizeof(char**)*(noOfLines+1));
        strData[noOfLines] = (char*)calloc(MAX_LEN,sizeof(char));
        strcpy(strData[noOfLines], strTempData);
        noOfLines++;
    }
    // Sort the array.
    for(i= 0; i < (noOfLines - 1); ++i) {
        for(j = 0; j < ( noOfLines - i - 1); ++j) {
            if(strcmp(strData[j], strData[j+1]) > 0) {
                strcpy(strTempData, strData[j]);
                strcpy(strData[j], strData[j+1]);
                strcpy(strData[j+1], strTempData);
            }
        }
    }
    fclose(ptrFileLog);
    // Write it to outfile. file.
    for(i = 0; i < noOfLines; i++)
        printf("%s\n",strData[i]);
    // free each string
    for(i = 0; i < noOfLines; i++)
        free(strData[i]);
    // free string list.
    free(strData);
    return 0;
}

int main(int argc, char* argv[]){
	char **strData = NULL; // String List
	int option,i,j;
	int noOfLines = 0;
	char c;
	char strTempData[MAX_LEN];

	//Lê da entrada padrão
	if(argc == 1){
		i = 0;
		while(1){
			c = getchar();
			if(c != EOF || c != '\0'){
					strData[noOfLines][i] = c;
					i++;
			}
			if(c == '\n') noOfLines++;
		}
	}
	qsort(strData,noOfLine)
    //Caso em que abre o ficheiro
	if(argc == 2){
		openandsort(argv[1]);
	}
	else
		while ((option = getopt(argc, argv, "rnkt")) != -1){
			printf("teste");
		}
	return 0;
}