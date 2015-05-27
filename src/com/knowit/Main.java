package com.knowit;



import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        String youtubelink="";
        try {

            String ontlalink = "http://www.ontla.on.ca/web/go2.jsp?locale=en&Page=/webcast/webcast_archive&menuItem=dandp_proceedings";
            HTMLparser htmLparser=new HTMLparser();
            youtubelink=htmLparser.ExtractYoutubeLinks(ontlalink);
        //    System.out.print(youtubelink);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JavaYoutubeDownloader javaYoutubeDownloader=new JavaYoutubeDownloader();
        javaYoutubeDownloader.downloadvideos(youtubelink,"null");
    }
}
