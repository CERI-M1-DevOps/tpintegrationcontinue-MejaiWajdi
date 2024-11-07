package liste;

public class ListeSimple {
    private long size;
    Noeud tete;

    public long getSize() {
        return size;
    }

    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && !courant.getElement().equals(element))
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement().equals(element))
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement().equals(element)) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && !courant.getElement().equals(element)) {
                precedent = courant;
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    public void supprimeTous(Object element) {
        tete = supprimeTousRecurs(element, tete);
    }

    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement().equals(element)) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        }
        return null;
    }

    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        Noeud courant = tete;
        while (courant.getSuivant().getSuivant() != null) {
            courant = courant.getSuivant();
        }
        return courant;
    }

    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    public Noeud getPrecedent(Noeud r) {
        Noeud precedent = tete;
        Noeud courant = tete.getSuivant();
        while (courant != r && courant != null) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        return courant == null ? null : precedent;
    }

    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2) return;

        Noeud precedentR1 = null, precedentR2 = null;

        // Vérifier si r1 ou r2 est la tête
        if (r1 != tete) precedentR1 = getPrecedent(r1);
        if (r2 != tete) precedentR2 = getPrecedent(r2);

        if (precedentR1 != null) precedentR1.setSuivant(r2);
        else tete = r2;

        if (precedentR2 != null) precedentR2.setSuivant(r1);
        else tete = r1;

        Noeud temp = r2.getSuivant();
        r2.setSuivant(r1.getSuivant());
        r1.setSuivant(temp);
    }
}
