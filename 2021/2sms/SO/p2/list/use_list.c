#include <stdio.h>
#include "list.h"


int main() {
  list* l = list_new();
  list_add_first(5,l);
  list_add_first(2,l);
  list_print(l);
  printf("list_get_last: %d\n",list_get_last(l));
  list_remove_last(l);
  list_print(l);
  list_remove_last(l);
  list_print(l);
  
  return 0;
}
