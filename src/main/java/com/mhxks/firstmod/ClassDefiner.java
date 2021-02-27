package com.mhxks.firstmod;

import net.minecraft.launchwrapper.LaunchClassLoader;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
public class ClassDefiner {
    /*
    这个类不需要过多的研究
    仅仅是为了动态加载类
     */
    public static final ClassDefiner instance = new ClassDefiner();

    private final ProtectionDomain protectionDomain;
    private Method methodDefineClass, methodRunTransformers;

    private ClassDefiner() {
        protectionDomain = AccessController.doPrivileged((PrivilegedAction<ProtectionDomain>) ClassDefiner.class.getProtectionDomain());
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            @Nullable
            public Object run() {
                try {
                    Class<?> loader = Class.forName("java.lang.ClassLoader");
                    methodDefineClass = loader.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class);
                    methodDefineClass.setAccessible(true);
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    public void defineClass(String classPath, byte[] byteOfClass, boolean silence) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        defineClass(classPath, byteOfClass, getClass().getClassLoader(), silence);
    }

    public void defineClass(String className, byte[] b, ClassLoader loader, boolean silence) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        String classPath = className.replace("/", ".").replace("\\", ".");
        runTransformers(loader, classPath, b);
        defineClass(loader, classPath, b);
        Class<?> aClass = Class.forName(classPath, true, loader);
        if (!silence){}//System.out.println("Add Class: " + classPath + ", Load: %s", aClass);
    }

    private void runTransformers(ClassLoader classLoader, String classPath, byte[] b) throws InvocationTargetException, IllegalAccessException {
        if (classLoader instanceof LaunchClassLoader) {
            if (methodRunTransformers == null) {
                try {
                    methodRunTransformers = LaunchClassLoader.class.getDeclaredMethod("runTransformers", String.class, String.class, byte[].class);
                    methodRunTransformers.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        if (methodRunTransformers != null) {
            methodRunTransformers.invoke(classLoader, classPath, classPath, b);
        }
    }

    private void defineClass(ClassLoader classLoader, String classPath, byte[] b) throws InvocationTargetException, IllegalAccessException {
        if (methodDefineClass != null) {
            methodDefineClass.invoke(classLoader, classPath, b, 0, b.length, protectionDomain);
        }
    }

}