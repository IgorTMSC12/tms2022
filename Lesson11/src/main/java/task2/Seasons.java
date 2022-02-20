package task2;

public class Seasons {

    public String likeSeasons(TypeSeasons typeSeasons) {
        String result = null;
        switch (typeSeasons) {
            case SUMMER:
                result = "Я люблю лето";
                break;
            case AUTUMN:
                result = "Я люблю осень";
                break;
            case WINTER:
                result = "Я люблю зиму";
                break;
            case SPRING:
                result = "Я люблю весну";
        }
        return result;
    }

    public ISeasons getSeasons(TypeSeasons typeSeasons) {
        ISeasons iSeasons = null;
        switch (typeSeasons) {
            case SUMMER:
                iSeasons = new Summer();
                System.out.print(TypeSeasons.SUMMER.name());
                System.out.print(" - " + iSeasons.getDescription());
                System.out.println(", " + TypeSeasons.SUMMER.toString());
                break;
            case AUTUMN:
                iSeasons = new Autumn();
                System.out.print(TypeSeasons.AUTUMN.name());
                System.out.print(" - " + iSeasons.getDescription());
                System.out.println(", " + TypeSeasons.AUTUMN.toString());
                break;
            case WINTER:
                iSeasons = new Winter();
                System.out.print(TypeSeasons.WINTER.name());
                System.out.print(" - " + iSeasons.getDescription());
                System.out.println(", " + TypeSeasons.WINTER.toString());
                break;
            case SPRING:
                iSeasons = new Spring();
                System.out.print(TypeSeasons.SPRING.name());
                System.out.print(" - " + iSeasons.getDescription());
                System.out.println(", " + TypeSeasons.SPRING.toString());
                break;
        }
        return iSeasons;
    }
}
