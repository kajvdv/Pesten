package pesten;

public enum Value {
        TWEE("Twee"),
        DRIE("Drie"),
        VIER("Vier"),
        VIJF("Vijf"),
        ZES("Zes"),
        ZEVEN("Zeven"),
        ACHT("Acht"),
        NEGEN("Negen"),
        TIEN("Tien"),
        BOER("Boer"),
        VROUW("Vrouw"),
        KONING("Koning"),
        AAS("Aas"),
        EMPTY("");

        private String name;

        private Value(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }