public enum SuitPowers {
    CLUBS  (0), DIAMONDS (13), HEARTS (26), SPADES (39);

    private int valuesSuit;

     SuitPowers(int valuesSuit){
        this.valuesSuit = valuesSuit;
    }

    public int getValuesSuit() {
        return valuesSuit;
    }
}
