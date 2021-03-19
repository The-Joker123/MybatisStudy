package com.zeng.utils;

import org.junit.Test;

import java.util.UUID;

public class IDutils {
   public static String getId(){
       return UUID.randomUUID().toString().replace("-","");
   }
   @Test
    public void testGetId(){
       System.out.println(getId());
   }
}
