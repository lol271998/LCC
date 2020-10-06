int desordem(int vec[],int size){
	int i,cont=0;
	for(i=0;i<size-1;i++){
		if(vec[i]>vec[i+1]){
			cont++;
		}
	}
}
int main(){
	int vec[6]={3, 1, 2, 2, 4, 0};
	desordem(vec,6);
}