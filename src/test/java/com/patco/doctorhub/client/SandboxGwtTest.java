package com.patco.doctorhub.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.patco.doctorhub.DoctorHub";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}