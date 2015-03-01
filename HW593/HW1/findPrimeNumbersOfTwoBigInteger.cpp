//writen by Rui

#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <iostream>
#include <math.h>

using namespace std;



void markMultiples(bool arr[], long long a, long long n)
{
	long long i = 2, num;
	while ((num = i*a) <= n)
	{
		arr[num - 1] = 1;// minus 1 because index starts from 0.
		++i;
	}
}


void SieveOfEratosthenes(long long n1, long long &count, long long *primeArry)
{
		bool arr[1000000];
		memset(arr, 0, sizeof(arr));
		
		for (long long i = 0; i <= 10; i++){
			cout<< arr[i];
		}
		for (long long i = 1; i<n1; ++i)
		{
			if (arr[i] == false)
			{
				primeArry[count] = i + 1;
				count++;
				markMultiples(arr, i + 1, n1);

			}
		}
	
}

bool isPrime(long long n, long long *primeArry){
	if (n == 1)return false;
	if (n == 2)return true;
	if (n == 3)return true;
	if ((n % 6 != 1) && (n % 6 != 5))
		return false;
	for (long long j = 0; primeArry[j] <= sqrt(n)&&j<=78497; j += 1){
		if (n%primeArry[j] == 0)return false;
		}
	for (long long i = 999984; i <= sqrt(n); i++){
				if (n%i == 0)return false;
	}

	return true;
}
// Driver Program to test above function
int main()
{
	
	long long *primeArry = new long long [100000];
	long long count = 0;
	long long a = 0;
	long long b = 0;
	long long n1 = 1000000;
	printf("Following are the prime numbers below %d\n", n1);
	long long t1 = GetTickCount();
	SieveOfEratosthenes(n1, count, primeArry);
	long long t2 = GetTickCount();
	cout << "running time:" << t2 - t1 << "ms" << endl;
	cout << primeArry[78498] << endl;
	cout << primeArry[78497] << endl;
	cout << primeArry[0] << endl;
	cout << primeArry[1] << endl << endl << endl;


	cout << " please input the first number:";
	cin >> a;
	cout << "\n" << "please input the second number:";
	cin >> b;



	DWORD t3 = GetTickCount();
	long long count1 = 0;

	for (long long n2 = a; n2 <= b; n2++){
		if (isPrime(n2, primeArry)){

			//if (count1 == 10000) { cout << "\n" << n; }
			count1++;
		}
	}

	DWORD t4 = GetTickCount();

	cout << "\n" << "count of primes: " << count1 << "\n";

	cout << "running time:" << t4 - t3 << "ms";

	return 0;
}