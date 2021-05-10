/* definition of new type vector */
typedef struct {
	int x;
	int y;
	int z;
} vector;

/* definition of the vector API */
vector* vector_new(int, int, int);
vector* vector_add(vector*, vector*);
vector* vector_sub(vector*, vector*);
vector* vector_scale(int, vector*);
vector* vector_vprod(vector*, vector*);

int vector_sprod(vector*, vector*);
int vector_mod(vector*);