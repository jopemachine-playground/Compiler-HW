.class public Test
.super java/lang/Object
; strandard initializer
.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 320
.limit locals 320
ldc    3.1 
fstore_1
ldc    4.3 
fstore_2
getstatic java/lang/System/out Ljava/io/PrintStream;
fload_1
fload_2
fadd 
invokevirtual java/io/PrintStream/println(F)V
return
.end method
