#include <stdio.h>
int main() {
    int r, t1, t2, t3;
    r = 0;
    t1 = r;
    r = t1 + 1;
    t1 = r;
    if(t1 != 0){
    r = 0;
    t1 = r;
    r = t1 + 1;
    t1 = r;
    if(t1 != 0){
    r = 0;
    }
    else{
    r = 0;
    }
    }
    else{
    r = 0;
    }
    return 1;
}
