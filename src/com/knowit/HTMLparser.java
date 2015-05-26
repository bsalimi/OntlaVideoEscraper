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
    String url;
    Document content;
    String youtubetLinks;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) throws IOException {
        this.url = url;
        this.getContent();
    }

    private Document getContent() throws IOException {
        try {
            content = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public String gettitle(String URL) {
        return content.title();
    }
    public String getyoutubelinks(String URL) {
        Elements youtube;
        String youtubelink;
        youtube=content.getElementsByAttributeValueMatching("src", "youtube");
        youtubelink=youtube.attr("src");

    return youtubelink;
    }

}
