package it.unibo.mvc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberOutputView;
import it.unibo.mvc.view.DrawNumberSwingView;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws ClassNotFoundException {        
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        
        Set<String> viewClassName =  Set.of("DrawNumberOutputView", "DrawNumberSwingView");
        for (String className : viewClassName) {
            try {
                Class<?> clazz = Class.forName("it.unibo.mvc.view." + className);
                for (int i = 0; i < 3; i++) {
                    Object view = clazz.getConstructor().newInstance();
                    
                    if (view instanceof DrawNumberView) {
                        app.addView((DrawNumberView) view);
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
