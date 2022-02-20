package task3;

public enum ClothingSizeType {
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    ClothingSizeType(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription(ClothingSizeType clothingSizeType) {
        String result = null;
        switch (clothingSizeType) {
            case XXS:
                result = "Детский размер";
                break;
            case XS:
                result = "Маленький размер";
                break;
            case S:
                result = "Чуть больше маленького размера";
                break;
            case M:
                result = "Средний размер";
                break;
            case L:
                result = "Большой размер";
        }
        return result;
    }
}
