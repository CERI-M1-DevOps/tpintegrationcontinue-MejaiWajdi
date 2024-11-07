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
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
     void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
     void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
     void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
     void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))",listeATester.toString());
    }
     @Test
     void modifiePremierVide(){
         listeATester.modifiePremier(1, 2);
         assertEquals("ListeSimple()", listeATester.toString());
     }
    @Test
     void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))",listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
     void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals("ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))",listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
     void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
     void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(1))",listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
     void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(2))",listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
     void supprimeTousListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
     void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals("ListeSimple(Noeud(2))",listeATester.toString());
        assertEquals(1, listeATester.getSize());
    }

    @Test
     void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
     void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
     void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
     void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
     void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
     void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))",listeATester.toString());
    }

    @Test
     void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3))",listeATester.toString());
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
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))",listeATester.toString());
    }

    @Test
     void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))",listeATester.toString());
    }

    @Test
     void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals( "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))",listeATester.toString());
    }

     public void testSupprimePremier() {
         ListeSimple liste = new ListeSimple();
         liste.ajout(1);
         liste.ajout(2);
         liste.ajout(3);

         liste.supprimePremier(2);
         assertEquals("ListeSimple(3, 1)", liste.toString());

         liste.supprimePremier(3);
         assertEquals("ListeSimple(1)", liste.toString());

         liste.supprimePremier(5);
         assertEquals("ListeSimple(1)", liste.toString());

         liste.supprimePremier(1);
         assertEquals("ListeSimple()", liste.toString());
     }
     public void testSupprimePremierAvecElementExistant() {
         ListeSimple liste = new ListeSimple();
         liste.ajout(1);
         liste.ajout(2);

         liste.supprimePremier(2);
         assertEquals("ListeSimple(1)", liste.toString());

         liste.supprimePremier(1);
         assertEquals("ListeSimple()", liste.toString());
     }
     public void testEchanger() {
         ListeSimple liste = new ListeSimple();
         liste.ajout(1);
         liste.ajout(2);
         liste.ajout(3);

         Noeud n1 = liste.tete;
         Noeud n2 = n1.getSuivant();


         liste.echanger(n1, n2);
         assertEquals("ListeSimple(2, 1, 3)", liste.toString());

         liste.echanger(n1, n1);
         assertEquals("ListeSimple(2, 1, 3)", liste.toString());

         Noeud n3 = n2.getSuivant();
         liste.echanger(n1, n3);
         assertEquals("ListeSimple(3, 1, 2)", liste.toString());
     }

 }