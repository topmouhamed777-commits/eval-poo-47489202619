public abstract class Colis implements Comparable<Colis> {
    private String code;
    private int poids;
    private boolean horsDakar;

    public Colis(String code, int poids, boolean horsDakar) {
        if (poids <= 0) {
            throw new IllegalArgumentException("Le poids doit être strictement supérieur à 0 : " + poids);
        }
        this.code = code;
        this.poids = poids;
        this.horsDakar = horsDakar;
    }

    public String getCode() {
        return code;
    }

    public int getPoids() {
        return poids;
    }

    public boolean isHorsDakar() {
        return horsDakar;
    }

    public long tarif() {
        long t = (long) poids * Parametres.TARIF_KG;
        if (horsDakar) {
            t += Parametres.SURCHARGE_HORS_DAKAR;
        }
        return t;
    }

    public abstract String sigle();

    public abstract int priorite();

    @Override
    public String toString() {
        String zone = horsDakar ? "hors-Dakar" : "Dakar";
        return "[" + sigle() + "] " + code + " " + poids + "kg " + zone + " " + tarif() + " FCFA";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Colis other = (Colis) o;
        if (this.code == null) {
            return other.code == null;
        }
        return this.code.equals(other.code);
    }

    @Override
    public int hashCode() {
        int result = getClass().hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Colis other) {
        if (other == null) {
            return -1;
        }
        // Priorité décroissante
        if (this.priorite() != other.priorite()) {
            return Integer.compare(other.priorite(), this.priorite());
        }
        // À priorité égale, tarif décroissant
        if (this.tarif() != other.tarif()) {
            return Long.compare(other.tarif(), this.tarif());
        }
        // À tarif égal, code croissant
        if (this.code == null && other.code == null) {
            return 0;
        }
        if (this.code == null) {
            return -1;
        }
        if (other.code == null) {
            return 1;
        }
        return this.code.compareTo(other.code);
    }
}
