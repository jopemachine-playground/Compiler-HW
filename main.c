#include <stdio.h>
int main() {
    int r, t1, t2, t3;
    r = 0;
    t1 = r;
    r = t1 + 1;
   t1 = r;
    if(t1 != 0){
    r = 0;
    printf("%d", r);
   }
    else{
    r = 0;
    t1 = r;
    r = t1 + 1;
    t1 = r;
    r = t1 + 1;
    printf("%d", r);
   }
    return 1;
}
