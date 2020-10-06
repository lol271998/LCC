/*JOGO DO SCRABBLE COM ARRAYS*/
#include<stdio.h>
int scrabble(char str[]){
	int p,res=0;
	for(int i=0;str[i]!='\0';i++){
		switch(str[i]){
			case'A':case'E':case'I':case'L':case'N':case'O':
	   		case'R':case'T':case'S':case'U':
				p=1;
				break;
	   		case'D':case'G':
				p=2;
	    		break;
	   		case'B':case'C':case'M':case'P':
				p=3;
				break;
	   		case'F':case'H':case'V':case'W':case'Y':
				p=4;
				break;
	   		case'K':
				p=5;
				break;
	   		case'J':case'X':
				p=8;
				break;
	   		case'Q':case'Z':
				p=10;
				break;
		}
		res=res+p;
	}
	return res;
}
int main(void){
	printf("O resultado é: %d\n",scrabble("PITFALL"));
}