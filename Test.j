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
sipush    10
newarray	int
astore_1
aload_1
sipush    1
bipush    2
iastore
aload_1
sipush    4
bipush    3
iastore
getstatic java/lang/System/out Ljava/io/PrintStream;
aload_1
ldc	1
iaload
invokevirtual java/io/PrintStream/println(I)V
return
.end method
