package com.example.listak;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloAppTest {
    public static Boolean isRunningTest = false;

    @BeforeClass
    public  static void testBeforeOnce() {
        System.out.println("BeforeClass");
        isRunningTest = true;
    }

    @AfterClass
    public static void testAfterOnce() {
        System.out.println("AfterClass");
        isRunningTest = false;
    }

    @Test
    public void  testMain() {
        HelloApplication.main(null);
    }

    @Test
    public void testStart() {
        HelloApplication app = new HelloApplication();
        try {
            app.start(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testController() {
        HelloController controller = new HelloController();
        controller.initialize();

        controller.onKittyClick(null);
        controller.onMadarClick(null);
        controller.onGombaClick(null);
        controller.onAddClick(null);
        controller.onDelClick(null);
        controller.onKuka1Click(null);
        controller.onKuka2Click(null);
        controller.onSaveClick(null);
    }
}
