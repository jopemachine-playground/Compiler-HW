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
ldc 2
istore_2
iload_2
ireturn
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32
ldc 4
istore_1
iload_1
ldc 3 
isub 
ifgt	label0
ldc 0
goto	label1
label0: 
ldc 1
label1: 
ifeq	label2
label2:
return
.end method
