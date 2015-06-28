package entity;

import javax.xml.bind.annotation.XmlEnumValue;

public class Gem {

    private String gemID;
    private String name;
    public Preciousness preciousness;
    private String origin;
    private VisualParameters visualParameters;
    private float value;

    public enum Preciousness {
        precious {
            public String toString() {
                return "precious";
            }
        },
        semiprecious {
            public String toString() {
                return "semi-precious";
            }
        };

        public static Preciousness getPreciousness(String s) {
            switch (s) {
                case "precious": return Preciousness.precious;
                default: return Preciousness.semiprecious;
            }
        }
    }

    public static class VisualParameters {

        private Color color;
        private int transparency;
        private int gemCut;

        public enum Color {
            blue,
            green,
            red,
            yellow,
            white;

            public static Color getColor(String s) {
                switch (s) {
                    case "blue": return Color.blue;
                    case "green": return Color.green;
                    case "red": return Color.red;
                    case "yellow": return Color.yellow;
                    default: return Color.white;
                }
            }
        }

        public VisualParameters() {

        }

        public VisualParameters(Color color, int transparency, int gemCut) {
            this.color = color;
            this.transparency = transparency;
            this.gemCut = gemCut;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getTransparency() {
            return transparency;
        }

        public void setTransparency(int transparency) {
            this.transparency = transparency;
        }

        public int getGemCut() {
            return gemCut;
        }

        public void setGemCut(int gemCut) {
            this.gemCut = gemCut;
        }

        @Override
        public String toString() {
            return "{" +
                    "color=" + color +
                    ", transparency=" + transparency + "%" +
                    ", gemCut=" + gemCut +
                    '}';
        }
    }

    public Gem() {

    }

    public Gem(String gemID, String name, Preciousness preciousness, String origin, VisualParameters visualParameters, float value) {
        this.gemID = gemID;
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.value = value;
    }

    public String getGemID() {
        return gemID;
    }

    public void setGemID(String gemID) {
        this.gemID = gemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Gem {" +
                "gemID='" + gemID + '\'' +
                "\n name=" + name +
                "\n preciousness=" + preciousness +
                "\n origin=" + origin +
                "\n\t visualParameters=" + visualParameters +
                "\n value=" + value +
                "}\n";
    }

}
