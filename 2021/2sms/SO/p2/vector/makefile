.PHONY: libs libd use clean

libs:
	gcc -Wall -c vector.c
	ar -rc libvector.a vector.o
	nm -g libvector.a

libd:
	gcc -Wall -fPIC -c vector.c -o vector.o
	gcc -shared vector.o -o libvector.so
	nm -g libvector.so

use:
	gcc -Wall use_vector.c -o use_vector -L. -lvector

clean:
	rm -f *.o *.a *.so *~ use_vector
