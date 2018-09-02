package org.parabot.chino.Theif.data;

public enum Stall {
    BAKER(1265933339, 5),
    FUR(1265966103, 35),
    SILVER(1265998487, 50),
    GEM(1265949339, 75);

        private final int id;
        private final int level;

        Stall(int id, int level) {
            this.id = id;
            this.level = level;
        }

        public static Stall getFittingForLevel(int yourLevel) {
            Stall bestFittingStall = null;
            for (Stall stall : Stall.values()) {
                if (bestFittingStall == null && stall.level <= yourLevel) {
                    bestFittingStall = stall;
                } else if (bestFittingStall != null && stall.level <= yourLevel && bestFittingStall.level < stall.level) {
                    bestFittingStall = stall;
                }
            }

            return bestFittingStall;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return super.toString().substring(0, 1).toUpperCase()
                    + super.toString().toLowerCase().substring(1);
        }
    }

