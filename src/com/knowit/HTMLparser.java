package com.knowit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by bsalimi on 5/25/15.
 */
public class HTMLparser {

    public Document getdocument(String url) throws IOException {
        Document content=null;
        try {
            content = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public String gettitle(String url) throws IOException {
        Document content=getdocument(url);
        return content.title();
    }
    public String gettext(String url) throws IOException {
        Document content=getdocument(url);
        return content.text();
    }
    public String ExtractYoutubeLinks(String url) throws IOException {
        Document content=getdocument(url);
        Elements youtube;
        String youtubelink;
        youtube=content.getElementsByAttributeValueMatching("src", "youtube");
        youtubelink=youtube.attr("src");

    return youtubelink;
    }

}
