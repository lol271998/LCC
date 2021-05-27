#include <stdio.h>
#include <ctype.h>

#define READ 0
#define WRITE 1


int main(int argc, char const *argv[]) {
    size_t pid;
    int p[2];
    pipe(p);
    pid = fork();

    if(pid == 0) {

    }
    else {
        FILE *fp = fopen(argv[1],"r");
        char c;
        while(c = fgetc(fp) != EOF) {
            
        }
        fclose();
    }
    return 0;
}
