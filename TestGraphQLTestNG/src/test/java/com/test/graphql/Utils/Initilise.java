package com.test.graphql.Utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Initilise {



    @BeforeTest(groups = {"graphql"})
    public void setup()
    {
           System.out.println("TestCase Start");
    }

}
