#include <stdio.h>
#include <stdlib.h>

int main(int argc,char *argv[]){
   char c;
	if(argc==1){
	   while((c=getchar())!= EOF) printf("%c",c);
	   return 0;
	}
	
	FILE* fp;
	for(int i=1;i<argc;i++){
	   if(*argv[i]=='-'){
	      while((c=getchar())!= EOF) printf("%c",c);
	      continue;
	   }
	   fp = fopen(argv[i],"r");
	   while((c=fgetc(fp))!= EOF) printf("%c",c);
	   fclose(fp);
	}
	return 0;	
}