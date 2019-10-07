    int max=500; void main(){
     int i; int j; intk;
     int rem; int sum;
     i = 2;
     while(i<=max){
                    sum = 0;
                    k = i / 2;
                    j = i;
                    while(j<=k){
                        rem = i % j;
                        if(rem == 0){
                                sum = sum + j;
                            ++j;}
                    }
                    if(i == sum) write(i);
                    ++i;
     }
}