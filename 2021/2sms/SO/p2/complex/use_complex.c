#include <stdio.h>
#include <stdlib.h>
#include "complex.h"

int main(int argc, char** argv) {
	complex* z1 = complex_new(-2.16793, 5.23394);
	complex* z2 = complex_new( 1.12227, 2.52236);
	
	complex* z3 = complex_add(z1, z2);
	complex* z4 = complex_sub(z1, z2);
	complex* z5 = complex_mul(z1, z2);
	complex* z6 = complex_div(z1, z2);
	
	int x1 = complex_mod(z1);
	int x2 = complex_re(z1);
	int x3 = complex_im(z3);
	
	printf("z1 = %d + %di\n", z1->x, z1->y);
	printf("z2 = %d + %di\n", z2->x, z2->y);
	printf("z3 = %d + %di\n", z3->x, z3->y);
	printf("z4 = %d + %di\n", z4->x, z4->y);
	printf("z5 = %d + %di\n", z5->x, z5->y);
	printf("z6 = %d + %di\n", z6->x, z6->y);
	printf("x1 = %d\n", x1);
	printf("x2 = %d\n", x2);
	printf("x3 = %d\n", x3);
	
	return 0;
}