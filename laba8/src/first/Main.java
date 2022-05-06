package first;

import first.connectionWithInetResources;

public class Main {
    public static void main(String[] args) {
        String urlName = "https://oz.by/";
        connectionWithInetResources connection = new connectionWithInetResources();
        connection.getHTML(urlName);
    }
}
