#include <stdlib.h>
#include <math.h>

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
	vector* v3 = vector_new(v1->x + v2->x,v1->y + v2->y,v1->z + v2->z);
	return v3;
}

vector* vector_sub(vector* v1, vector* v2) {
	vector *v3 = vector_new(v1->x - v2->x, v1->y - v2->y, v1->z - v2->z);
	return v3;
}

vector* vector_scale(double d, vector* v) {
	vector *u = vector_new(v->x*d,v->y*d,v->z*d);
	return u;
}

vector* vector_vprod(vector* v1, vector* v2) {
	//double v = vector_sprod(v1,v2);
	return v1;
}

double vector_sprod(vector* v1, vector* v2) {
	double r = v1->x*v2->x + v1->y*v2->y + v1->z*v2->z;
	return r;
}

double vector_mod(vector* v1) {	return sqrt(v1->x*v1->x+v1->y*v1->y); }
