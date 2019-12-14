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
ldc 3
putstatic a
getstatic java/lang/System/out Ljava/io/PrintStream;
getstatic a
iload_0
invokevirtual java/io/PrintStream/println(I)V
return
.end method
