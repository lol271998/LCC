/* definition of new type complex */
typedef struct {
	int x;
	int y;
} complex;

/* definition of the complex API */
complex* complex_new(int, int);
complex* complex_add(complex *, complex *);
complex* complex_sub(complex *, complex *);
complex* complex_mul(complex *, complex *);
complex* complex_div(complex *, complex *);
complex* complex_conj(complex *);
int complex_mod(complex *);
int complex_arg(complex *);
int complex_re(complex *);
int complex_im(complex *);