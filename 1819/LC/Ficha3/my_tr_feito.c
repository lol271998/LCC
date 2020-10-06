#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>

int pos(char c, char* cv){
  int i = 0;
  int lencv = strlen(cv);
  for(; i < lencv; i++){
      if(c == cv[i]){
		  return i;
		}
	}
  return -1;
}

void weird(int n, char* ca){
  if(ca[n-1] == '\\'){
	      if(ca[n] == 'n')
		putchar('\n');
	      else if(ca[n] == 't')
		putchar('\t');
	}
}

int main(int argc, char** argv){

	int dflag, sflag1, sflag2, hasopt;
	dflag = sflag1 = sflag2 = hasopt = 0; 
	  
	char c;
	  
	  //Vê se tem opções
	  while((c = getopt(argc,argv,"sd")) != -1){
	    hasopt = 1;
	    switch(c){
			case 'd':
				dflag = 1;
		    	break;
			case 's':
		  		if(argc==3)
		    		sflag1 = 1;
		  		else
		    		sflag1 = sflag2 = 1;
		  	break;
			}
	    }

		if(hasopt != 1){
	      sflag2 = 1;
		}

	  	if(dflag){
	    	while((c = getchar()) != EOF){
				if(strchr(argv[2],c) == NULL) putchar(c);	  
			}
	    }
	    
	 	else if(sflag1 && !sflag2){
	      	char cbef;
	      	c = getchar();
	      	cbef = c;
	    	putchar(c);
	    	if(c!=EOF)
			while((c = getchar()) != EOF){
		    	if(pos(c,argv[2]) != -1){
					if(cbef!=c){
			    		putchar(c);
					}
				}
		    	else{
				putchar(c);
		    	}
		    	cbef = c;
			}
		}
	  	else if(sflag1 && sflag2){
	      	char cbef, ch, chbef;
	      	c = getchar();
	      	cbef = c;
	      	putchar(c);

	    	if(pos(c,argv[hasopt+1]) == -1){
		    	chbef = cbef = c;
			}
	      	else if(pos(c,argv[hasopt+1]) < strlen(argv[hasopt+2])){
		    	chbef = argv[hasopt+2][pos(c,argv[hasopt+1])];
			}
	      	else{
		    	chbef = argv[hasopt+2][strlen(argv[hasopt+2]) - 1];
			}

	      
	    if(c!=EOF)
			while((c = getchar()) != EOF){
		    if(pos(c,argv[2]) != -1){
			if(cbef!=c){
			    if(c == '\n'){
					if(pos('\\',argv[hasopt+1]) == pos('n',argv[hasopt+1]) - 1){
				    	weird(pos('n',argv[hasopt+1]), argv[hasopt+2]);
					}
					else{
				  		ch = c;
				    	putchar(c);
					}
				}
			    else if(c == '\t'){
					if(pos('\\',argv[hasopt+1]) == pos('t',argv[hasopt+1]) - 1){
				    	weird(pos('t',argv[hasopt+1]), argv[hasopt+2]);
				  	}
					else{
				    	ch = c;
				    	putchar(c);
				  }
			    }
			    else if(pos(c,argv[hasopt+1]) == -1){
					ch = c;
					if(ch!=chbef && ch!=cbef) putchar(c);
			    }
			    else if(pos(c,argv[hasopt+1]) < strlen(argv[hasopt+2])){
					ch = argv[hasopt+2][pos(c,argv[hasopt+1])];
					if(ch!=chbef && ch!=cbef)
				  	putchar(argv[hasopt+2][pos(c,argv[hasopt+1])]);
			    }
			   else
			      {
				ch = argv[hasopt+2][strlen(argv[hasopt+2]) - 1];
				if(ch!=chbef && ch!=cbef)
				  putchar(argv[hasopt+2][strlen(argv[hasopt+2]) - 1]);
			      }
			  }
		      }
		    else if(pos(c,argv[hasopt+2]) != -1)
		      {
			ch = c;
			if(ch!=chbef)
			  putchar(c);
		      }
		    else
		      {
			ch = c;
			putchar(c);
		      }
		    cbef = c;
		    chbef = ch;
		  }
	    }
	  else if(sflag2)
	    {
	      if(argv[hasopt+1][1] == '-')	    
		{
		  int isup = 0;
		  if(isupper(argv[hasopt+1][0]))
		    {
		      isup = 1;	    
		    }
		  
		  while((c=getchar()) != EOF)
		    {
		      if(isup)
			c = tolower(c);
		      else
			c = toupper(c);
		      putchar(c);
		    }
		}
	      else
		{
		  while((c=getchar()) != EOF)
		    {
		      if(c == '\n')
			{
			  if(pos('\\',argv[hasopt+1]) == pos('n',argv[hasopt+1]) - 1)
			    {
			      weird(pos('n',argv[hasopt+1]), argv[hasopt+2]);
			    }
			  else
			    {
			      putchar(c);
			    }
			}
		      else if(c == '\t')
			{
			  if(pos('\\',argv[hasopt+1]) == pos('t',argv[hasopt+1]) - 1)
			    {
			      weird(pos('t',argv[hasopt+1]), argv[hasopt+2]);
			    }
			  else
			    {
			      putchar(c);
			    }
			}
		      else if(pos(c,argv[hasopt+1]) == -1)
			{
			  putchar(c);
			}
		      else if(pos(c,argv[hasopt+1]) < strlen(argv[hasopt+2]))
			{
			  putchar(argv[hasopt+2][pos(c,argv[hasopt+1])]);
			}
		      else
			{
			  putchar(argv[hasopt+2][strlen(argv[hasopt+2]) - 1]);
			}
		    }
		}
	    }

	  return 0;
	}