//writen by Rui
#include <vector>
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



long long SieveOfEratosthenes(long long n1, long long &count, long long *primeArry)
{
		long long sum = 0;
		bool *arr = new bool[n1];
	
		for (long long i = 0; i <= n1; i++){
			arr[i] = 0;
		}
		//for (long long i = 0; i <= 10; i++){
		//	cout<< arr[i];
		//}
		for (long long i = 1; i<n1; ++i)
		{
			if (arr[i] == false)
			{
				primeArry[count] = i + 1;
				count++;
				markMultiples(arr, i + 1, n1);
				sum = sum + 1 + i;
			}
		}
		return sum;
	
}

long long SieveOfEratosthenes1(long long n1)
{
	long long sum = 0;
	bool *arr = new bool[500000000];
	
	
	for (long long i = 0; i <= n1; i++){
		arr[i] = 0;
	}
	//for (long long i = 0; i <= 10; i++){
	//	cout<< arr[i];
	//}
	for (long long i = 1; i<n1; ++i)
	{
		if (arr[i] == false)
		{
			markMultiples(arr, i + 1, n1);
			sum = sum + 1 + i;
		}
	}
	return sum;
}

bool isPrime(long long n, long long *primeArry,long long count){
	if (n == 1)return false;
	if (n == 2)return true;
	if (n == 3)return true;
	if ((n % 6 != 1) && (n % 6 != 5))
		return false;
	for (long long j = 0; primeArry[j] <= sqrt(n) && j < count; j += 1){
		if (n%primeArry[j] == 0)return false;	
	}

	return true;
}
// Driver Program to test above function
int main()
{
	

	long long count = 0;
	long long countT1 = 0; 
	long long countT2 = 0;
	
	long long a = 0;
	long long b = 0;
	
	cout << " please input the first number:";
	cin >> a;
	cout << "\n" << "please input the second number:";
	cin >> b;


	
	long long nT1 = 0;
	long long nT2 = 0;
	long long n1 = sqrt(b);

	long long *primeArry = new long long [1000000];
	


	SieveOfEratosthenes(n1, count, primeArry);


	//cout << "running time:" << t2 - t1 << "ms" << endl;
	//cout << primeArry[count-1] << endl;
	//cout << primeArry[count-2] << endl;
	//cout << primeArry[0] << endl;
	//cout << primeArry[1] << endl ;
	//cout << count << endl << endl << endl;
	
	if (b <= 400000000){
		DWORD t1 = GetTickCount();
		cout<<"sum is "<< SieveOfEratosthenes1(b)-SieveOfEratosthenes1(a) << endl;
		DWORD t2 = GetTickCount();
		cout << "running time:" << t2 - t1<< "ms";
	}

	else{

		DWORD t3 = GetTickCount();
		long long count1 = 0;
		long long sum1 = 0;
		for (long long n2 = a; n2 <= b; n2++){
			if (isPrime(n2, primeArry, count)){
				//if (count1 == 10000) { cout << "\n" << n; }
				count1++;
				sum1 = sum1 + n2;
			}
		}

		DWORD t4 = GetTickCount();

		cout << "\n" << "count of primes: " << count1 << "\n";

		cout << "sum is " << sum1  << endl;

		cout << "running time:" << t4 - t3 << "ms";
	}

	return 0;
}