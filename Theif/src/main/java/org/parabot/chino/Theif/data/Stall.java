package org.parabot.chino.Theif.data;

public enum Stall {
    CRAFTING(1153604154, 1),
    FOOD(1153620537, 30),
    GENERAL(1153636920, 55),
    MAGIC(1153653303, 85),
    SCIMITAR(1153669686, 95);

    private final int stallId;
    private final int level;

    Stall(int stallId, int level) {
        this.stallId = stallId;
        this.level = level;
    }

    public static Stall bestStall(int tLevel) {
        Stall stall = null;
        for (Stall a : Stall.values()) {
            if (stall == null && a.level <= tLevel) {
                stall = a;
            } else if (stall != null && a.level <= tLevel && stall.level < a.level) {
                stall = a;
            }
        }

        return stall;
    }

    public int getStallId() {
        return stallId;
    }


    @Override
    public String toString() {
        return super.toString().substring(0, 1).toUpperCase()
                + super.toString().toLowerCase().substring(1);
    }
}