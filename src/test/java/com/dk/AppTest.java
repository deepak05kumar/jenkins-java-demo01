package com.dk;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testAddition() {
        App app = new App();
        assertEquals(30, app.add(10, 20));
    }
}
