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
iconst_0
istore_1
iconst_1
istore_2
Label_LoopStart:
iload_2
iload_0
if_icmpgt Label_LoopOut
iload_1
iload_2
iadd
istore_1
iinc 2 1
goto Label_LoopStart
Label_LoopOut:
iload_1
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