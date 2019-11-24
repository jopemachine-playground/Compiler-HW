int add(int x, int y) {
	int z ;
	z = x+y;
	return z;
}

int sub(int x, int y){
    int z;
    z = x-y;
    return z;
}

int div(int x, int y){
    int z;
    z = x / y;
    return z;
}

int mul(int x, int y){
    int z;
    z = x * y;
    return z;
}

void main () {
	int a = 1;
	int b = 0;

	a = div(6, 2);

	if(a or b){
        _print(mul(add(--a, ++b), 3));
	}

}
