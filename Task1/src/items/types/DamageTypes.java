package courses.task1.items.types;

public enum DamageTypes {

    SLASHING {
        public String toString() {
            return "Slashing damage";
        }
    },

    PIERCING {
        public String toString() {
            return "Piercing damage";
        }
    },

    CRUSHING {
        public String toString() {
            return "Crushing damage";
        }
    };

}
