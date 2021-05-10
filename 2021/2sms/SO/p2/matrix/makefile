.PHONY: libs libd use clean

libs:
	gcc -Wall -c matrix.c
	ar -rc libmatrix.a matrix.o
	nm -g libmatrix.a

libd:
	gcc -Wall -fPIC -c matrix.c -o matrix.o
	gcc -shared matrix.o -o libmatrix.so
	nm -g libmatrix.so

use:
	gcc -Wall use_matrix.c -o use_matrix -L. -lmatrix

clean:
	rm -f *.o *.a *.so *~ use_matrix
