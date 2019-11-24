.class public Test
.super java/lang/Object
; strandard initializer
.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method
.method public static add(II)I
.limit stack 32
.limit locals 32
iload_0 
iload_1 
iadd 
istore_2
iload_2
ireturn
.end method
.method public static sub(II)I
.limit stack 32
.limit locals 32
iload_0 
iload_1 
isub 
istore_2
iload_2
ireturn
.end method
.method public static div(II)I
.limit stack 32
.limit locals 32
iload_0 
iload_1 
idiv 
istore_2
iload_2
ireturn
.end method
.method public static mul(II)I
.limit stack 32
.limit locals 32
iload_0 
iload_1 
imul 
istore_2
iload_2
ireturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32
ldc 1
istore_1
ldc 0
istore_2
ldc 6 
ldc 2 
invokestatic Test/div(II)I
istore_1
iload_1 
iload_2 
ifeq	label1
pop
ldc 1
label1: 
ifeq	label8
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_1 
ldc 1
isub
iload_2 
ldc 1
iadd
invokestatic Test/add(II)I
ldc 3 
invokestatic Test/mul(II)I
invokevirtual java/io/PrintStream/println(I)V
label8:
return
.end method
