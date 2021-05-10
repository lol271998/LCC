.PHONY: libs libd use clean

libs:
	gcc -Wall -c list.c
	ar -rc liblist.a list.o
	nm -g liblist.a

libd:
	gcc -Wall -fPIC -c list.c -o list.o
	gcc -shared list.o -o liblist.so
	nm -g liblist.so

use:
	gcc -Wall use_list.c -o use_list -L. -llist -lm

clean:
	rm -f *.o *.a *.so *~ use_list
