public class Main {
    public static void main(String[] args) {
        User user = Find.searchByFirstLine("Ivan", "src/users/");
//        Find.searchByFilename("kkk", "src/users2/");
        System.out.println(user);
    }
}