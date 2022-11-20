package module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;


import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class HomeWork13 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Company company = new Company("USB", "Multi-layered client-server neural-net",
//                "harness real-time e-markets");
//        Geo geo = new Geo(-37.3159, 81.1496);
//        Address address = new Address("Deribasovskaya", "Apt. 557", "Odessa", "65000", geo);
//        User user = new User(10, "Anton Khliebnikov", "Toha", "ant@gmail.com", address,
//                "+380800500019", "www.usb.com", company);


//            TASK 1
//        postUser(user);
//        putUser(user);
//        deleteUser();
//        getAllUsers();
//        getUserById(5);
//        getUserByUsername("Samantha");

//        allCommentsToThePost(5);
        allOpenTasksForUser(6);
    }

    //                      METHODS FOR TASK 1
    public static void postUser(User user) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(user);
        String url = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(s))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void putUser(User user) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(user);
        String url = "https://jsonplaceholder.typicode.com/users/10";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(s))
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void deleteUser() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/10";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void getAllUsers() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void getUserById(int id) throws IOException, InterruptedException {
        String str = "https://jsonplaceholder.typicode.com/users/{id}";
        String url = str.replace("{id}", String.valueOf(id));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    public static void getUserByUsername(String username) throws IOException, InterruptedException {
        String str = "https://jsonplaceholder.typicode.com/users?username={username}";
        String url = str.replace("{username}", username);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }

    //                     METHOD FOR TASK 2
    public static void allCommentsToThePost(Integer userId) throws IOException, InterruptedException {

        String str1 = "https://jsonplaceholder.typicode.com/users/{userId}/posts";
        String url1 = str1.replace("{userId}", String.valueOf(userId));

        String response1 = Jsoup.connect(url1)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type1 = TypeToken
                .getParameterized(List.class, UserPost.class)
                .getType();

        List<UserPost> userPostsList = new Gson().fromJson(response1, type1);

        UserPost userWithMaxPostId = userPostsList.stream()
                .max(Comparator.comparingInt(UserPost::getId))
                .get();

        Integer maxPostIdId = userWithMaxPostId.getId();

        String str2 = "https://jsonplaceholder.typicode.com/posts/{postId}/comments";
        String url2 = str2.replace("{postId}", String.valueOf(maxPostIdId));

        String response2 = Jsoup.connect(url2)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type2 = TypeToken
                .getParameterized(List.class, PostComment.class)
                .getType();

        List<PostComment> postCommentsList = new Gson().fromJson(response2, type2);
        String fileName = "user-X-post-Y-comments.json"
                .replace("X", String.valueOf(userId))
                .replace("Y", String.valueOf(maxPostIdId));

        OutputStream fos = new FileOutputStream(fileName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(postCommentsList);
        fos.write(s.getBytes());
    }

    //                     METHOD FOR TASK 3
    public static void allOpenTasksForUser(Integer userId) throws IOException {
        String str = "https://jsonplaceholder.typicode.com/users/{userId}/todos";
        String url = str.replace("{userId}", String.valueOf(userId));

        String response1 = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken
                .getParameterized(List.class, UserTask.class)
                .getType();

        List<UserTask> userTasksList = new Gson().fromJson(response1, type);

        List<UserTask> tasks = userTasksList.stream()
                .filter(i -> !i.getCompleted()).toList();
        System.out.println("tasks = " + tasks);
    }
}
