//seive and trial combine algorithms



#include <iostream>
#include <math.h>
#include <windows.h> 
#include <stdio.h> 
using namespace std;

bool isprime(long long n){
	if(n==1)return false;
	if(n==2)return true;
	if((n%2==0&&n!=2)||(n%3==0&&n!=3)||(n%5==0&&n!=5)||(n%7==0&&n!=7))
		return false;
	for(long long j = 3;j <= sqrt(n);j+=2){
		if(n%j==0)return false;
	}
	return true;
}
int main(){
	
	long long a;
	long long b;
	cout << "please input the first number:";
	cin >> a;
	cout << "\n"<<"please input the first number:";
	cin >> b;
	
	long  long count = 0;
	DWORD t1 = GetTickCount();
	for(long long n = a;n <= b;n++){	
		if(isprime(n)){
			if(count == 10000) {cout<<"\n"<<n;}
			count++;
		}
		
	}
	DWORD t2 = GetTickCount();
	
	cout<<"\n"<<"count of primes: "<<count<<"\n";
	
	cout<<"running time:"<<t2 - t1<<"ms";
}