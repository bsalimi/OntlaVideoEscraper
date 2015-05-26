package com.knowit;



import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

    public static void main(String[] args) throws IOException {
        String youtubelink="";
        try {

            String ontlalink = "http://www.ontla.on.ca/web/go2.jsp?locale=en&Page=/webcast/webcast_archive&menuItem=dandp_proceedings";
            HTMLparser htmLparser=new HTMLparser();
            htmLparser.setUrl(ontlalink);
            youtubelink=htmLparser.getyoutubelinks(ontlalink);
           // System.out.print(youtubelink);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaYoutubeDownloader javaYoutubeDownloader=new JavaYoutubeDownloader();
        javaYoutubeDownloader.setUrl(youtubelink);
        String videoID=javaYoutubeDownloader.getVideoID(youtubelink);
        System.out.print("ID is"+videoID);
    }
}
