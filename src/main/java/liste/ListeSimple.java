package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    void init() {
        listeATester = new ListeSimple();
    }

    @Test
    void listeConstruiteVide() {
        assertNull(listeATester.tete, "La tête doit être null pour une liste vide");
        assertEquals(0, listeATester.getSize(), "La taille doit être 0 pour une liste vide");
    }

    @Test
    void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize(), "La taille doit être de 1 après ajout d'un élément");
    }

    @Test
    void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(2);
        assertNotNull(teteApresPremierAjout, "La tête ne doit pas être null après le premier ajout");
        assertNotSame(teteApresPremierAjout, listeATester.tete, "La tête doit changer après un nouvel ajout");
    }

    @Test
    void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize(), "La taille doit être de 3 après ajout du même élément trois fois");
    }

    @Test
    void toStringDonneTousLesNoeuds() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    void modifiePremierVide(){
        listeATester.modifiePremier(1, 2);
        assertEquals("ListeSimple()", listeATester.toString(), "La modification d'un élément inexistant ne doit rien changer");
    }

    @Test
    void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))", listeATester.toString());
    }

    @Test
    void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(4))", listeATester.toString());
    }

    @Test
    void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete, "La tête doit être null si la liste est vide");
    }

    @Test
    void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(3), Noeud(2))", listeATester.toString());
    }

    @Test
    void supprimeTousListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete, "La tête doit rester null pour une liste vide");
    }

    @Test
    void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier(), "Avant-dernier doit être null pour une liste vide");
    }

    @Test
    void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement(), "Le seul élément avant le dernier doit être lui-même");
    }

    @Test
    void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete, "L'inversion d'une liste vide doit donner une liste vide");
    }

    @Test
    void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))", listeATester.toString());
    }
}
