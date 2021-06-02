#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>
#include <sys/wait.h>

#define READ 0
#define WRITE 1

#define MAX_BUFFER_SIZE 1024

int main(int argc, char* argv[]) {
    int fd[2];
    if (pipe(fd) == -1) {
        return 1;
    }
    
    int pid = fork();
    if (pid == -1) {
        return 2;
    }
    
    if (pid == 0) {
        // Child  process
        close(fd[READ]);
    
        char str[MAX_BUFFER_SIZE];
        char c;
        int i = 0;
        while((c = fgetc(stdin)) != EOF) {
            str[i] = toupper(c);
            i++; 
        }
        str[i] = '\0';
        
        int n = i + 1;
        if (write(fd[WRITE], &n, sizeof(int)) < 0) {
            return 3;
        }
        
        if (write(fd[WRITE], &str, sizeof(char) * n) < 0) {
            return 4;
        }
        close(fd[WRITE]);
    } 
    else {
        close(fd[WRITE]);
        char str[MAX_BUFFER_SIZE];
        int n;
        
        if (read(fd[0], &n, sizeof(int)) < 0) {
            return 5;
        }
        if (read(fd[0], &str, sizeof(int) * n) < 0) {
            return 6;
        }
        printf("%s", str);
        
        close(fd[0]);
        wait(NULL);
    }
    
    return 0;
}