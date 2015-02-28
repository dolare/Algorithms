#include <iostream>
#include <windows.h>
#include "math.h"
#include "stdlib.h"

using namespace std;
const double SPLIT = 0.01;
const int COUNT = 200;
const double PI = 3.1415926;
const int INTERVAL = 300;


int busyTime = 10;
int sleepTime = busyTime;
int startTime = 0;
int main(int argc,_TCHAR *argv){
	DWORD busySpan[COUNT];
	DWORD idleSpan[COUNT];

	int half = INTERVAL / 2;
	double radian = 0.0;
	for (int i = 0; i < COUNT; i++){
		busySpan[i] = (DWORD)(half + (sin(PI*radian)*half));
		idleSpan[i] = INTERVAL - busySpan[i];
		radian + = SPLIT;
	}

	DWORD startTime = 0;
	int j = 0;
	while (true){
		j = j % COUNT;
		startTime = GetTickCount();
		while ((GetTickCount() - startTime) <= busySpan[j]);
		Sleep(inleSpan[j]);
		j++;
	}

	return 0;
}