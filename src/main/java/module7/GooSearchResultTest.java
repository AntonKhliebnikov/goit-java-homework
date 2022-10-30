package module7;

import java.util.Arrays;

public class GooSearchResultTest {
    public static void main(String[] args) {
        //test.com
        System.out.println(new GooSearchResult("https://rock.festival.com/?q=nearest").parseDomain());

        //apple.in.mars
        System.out.println(new GooSearchResult("https://office.com/?q=123").parseDomain());
    }
}

class GooSearchResult {
    private String url;

    public GooSearchResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String parseDomain() {
        String[] arr = url.split("/");
        return arr[2];
    }
}