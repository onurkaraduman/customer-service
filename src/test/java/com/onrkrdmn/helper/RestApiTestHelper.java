package com.onrkrdmn.helper;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class RestApiTestHelper {
    public static MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
}
