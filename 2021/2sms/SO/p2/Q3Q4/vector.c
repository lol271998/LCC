#include <stdlib.h>

#include "vector.h"
/*
 *	Implementation of the Vector API
 */

vector* vector_new(double x,double y,double z) {
	vector* v = (vector*) malloc(sizeof(vector));
	v->x = x;
	v->y = y;
	v->z = z;
	return v;
}

vector* vector_add(vector* v1, vector* v2) {
	return v1;
}

vector* vector_sub(vector* v1, vector* v2) {
	return v1;
}

vector* vector_scale(double d, vector* v) {
	return v;
}

vector* vector_vprod(vector* v1, vector* v2) {
	return v1;
}

double vector_sprod(vector* v1, vector* v2) {
	return 0.1;
}

double vector_mod(vector* v1) {
	return 0.1;
}



