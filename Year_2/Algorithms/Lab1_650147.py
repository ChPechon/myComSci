import math

def calculate(a, b, c) :
    if a == 0 :
        x1 = -c / b
        print('x = %.2f\n', x1)
    else :
        discriminant = math.pow(b, 2) - (4 * a * c)
        if discriminant < 0 :
            print('This calculation\'s result is "a + bi" form')
        else :
            x1 = (-b + math.sqrt(discriminant)) / (2 * a)
            x2 = (-b - math.sqrt(discriminant)) / (2 * a)
            print('x1 =', x1, 'x2 =', x2)
    return 1

print("Fill A, B, C to find x in \ 'Ax^2 + Bx + C = 0'")
a = float(input('a = '))
b = float(input('b = '))
c = float(input('c = '))
calculate(a, b, c)
    
    
# #include <stdio.h>
# #include <math.h>

# double calculate(double a, double b, double c){
#     double x1 ,x2;
#     if(a == 0){
#         x1 = -c/b;
#         printf("x = %.2f\n", x1);
#     }
#     else{
#         double discriminant = (b * b) - (4 * a * c);
#         if(discriminant < 0){
#             printf("This calculation's result is \"a+bi\" form\n=======================");
#         }
#         else{
#             x1 = (-b + sqrt(discriminant)) / (2 * a);
#             x2 = (-b - sqrt(discriminant)) / (2 * a);
#             printf("x1 = %.2f , x2 = %.2f\n=======================" , x1 , x2);
#         }
#     }
#     return 1;
# }

# int main(){

#     double a , b , c;

#     printf("=======================\nFill A,B,C to find x in \'Ax^2+Bx+C=0\' form\n");
#     printf("A = ");
#     scanf("%lf",&a);
#     printf("B = ");
#     scanf("%lf",&b);
#     printf("C = ");
#     scanf("%lf",&c);

    
#     calculate(a,b,c);   

#     return 0;
# }