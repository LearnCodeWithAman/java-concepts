package designpatterns.builder;

public class Main {

    public static void main(String[] args) {

        User user1 = new User.UserBuilder()
                .setUserId("1")
                .setUserName("Aman")
                .setEmailId("amanvrm543@gmail.com")
                .build();

        System.out.println(user1.toString());

        User user2 = User.UserBuilder.builder()
                .setUserId("2")
                .setUserName("Karan")
                .setEmailId("karanverma065@gmail.com")
                .build();

        System.out.println(user2.toString());

    }
}
