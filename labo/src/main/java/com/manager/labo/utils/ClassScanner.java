package com.manager.labo.utils;

import java.io.File;
import java.net.URL;
import java.util.*;

public class ClassScanner {

    private static final char DOT = '.';
    private static final char SLASH = '/';
    private static final String CLASS_SUFFIX = ".class";
    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    private final String path;

    public ClassScanner(String path) {
        this.path = path;
    }

    public <T> Set<Class<? extends T>> getSubTypes(final Class<T> superType) {
        final Set<Class<? extends T>> classes = new HashSet<>();
        find(path).forEach(aClass -> {
            try {
                final Class<? extends T> subClass = aClass.asSubclass(superType);
                classes.add(subClass);
            } catch (final ClassCastException ignore) {
            }
        });

        return classes;
    }

    public List<Class<?>> find(String scannedPackage) {
        final String scannedPath = scannedPackage.replace(DOT, SLASH);
        final URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }
        final File scannedDir = new File(scannedUrl.getFile());
        final List<Class<?>> classes = new ArrayList<>();
        //noinspection ConstantConditions
        for (final File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    private List<Class<?>> find(final File file, final String scannedPackage) {
        final List<Class<?>> classes = new ArrayList<>();
        final String resource = scannedPackage + DOT + file.getName();
        if (file.isDirectory()) {
            //noinspection ConstantConditions
            for (final File child : file.listFiles()) {
                classes.addAll(find(child, resource));
            }
        } else if (resource.endsWith(CLASS_SUFFIX)) {
            int endIndex = resource.length() - CLASS_SUFFIX.length();
            String className = resource.substring(0, endIndex);
            try {
                classes.add(Class.forName(className));
            } catch (final ClassNotFoundException ignore) {
            }
        }
        return classes;
    }
}
