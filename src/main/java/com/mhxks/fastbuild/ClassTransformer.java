package com.mhxks.fastbuild;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class ClassTransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if(!"net.minecraft.tileentity.TileEntityFurnace".equals(transformedName)){
            return basicClass;
        }
        //这里使用了ASM进行动态修改源码
        ClassReader classReader = new ClassReader(basicClass);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor,ClassReader.SKIP_DEBUG);
        return classWriter.toByteArray();


        /*
        ClassReader classReader = new ClassReader(basicClass);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);

        ClassNode cn = new ClassNode();
        classReader.accept(cn,0);
        for (MethodNode method : cn.methods) {
            String methodName = FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(name,method.name,method.desc);
            if(methodName.equals("update")){
                System.out.println("找到了熔炉的update");
                MethodVisitor methodVisitor = new MyMethodVisitor(method);


            }
        }

        cn.accept(cw);
        return cw.toByteArray();*/
    }
    public static void Fu(int burn_time,int cooktime){

    }
    public static class MyClassVisitor extends ClassVisitor{
        public MyClassVisitor(ClassVisitor cv) {
            super(Opcodes.ASM5, cv);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if(name.equals("update")){
                MethodVisitor mv = cv.visitMethod(access,name,desc,signature,exceptions);
                return new MyMethodVisitor(mv);
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }
    public static class MyMethodVisitor extends MethodVisitor
    implements Opcodes {
        public MyMethodVisitor(MethodVisitor methodVisitor) {
            super(Opcodes.ASM5, methodVisitor);
        }

        @Override
        public void visitCode() {
            super.visitCode();
            System.out.println("visitCode");
            mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
            mv.visitLdcInsn("这是动态修改了熔炉的字节码");
            mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V");
        }
    }
    public static class MyFieldVisitor extends FieldVisitor{
        public MyFieldVisitor(FieldVisitor fv) {
            super(Opcodes.ASM5,fv);
        }
    }
}
