public class Codec {
    private long url_num;
    private Map<String, String> tinyFull = new HashMap<String, String>();
    private Map<String, String> fullTiny = new HashMap<String, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(fullTiny.containsKey(longUrl)) {
            return fullTiny.get(longUrl);
        }
        String tiny = "http://tinyurl.com/"+url_num;
        url_num++;
        tinyFull.put(tiny, longUrl);
        fullTiny.put(longUrl, tiny);
        return tiny;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyFull.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
