#include <stdio.h>

int pibo(int n) {
	if (n == 0)
		return 0;
	else if (n == 1)
		return 1;
	return pibo(n - 1) + pibo(n - 2);
}

int main() {
	int num = 0;
	scanf("%d", &num);
	printf("%d", pibo(num));
}