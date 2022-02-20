package task2;

public class Main {
    public static void main(String[] args) {
        Seasons seasons = new Seasons();
        String a = seasons.likeSeasons(TypeSeasons.SUMMER);
        System.out.println(a);

        System.out.println("-------");

        ISeasons iSeasons = seasons.getSeasons(TypeSeasons.SUMMER);
        ISeasons iSeasons1 = seasons.getSeasons(TypeSeasons.AUTUMN);
        ISeasons iSeasons2 = seasons.getSeasons(TypeSeasons.WINTER);
        ISeasons iSeasons3 = seasons.getSeasons(TypeSeasons.SPRING);
    }
}
