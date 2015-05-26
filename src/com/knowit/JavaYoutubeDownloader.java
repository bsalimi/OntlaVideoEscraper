package com.knowit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JavaYoutubeDownloader {
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getVideoID( String url ){
        String googleaAPI;
        googleaAPI=String.format("https://www.youtube.com/list_ajax?style=" +
                "json&action_get_list=1&list%s",listID);


        int start = url.indexOf("?v=") + 3;
        int end = url.indexOf("&", start);
        if ( end == -1 ){
            end = url.length();
        }

        return url.substring(start, end);
    }

    public String getVideoIDs( String url ){
        int start = url.indexOf("?v=") + 3;
        int end = url.indexOf("&", start);
        if ( end == -1 ){
            end = url.length();
        }

        return url.substring(start, end);
    }

}