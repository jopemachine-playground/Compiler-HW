.class public Test
.super java/lang/Object
; strandard initializer
.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method
.method public static sum(I)I
.limit stack 32
.limit locals 32
iload_0
iconst_1
if_icmpne Label1
iconst_1
ireturn
Label1:
iload_0
iload_0
iconst_1
isub
invokestatic Test/sum(I)I
iadd
ireturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32
getstatic java/lang/System/out Ljava/io/PrintStream;
bipush 100
invokestatic Test/sum(I)I
invokevirtual java/io/PrintStream/println(I)V
return
.end method