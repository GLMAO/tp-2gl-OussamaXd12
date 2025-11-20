package com.polytech;

import com.polytech.tp.Cours;
import com.polytech.tp.CoursBuilder;
import com.polytech.tp.CoursEnLigne;
import com.polytech.tp.Etudiant;
import com.polytech.tp.GestionnaireEmploiDuTemps;
import com.polytech.tp.ICours;
import com.polytech.tp.Responsable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cours cours = new CoursBuilder()
                .setMatiere("Math")
                .setEnseignant("oussama")
                .setSalle("Salle 1")
                .setDate("2025-11-21")
                .setHeuredebut("16:00")
                .setEstOptionnel(false)
                .setNiveau("master 1")
                .setNecessiteProjecteur(true)
                .build();
        
        System.out.println("Durée: " + cours.getDuree() + "h");
        
        
        ICours coursEnLigne = new CoursEnLigne(cours);
        System.out.println("Cours décoré : " + coursEnLigne.getDescription());
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
           Etudiant etudiant1 = new Etudiant("oussama");
        Responsable responsable1 = new Responsable("Prof. oussama");

        gestionnaire.attach(etudiant1);
        gestionnaire.attach(responsable1);
        gestionnaire.ajouterCours(coursEnLigne);

        gestionnaire.modifierCours(coursEnLigne, "La salle a été changée à B202");
        gestionnaire.annulerCours(coursEnLigne);

    }
}
