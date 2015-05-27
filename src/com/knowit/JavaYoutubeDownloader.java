package com.knowit;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.FactoryConfigurationError;
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
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// This class download a video from youtube to a local directory

public class JavaYoutubeDownloader {

    public static String gapiplaylist="http://gdata.youtube.com/feeds/api/playlists/";
// the root youtube url
// This method check if a url contains a playlist

    public boolean ifayoutubelink(String url) {

        if (url.contains("youtube"))
            return true;
        return false;
    }
    public boolean ifaplaylist(String url) {

        if (url.contains("videoseries"))
         return true;
        return false;
    }

 // This method check if a url contains a video
    public boolean ifavideo(String url) {
        if (url.contains("?v="))
            return true;
        return false;
    }

// extract a playlist ID from a url

    public String extractplaylistID(String url) {
        int start = url.indexOf("list=") + 5;
        int end = url.indexOf("&", start);
        if ( end == -1 ){
            end = url.length();
        }
        return url.substring(start, end);
    }

// extract a video ID from a url
    public String extractvideoID(String url) {
        int start = url.indexOf("?v=") + 3;
        int end = url.indexOf("&", start);
        if ( end == -1 ){
            end = url.length();
        }
        return url.substring(start, end);
    }
 // This method accept a playlistID and extract list of associated video IDs using googleapi
 // gapiplaylist="http://gdata.youtube.com/feeds/api/playlists/

    private static Document parse (InputStream is) {
        Document ret = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();

            ret = builder.parse(is);
        }
        catch (Exception ex) {
            System.out.println("unable to load XML: " + ex);
        }
        return ret;
    }

    public String extractvideoIDsfromplylist(String playlistID)  {
        String url=gapiplaylist+playlistID;
        HTMLparser test=new HTMLparser();
        XMLReader parser;
        System.out.println(url);
        return null;

    }




    public void downloadvideos(String url,String des) {
        if (! ifayoutubelink(url)) {
            System.out.print("invalid youtube link");
            return;
        }
        if (ifaplaylist(url)) {
            String playlistID=extractplaylistID(url);
            System.out.print(extractvideoIDsfromplylist(playlistID));
        }
    }
}