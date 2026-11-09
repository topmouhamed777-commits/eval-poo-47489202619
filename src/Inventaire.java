public final class Inventaire {

    private Inventaire() { }

    public static long valeurAssuree(Object[] objets) {
        if (objets == null) {
            return 0L;
        }
        long somme = 0L;
        for (int i = 0; i < objets.length; i++) {
            Object obj = objets[i];
            if (obj instanceof ColisFragile) {
                ColisFragile cf = (ColisFragile) obj;
                somme += cf.getValeurDeclaree();
            }
        }
        return somme;
    }

    public static int[] compterParType(Object[] objets) {
        int[] compteurs = new int[4]; // {standard, express, fragile, autres}
        if (objets == null) {
            return compteurs;
        }
        for (int i = 0; i < objets.length; i++) {
            Object obj = objets[i];
            if (obj == null) {
                continue;
            }
            if (obj instanceof ColisFragile) {
                compteurs[2]++;
            } else if (obj instanceof ColisExpress) {
                compteurs[1]++;
            } else if (obj instanceof ColisStandard) {
                compteurs[0]++;
            } else {
                compteurs[3]++;
            }
        }
        return compteurs;
    }
}
