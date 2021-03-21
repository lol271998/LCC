/**
*
* Crie um programa chcase que recebe como argumentos um nome de um ficheiro e
* uma “flag”, e envie para o standard output o conte´udo do ficheiro dado:
*	• com todas as letras mai´usculas se a flag for -u;
*	• com todas as letras minusculas se a flag for -l;
*	• inalterado, se nenhuma das anteriores
*
*/

void printdefault (char* argv, int opt) {
	
	FILE *fp = fopen(argv[i],"r");
	fseek(fp, 0L, SEEK_END);
	int sz = ftell(fp);
	fseek(fp, 0, SEEK_SET);
	char *c = malloc(sizeof(char)*sz);
	
	while (fread(c, sizeof(char), sz-1, fp) > 0) {
		if(op == 1) stringLower(c);
		if(op == 2) stringUpper(c);
    	printf("%s", c);
    }
    
    printf("\n");
    fclose(fp);
}

int main(int argc, char *argv[]) {	
	
	int opt; 
      
    // put ':' in the starting of the 
    // string so that program can  
    //distinguish between '?' and ':'  
    while((opt = getopt(argc, argv, “:if:ul”)) != -1) {
    	case 'u':
    		opt = 1;
    	break;
    	case 'l':
    		opt = 2;
    	break;
    }

    for(; optind < argc; optind++){      
    	print(argv[optind],opt);
    } 
      
	return 0;
}