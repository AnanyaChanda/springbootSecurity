package com.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyPassWordEncoder {

	public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("india");
            System.out.println(encoded);
        encoded = encoder.encode("nepal");
          System.out.println(encoded);

	}

}
